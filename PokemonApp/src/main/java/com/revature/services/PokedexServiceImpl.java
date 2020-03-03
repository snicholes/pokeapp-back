package com.revature.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.revature.beans.Pokedex;
import com.revature.data.PokedexRepository;

@Service
public class PokedexServiceImpl implements PokedexService {
	@Autowired
	PokedexRepository pokedexRepository;
	
	@Override
	public Pokedex create(Pokedex p) {
		return pokedexRepository.save(p);
	}

	@Override
	public List<Pokedex> getAll() {
		return pokedexRepository.findAll(Sort.by("pokedexId"));
	}

	@Override
	public Pokedex getById(Integer id) {
		Optional<Pokedex> dex = pokedexRepository.findById(id);
		if(!dex.isPresent()) {
			return null;
		}
		return dex.get();
	}

	@Override
	public Pokedex update(Pokedex p) {
		Optional<Pokedex> dex = pokedexRepository.findById(p.getPokedexId());
		Pokedex updated = null;
		if(dex.isPresent()) {
			try {
				updated = pokedexRepository.save(p);
			} catch (Exception e) {
				return null;
			}
		}
		return updated;
	}

}
