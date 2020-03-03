package com.revature.controllers;

import javax.servlet.http.HttpSession;

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

import com.revature.beans.Person;
import com.revature.beans.Pokemon;
import com.revature.services.PersonService;
import com.revature.services.PokemonService;

@RestController
@RequestMapping(path="/person")
public class PersonController {
	@Autowired
	PersonService pserv;
	
	@Autowired
	PokemonService pkserv;
		
	@PostMapping("/new")
	public ResponseEntity<Person> register(Person p) {
		Person created = pserv.create(p);
		return ResponseEntity.ok(created);
	}
	
	@GetMapping
	public ResponseEntity<Person> getLogin(HttpSession session) {
		Person p = (Person) session.getAttribute("person");
		if(p == null) {
			return ResponseEntity.notFound().build();
		}
		Person p1 = pserv.getById(p.getId());
		session.setAttribute("person", p1);
		return ResponseEntity.ok(p1);
	}
	
	@PostMapping
	public ResponseEntity<Person> login(String user, String pass, HttpSession session) {
		Person p = pserv.getByUserPass(user, pass);
		if(p == null) {
			return ResponseEntity.status(404).build();
		}
		session.setAttribute("person", p);
		return ResponseEntity.ok(p);
	}
	
	@DeleteMapping
	public ResponseEntity<Person> logout(HttpSession session) {
		session.invalidate();
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Person> getPersonById(@PathVariable Integer id) {
		Person p = pserv.getById(id);
		if(p == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(pserv.getById(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Person> updatePerson(@RequestBody Person p, @PathVariable Integer id) {
		if (p.getId() != id) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
		Person updated = pserv.getById(id);
		if (p.getItems() != updated.getItems()) {
			updated.setItems(p.getItems());
		}
		if (p.getPokemon() != updated.getPokemon()) {
			for (Pokemon poke : p.getPokemon()) {
				if (!updated.getPokemon().contains(poke)) {
					poke.setOwner(p);
					pkserv.create(poke);
				}
			}
			updated.setPokemon(p.getPokemon());
		}
		pserv.update(updated);
		return ResponseEntity.ok(pserv.getById(id));
	}
	
	@PutMapping("/disp")
	public ResponseEntity<Person> updateDisplayName(@RequestBody Person p) {
		Person updated = pserv.getById(p.getId());
		updated.setDisplayName(p.getDisplayName());
		updated = pserv.update(updated);
		return ResponseEntity.ok(updated);
	}
	
	@PutMapping("/pass")
	public ResponseEntity<Person> updatePassword(String pass, HttpSession session) {
		Person p = (Person) session.getAttribute("person");
		if(p == null) {
			return ResponseEntity.notFound().build();
		}
		Person updated = pserv.getById(p.getId());
		updated.setPasswd(pass);
		updated = pserv.update(updated);
		return ResponseEntity.ok(updated);
	}
}
