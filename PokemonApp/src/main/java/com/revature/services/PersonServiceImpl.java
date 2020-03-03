package com.revature.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Person;
import com.revature.data.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService {
	@Autowired
	PersonRepository personRepository;
	
	@Override
	public Person create(Person person) {
		return personRepository.save(person);
	}

	@Override
	public Person getById(Integer id) {
		Optional<Person> p = personRepository.findById(id);
		
		if(!p.isPresent()) {
			return null;
		}
		
		return p.get();
	}

	@Override
	public Person getByUserPass(String user, String pass) {
		Optional<Person> p = personRepository.findByUserPass(user, pass);
		
		if(!p.isPresent()) {
			return null;
		}
		
		return p.get();
	}
	
	@Override
	public Person update(Person person) {
		Optional<Person> p = personRepository.findById(person.getId());
		
		Person updatedPerson = null;
		
		if(p.isPresent()) {
			try {
				updatedPerson = personRepository.save(person);
			} catch (Exception e) {
				return null;
			}
		} else {
			return null;
		}
		
		return updatedPerson;
	}

}
