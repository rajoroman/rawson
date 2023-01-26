package com.rawson.person.service;

import com.rawson.person.service.dto.PersonDTO;
import com.rawson.person.service.dto.RequestDataDTO;
import com.rawson.person.service.exception.ExceptionPersonalService;

public interface PersonService {
	PersonDTO findPersonByNumberDocumentAndTypeDocument(RequestDataDTO requestData) throws ExceptionPersonalService;
}
