package com.revature.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.Pokedex;

@Repository
public interface PokedexRepository extends JpaRepository<Pokedex, Integer> {

}
