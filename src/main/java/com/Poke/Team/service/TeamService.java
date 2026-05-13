package com.Poke.Team.service;

import com.Poke.Team.dto.PokemonApiResponse;
import com.Poke.Team.dto.StatsDTO;
import com.Poke.Team.entity.Pokemon;
import com.Poke.Team.entity.Team;
import com.Poke.Team.repository.PokemonRepository;
import com.Poke.Team.repository.TeamRepository;
import com.Poke.Team.service.external.PokemonApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeamService
{
    private final TeamRepository teamRepository;
    private final PokemonRepository pokemonRepository;
    private final PokemonApiService pokemonApiService;

    public Pokemon addPokemonToTeam(Long teamId, String name)
    {
        //1. Buscamos el team
        Team team = teamRepository.findById(teamId).orElseThrow(() -> new RuntimeException("Team not found"));

        //2.- Consumimos la api
        PokemonApiResponse response = pokemonApiService.getPokemon(name);

        //3.- Transformar (Metemos la logic mapeando), crea y busca
        Pokemon pokemon = pokemonRepository
                .findByExternalId(response.getId())
                        .orElseGet(() -> mapToEntity(response));

        //4.- Relacionamos cada cosa
        pokemon.setTeam(team);
        team.getPokemons().add(pokemon);

        //5.- Guardamos
        return pokemonRepository.save(pokemon);
    }

    private Pokemon mapToEntity(PokemonApiResponse response)
    {
        Pokemon pokemon = new Pokemon();

        pokemon.setExternalId(response.getId());

        pokemon.setName(response.getName());

        for(StatsDTO stat : response.getStats())
        {
            switch (stat.getStat().getName())
            {
                case "hp":
                    pokemon.setHp(stat.getBase_stat());
                    break;

                case "attack":
                    pokemon.setAttack(stat.getBase_stat());
                    break;

                case "defense":
                    pokemon.setDefense(stat.getBase_stat());
                    break;

                case "speed":
                        pokemon.setSpeed(stat.getBase_stat());
                        break;
            }
        }
        return pokemon;
    }
}
