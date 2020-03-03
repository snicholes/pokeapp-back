package com.revature.data;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.revature.beans.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
	@Query(value = "SELECT p FROM Person p WHERE p.username=:user and p.passwd=:pass")
	public Optional<Person> findByUserPass(@Param("user") String user, @Param("pass") String pass);
}
