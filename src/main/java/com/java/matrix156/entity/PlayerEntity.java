package com.java.matrix156.entity;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name="players")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PlayerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int number;
    @Column(name="player_position")
    private String playerPosition;


}
