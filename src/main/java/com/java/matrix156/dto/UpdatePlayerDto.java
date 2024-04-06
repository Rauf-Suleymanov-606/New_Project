package com.java.matrix156.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class UpdatePlayerDto {
    private long id;
    private String name;
    private int number;
    private String playerPosition;
}
