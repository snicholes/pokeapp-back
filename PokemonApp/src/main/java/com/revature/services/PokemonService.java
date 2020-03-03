package com.revature.services;

import java.util.Set;

import com.revature.beans.Pokemon;

public interface PokemonService {
	Pokemon create(Pokemon pokemon);
	Pokemon getById(Integer id);
	Set<Pokemon> getByPersonId(Integer id);
	Pokemon getRandomByLocationId(Integer id);
	Pokemon update(Pokemon pokemon);
	void delete(Pokemon pokemon);
}
