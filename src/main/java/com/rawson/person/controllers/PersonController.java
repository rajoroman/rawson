package com.rawson.person.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rawson.person.service.PersonService;
import com.rawson.person.service.dto.PersonDTO;
import com.rawson.person.service.dto.RequestDataDTO;

import jakarta.validation.Valid;

@RestController
@RequestMapping("persons")
public class PersonController {
	
	private PersonService personService;
	
	PersonController(PersonService personService){
		this.personService = personService;
	}
	
	@GetMapping
	public ResponseEntity<?> getCustomer(@RequestBody @Valid RequestDataDTO requestData) throws Exception {
		PersonDTO personDTO = personService.findPersonByNumberDocumentAndTypeDocument(requestData);
		return ResponseEntity.status(HttpStatus.OK).body(personDTO);
	}
}
