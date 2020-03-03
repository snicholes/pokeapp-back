package com.revature.data;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.revature.beans.Pokemon;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Integer> {
	@Query(value="SELECT p from Pokemon p WHERE p.owner.id = :id")
	public Optional<Set<Pokemon>> findByOwnerId(@Param("id") Integer id);
}
