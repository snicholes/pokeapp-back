package com.revature.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.LocationPokedex;

@Repository
public interface LocationPokedexRepository extends JpaRepository<LocationPokedex, Integer> {

}
