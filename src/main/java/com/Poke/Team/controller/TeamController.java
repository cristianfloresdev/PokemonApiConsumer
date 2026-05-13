package com.Poke.Team.controller;

import com.Poke.Team.entity.Pokemon;
import com.Poke.Team.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/poke/teams")
@RequiredArgsConstructor
public class TeamController
{
    private final TeamService teamService;

    @PostMapping("/{teamId}/pokemon/{name}")
    public Pokemon addPokemon(@PathVariable Long teamId, @PathVariable String name)
    {
        return teamService.addPokemonToTeam(teamId, name);
    }
}
