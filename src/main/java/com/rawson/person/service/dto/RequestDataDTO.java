package com.rawson.person.service.dto;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RequestDataDTO {
	
	@Size(min=1 , max = 1, message = "El tipo de documento debe ser C o P y máximo 1 caracter")
	@Pattern(regexp = "([C,P])", message = "El tipo de documento debe ser C o P")
	private String typeDocument;
	
	@Size(min=5 , max = 12, message = "El número de documento debe tener entre 5 y 12 números")
	private String documentNumber;
}
