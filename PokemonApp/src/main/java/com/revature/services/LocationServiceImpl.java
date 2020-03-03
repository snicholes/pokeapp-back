package com.revature.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Location;
import com.revature.beans.LocationPokedex;
import com.revature.data.LocationPokedexRepository;
import com.revature.data.LocationRepository;
import com.revature.data.PokedexRepository;

@Service
public class LocationServiceImpl implements LocationService {
	@Autowired
	LocationRepository locationRepository;
	@Autowired
	LocationPokedexRepository locationPokedexRepository;
	@Autowired
	PokedexRepository pokedexRepository;
	
	@Override
	public Location create(Location location) {
		return locationRepository.save(location);
	}

	@Override
	public Location getById(Integer id) {
		Optional<Location> l = locationRepository.findById(id);
		
		if(!l.isPresent()) {
			return null;
		}
		
		return l.get();
	}

	@Override
	public Location updateLocation(Location location) {
		Optional<Location> l = locationRepository.findById(location.getId());
		
		Location updatedLocation = null;
		
		for(LocationPokedex lp : location.getPokemon()) {
			lp.setLocation(l.get());
			lp.setPokedex(pokedexRepository.findById(lp.getId().getPokedexId()).get());
		}
		
		if(l.isPresent()) {
			try {
				locationPokedexRepository.saveAll(location.getPokemon());
				updatedLocation = locationRepository.save(location);
			} catch (Exception e) {
				System.out.println(e);
				return null;
			}
		} else {
			return null;
		}
		
		return updatedLocation;
	}

}
