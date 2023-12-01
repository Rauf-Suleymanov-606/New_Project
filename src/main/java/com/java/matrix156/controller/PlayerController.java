package com.java.matrix156.controller;

import com.java.matrix156.dto.PlayerDto;
import com.java.matrix156.dto.RequestPlayerDto;
import com.java.matrix156.dto.ResponsePlayerDto;
import com.java.matrix156.dto.UpdatePlayerDto;
import com.java.matrix156.entity.PlayerEntity;
import com.java.matrix156.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
@RequiredArgsConstructor
public class PlayerController {

    private final PlayerService playerService;

    @GetMapping("/get-all")
    public List<ResponsePlayerDto> getAllController() {
        List<ResponsePlayerDto> all = playerService.getAll();
        return all;
    }

    @PostMapping("/save")
    public void saveController(@RequestBody RequestPlayerDto requestPlayerDto) {
        playerService.save(requestPlayerDto);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteController(@PathVariable Long id) {
        playerService.delete(id);
    }

    @PutMapping("/update")
    public void updateController(@RequestBody UpdatePlayerDto updatePlayerDto) {
        playerService.update(updatePlayerDto);
    }
}
