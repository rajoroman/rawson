package com.rawson.person.serviceImpl;

import java.util.Optional;

import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rawson.person.models.entity.Person;
import com.rawson.person.models.repository.PersonRepository;
import com.rawson.person.service.PersonService;
import com.rawson.person.service.dto.PersonDTO;
import com.rawson.person.service.dto.RequestDataDTO;
import com.rawson.person.service.exception.ExceptionPersonalService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PersonServiceImpl implements PersonService {
	
	private static final String ERROR_CONNECTION_DATABASE = "Error connecting database";
	
	private PersonRepository personRepository;
	
	PersonServiceImpl(PersonRepository personRepository){
		this.personRepository = personRepository;
	}
	
	@Override
	public PersonDTO findPersonByNumberDocumentAndTypeDocument(RequestDataDTO requestData) throws ExceptionPersonalService {
		try {
			Optional<Person> personOpt = personRepository.findByDocumentNumberAndTypeDocument(requestData.getDocumentNumber(), requestData.getTypeDocument());
			if(personOpt.isEmpty()) {
				log.info(ExceptionPersonalService.PERSON_NOT_FOUND_STRING);
				throw new ExceptionPersonalService(ExceptionPersonalService.PERSON_NOT_FOUND,ExceptionPersonalService.PERSON_NOT_FOUND_STRING);
			}
			ObjectMapper mapper = new ObjectMapper();
			return mapper.convertValue(personOpt.get(), PersonDTO.class);
			
		}catch(JpaSystemException e) {
			log.error(ERROR_CONNECTION_DATABASE, e);
			throw new RuntimeException(e);
		}
		
	}
}
