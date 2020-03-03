package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Location;
import com.revature.services.LocationService;

@RestController
@RequestMapping(path="/location")
public class LocationController {
	@Autowired
	LocationService lserv;
	
	@GetMapping("/{id}")
	public ResponseEntity<Location> getLocation(@PathVariable Integer id) {
		Location loc = lserv.getById(id);
		if (loc != null) {
			return ResponseEntity.ok(loc);
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping
	public ResponseEntity<Location> updateLocation(@RequestBody Location location) {
		Location loc = lserv.getById(location.getId());
		if (loc == null) {
			return ResponseEntity.notFound().build();
		}
		loc = lserv.updateLocation(location);
		
		return ResponseEntity.ok(loc);
	}
}
