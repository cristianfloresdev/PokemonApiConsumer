package com.Poke.Team.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pokemon
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer externalId;

    private String name;
    private String type;
    private int hp;
    private int attack;
    private int defense;
    private int speed;



    @ManyToOne
    @JoinColumn(name = "team_id")
    @JsonIgnore
    private Team team;
}
