package com.Poke.Team.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Team
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "trainer_id")
    @ToString.Exclude
    @JsonIgnore
    private Trainer trainer;


    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    private List<Pokemon> pokemons = new ArrayList<>();
}
