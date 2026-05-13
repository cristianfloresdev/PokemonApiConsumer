package com.Poke.Team;

import com.Poke.Team.dto.PokemonApiResponse;
import com.Poke.Team.service.external.PokemonApiService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TeamApplication
{

	public static void main(String[] args) {
		SpringApplication.run(TeamApplication.class, args);
	}

	/*
	@Bean
	CommandLineRunner testApi(PokemonApiService pokemonApiService)
	{
		return args ->
		{
			PokemonApiResponse response = pokemonApiService.getPokemon("metapod");

			System.out.println("Name: " + response.getName());

			response.getStats().forEach(stat -> {
				System.out.println(
						stat.getStat().getName() + ": " + stat.getBase_stat()
				);
			});
		};
	}
	*/
}
