package com.java.matrix156.mapper;

import com.java.matrix156.dto.RequestPlayerDto;
import com.java.matrix156.dto.ResponsePlayerDto;
import com.java.matrix156.dto.UpdatePlayerDto;
import com.java.matrix156.entity.PlayerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;


@Mapper(componentModel = "spring")
public interface PlayerMapper {
    PlayerEntity playerRequestDtoToEntity(RequestPlayerDto requestPlayerDto);
    ResponsePlayerDto entityToResponseDto(PlayerEntity playerEntity);
   List <ResponsePlayerDto> entityToResponseDto(List<PlayerEntity> playerEntity);
   void update(@MappingTarget PlayerEntity playerEntity, UpdatePlayerDto updatePlayerDto);
}
