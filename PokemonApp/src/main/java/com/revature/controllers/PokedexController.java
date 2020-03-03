package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Pokedex;
import com.revature.services.PokedexService;

@RestController
@RequestMapping("/pokedex")
public class PokedexController {
	@Autowired
	PokedexService pserv;
	
	@GetMapping
	public ResponseEntity<List<Pokedex>> getPokedex() {
		return ResponseEntity.ok(pserv.getAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Pokedex> getPokedexEntry(@PathVariable Integer id) {
		return ResponseEntity.ok(pserv.getById(id));
	}
	
	@PostMapping
	public ResponseEntity<Pokedex> addPokedexEntry(@RequestBody Pokedex p) {
		try {
			return ResponseEntity.ok(pserv.create(p));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}
	
	@PutMapping
	public ResponseEntity<Pokedex> updatePokedexEntry(@RequestBody Pokedex p) {
		try {
			return ResponseEntity.ok(pserv.update(p));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}
}
