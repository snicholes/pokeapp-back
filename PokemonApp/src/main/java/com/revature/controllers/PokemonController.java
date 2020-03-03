package com.revature.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Pokemon;
import com.revature.services.PokemonService;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {
	@Autowired
	PokemonService pserv;
	
	@GetMapping("/{id}")
	public ResponseEntity<Pokemon> getPokemonById(@PathVariable Integer id) {
		Pokemon p = pserv.getById(id);
		
		if(p!=null) {
			return ResponseEntity.ok(p);
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@GetMapping("/owners/{id}")
	public ResponseEntity<Set<Pokemon>> getPokemonByOwnerId(@PathVariable Integer id) {
		Set<Pokemon> p = pserv.getByPersonId(id);
		
		if(p!=null) {
			return ResponseEntity.ok(p);
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@GetMapping("/encounter/{id}")
	public ResponseEntity<Pokemon> getEncounter(@PathVariable Integer id) {
		Pokemon p = pserv.getRandomByLocationId(id);
		return ResponseEntity.ok(p);
	}
	
	@PostMapping("/{id}")
	public ResponseEntity<Pokemon> updatePokemon(@PathVariable Integer id) {
		Pokemon pokemon = pserv.getById(id);
		
		if(pokemon!=null) {
			Pokemon p = pserv.update(pokemon);
			return ResponseEntity.ok(p);
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@PutMapping
	public ResponseEntity<Pokemon> catchPokemon(@RequestBody Pokemon pokemon) {
		System.out.println(pokemon);
		Pokemon p = pserv.create(pokemon);
		
		if(p!=null) {
			return ResponseEntity.ok(p);
		}
		
		return ResponseEntity.status(HttpStatus.CONFLICT).build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Pokemon> releasePokemon(@PathVariable Integer id) {
		Pokemon p = pserv.getById(id);
		
		if(p!=null) {
			pserv.delete(p);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
}
