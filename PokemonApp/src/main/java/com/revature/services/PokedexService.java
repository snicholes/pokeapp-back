package com.revature.services;

import java.util.List;

import com.revature.beans.Pokedex;

public interface PokedexService {
	Pokedex create(Pokedex p);
	List<Pokedex> getAll();
	Pokedex getById(Integer id);
	Pokedex update(Pokedex p);
}
