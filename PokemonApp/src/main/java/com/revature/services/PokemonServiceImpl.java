package com.revature.services;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.LocationPokedex;
import com.revature.beans.Pokemon;
import com.revature.data.LocationRepository;
import com.revature.data.PokedexRepository;
import com.revature.data.PokemonRepository;

@Service
public class PokemonServiceImpl implements PokemonService {
	@Autowired
	PokemonRepository pokemonRepository;
	
	@Autowired
	LocationRepository locationRepository;
	
	@Autowired
	PokedexRepository pokedexRepository;
	
	@Override
	public Pokemon create(Pokemon pokemon) {
		return pokemonRepository.save(pokemon);
	}

	@Override
	public Pokemon getById(Integer id) {
		Optional<Pokemon> p = pokemonRepository.findById(id);
		
		if(p.isPresent()) {
			return p.get();
		}
		
		return null;
	}

	@Override
	public Set<Pokemon> getByPersonId(Integer id) {
		Optional<Set<Pokemon>> p = pokemonRepository.findByOwnerId(id);
		
		if(p.isPresent()) {
			return p.get();
		}
		
		return null;
	}
	
	@Override
	public Pokemon getRandomByLocationId(Integer id) {
		Set<LocationPokedex> possiblePoke = locationRepository.findById(id).get().getPokemon();
		List<LocationPokedex> pokeChances = new LinkedList<>();
		
		for(LocationPokedex lp : possiblePoke) {
			for(int i = lp.getMaxLevel();i<=100;i++) {
				pokeChances.add(lp);
			}
		}
		
		if (pokeChances.size() > 0) {
			Random rndm = new Random();
			int i = rndm.nextInt(pokeChances.size());
			Pokemon p = new Pokemon();
			LocationPokedex lp = pokeChances.get(i);
			p.setPokedex(pokedexRepository.findById(lp.getId().getPokedexId()).get());
			p.setNickname(p.getPokedex().getName());
			p.setLvl(rndm.nextInt((lp.getMaxLevel()+1)-lp.getMinLevel()) + lp.getMinLevel());
			p.setMaxHp((p.getLvl() * 4) + rndm.nextInt(3 * p.getLvl()) + 5);
			p.setHp(p.getMaxHp());
			p.setShiny(rndm.nextInt(4096));
			p.setExpPts(0);
			return p;
		}
		
		return null;
	}

	@Override
	public Pokemon update(Pokemon pokemon) {
		Optional<Pokemon> p = pokemonRepository.findById(pokemon.getId());
		
		if(p.isPresent()) {
			return pokemonRepository.save(pokemon);
		}
		
		return null;
	}

	@Override
	public void delete(Pokemon pokemon) {
		pokemonRepository.delete(pokemon);
	}

}
