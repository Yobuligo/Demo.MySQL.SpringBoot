package com.vpsd.demomysql.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/demo/person")
public class PersonController {

	@Autowired
	IPersonRepository personRepository;

	@GetMapping("/add")
	public @ResponseBody String addUser(@RequestParam(name = "firstname") String firstname,
			@RequestParam(name = "lastname") String lastname, @RequestParam(name = "gender") PersonGender gender) {
		Person person = new Person();
		person.setFirstname(firstname);
		person.setLastname(lastname);
		person.setGender(gender);
		personRepository.save(person);
		return "saved";
	}

	@GetMapping("")
	public @ResponseBody Iterable<Person> findAllPersons() {
		return personRepository.findAll();

	}

	@RequestMapping(method = RequestMethod.GET, path = "/{id}")
	public @ResponseBody Person findById(@PathVariable(name = "id") Long id) {
		return personRepository.findById(id).get();
	}

	@RequestMapping(method = RequestMethod.PUT, path = "/{id}")
	public @ResponseBody Person updateById(@PathVariable(name = "id") Long id, @RequestBody Person person) {
		Person currentPerson = personRepository.findById(id).get();
		currentPerson.setFirstname(person.getFirstname());
		currentPerson.setLastname(person.getLastname());
		currentPerson.setGender(person.getGender());
		personRepository.save(currentPerson);
		return currentPerson;
	}
}
