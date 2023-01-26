package com.rawson.person;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rawson.person.controllers.PersonController;
import com.rawson.person.service.PersonService;
import com.rawson.person.service.dto.RequestDataDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@AutoConfigureMockMvc
@SpringBootTest(classes = RawsonTestApplication.class)
class PersonControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@InjectMocks
	PersonController subject;
	
	@MockBean
	private PersonService personService;
	
	@Before
    public void setup(){
        mockMvc = MockMvcBuilders.standaloneSetup(subject).build();
    }
	
	@Test
	void getCustomerTest() throws Exception {
		ObjectMapper objectmapper = new ObjectMapper(); 
		RequestDataDTO requestDataDTO = new RequestDataDTO();
		requestDataDTO.setTypeDocument("C");
		requestDataDTO.setDocumentNumber("23445322");
		mockMvc.perform(get("/persons")
	                    .content(objectmapper.writeValueAsString(requestDataDTO))
	                    .contentType(MediaType.APPLICATION_JSON))
	            .andExpect(MockMvcResultMatchers.status().isOk())
	            .andReturn()
	            .getResponse();
		
	}
}
