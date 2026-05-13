package com.Poke.Team.dto;

import lombok.Data;

import java.util.List;

@Data
public class PokemonApiResponse
{
    //Aplicamos clases anidadas
    private Integer id;
    private String name;
    private List<StatsDTO> stats;
    private List<TypeDTO> types;
}
