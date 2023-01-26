package com.rawson.person.models.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.rawson.person.models.entity.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {
	Optional<Person> findByDocumentNumberAndTypeDocument(String documentNumber,String typeDocument);
}
