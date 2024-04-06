package com.java.matrix156.service;

import com.java.matrix156.dto.RequestPlayerDto;
import com.java.matrix156.dto.ResponsePlayerDto;
import com.java.matrix156.dto.UpdatePlayerDto;
import com.java.matrix156.entity.PlayerEntity;
import com.java.matrix156.mapper.PlayerMapper;
import com.java.matrix156.repository.PlayerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PlayerService {
    private final PlayerRepository playerRepository;
    private final PlayerMapper playerMapper;

    public PlayerService(PlayerRepository playerRepository, PlayerMapper playerMapper) {
        this.playerRepository = playerRepository;
        this.playerMapper = playerMapper;
    }

    public List<ResponsePlayerDto> getAll() {
        List<PlayerEntity> all = playerRepository.findAll();
        List<ResponsePlayerDto> responsePlayerDtos = playerMapper.entityToResponseDto(all);
        return responsePlayerDtos;
    }

    public void save(RequestPlayerDto requestPlayerDto) {
        PlayerEntity playerEntity = playerMapper.playerRequestDtoToEntity(requestPlayerDto);
        log.trace("This player saved");
        playerRepository.save(playerEntity);
    }

    public void delete(Long id) {
        PlayerEntity deletedObject = playerRepository.findById(id).orElseThrow();
        playerRepository.delete(deletedObject);
    }

    public void update(UpdatePlayerDto requestPlayerDto) {
        PlayerEntity updatedObject = playerRepository.findById(requestPlayerDto.getId()).orElseThrow();
        playerMapper.update(updatedObject, requestPlayerDto);
        playerRepository.save(updatedObject);

    }
}
