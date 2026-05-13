package com.Poke.Team.service.external;

import com.Poke.Team.dto.PokemonApiResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PokemonApiService
{
    private final RestTemplate restTemplate;

    public PokemonApiService()
    {
        this.restTemplate = new RestTemplate();
    }

    //llamamos a la Api, Recibimos el JSON y lo convertimos automáticamente en el DTO
    public PokemonApiResponse getPokemon(String name)
    {
        String url = "https://pokeapi.co/api/v2/pokemon/" + name;

        return restTemplate.getForObject(url, PokemonApiResponse.class);
    }
}
