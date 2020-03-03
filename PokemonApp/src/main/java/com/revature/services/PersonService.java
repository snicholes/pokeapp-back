package com.revature.services;

import com.revature.beans.Person;

public interface PersonService {
	Person create(Person person);
	Person getById(Integer id);
	Person getByUserPass(String user, String pass);
	Person update(Person person);
}
