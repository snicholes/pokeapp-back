package com.revature.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {

}
