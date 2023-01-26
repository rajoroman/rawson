package com.rawson.person;

import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.rawson.person.models.entity.Person;
import com.rawson.person.models.repository.PersonRepository;
import com.rawson.person.service.dto.PersonDTO;
import com.rawson.person.service.dto.RequestDataDTO;
import com.rawson.person.serviceImpl.PersonServiceImpl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@AutoConfigureMockMvc
@SpringBootTest(classes = RawsonTestApplication.class)
class PersonServiceImplTest {

	@InjectMocks
	PersonServiceImpl subject;
	
	@Mock
	private PersonRepository personRepository;
	
	@Test
	void findPersonByNumberDocumentAndTypeDocumentTest() throws Exception {
		RequestDataDTO requestData = new RequestDataDTO();
		requestData.setTypeDocument("C");
		requestData.setDocumentNumber("23445322");
		
		Person person = new Person();
		person.setAddress("Calle 189 #45-30");
		person.setCityOfResidence("Bogota");
		person.setDocumentNumber("23445322");
		person.setFirstName("Rafael");
		person.setSecondName("Jose");
		person.setSurName("Roman");
		person.setSecondSurName("Rendon");
		person.setPhoneNumber("3106471031");
		
		when(personRepository.findByDocumentNumberAndTypeDocument(any(), any())).thenReturn(Optional.of(person));
		
		PersonDTO result = subject.findPersonByNumberDocumentAndTypeDocument(requestData);
		assertNotNull(result);
	}
	
	@Test
	void findPersonByNumberDocumentAndTypeDocumentOptionalEmptyTest() throws Exception {
		RequestDataDTO requestData = new RequestDataDTO();
		requestData.setTypeDocument("C");
		requestData.setDocumentNumber("23445322");
		
		when(personRepository.findByDocumentNumberAndTypeDocument(any(), any())).thenReturn(Optional.empty());
		
		Exception exception = assertThrows(Exception.class,
	            ()->{subject.findPersonByNumberDocumentAndTypeDocument(requestData);} );
	}
}
