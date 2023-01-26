package com.rawson.person.service.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=false)
@Data
public class ExceptionPersonalService extends Exception {
	
	private static final long serialVersionUID = 1848050345877719458L;
	
	public static final int PERSON_NOT_FOUND = 1;
	public static final String PERSON_NOT_FOUND_STRING = "Person not found";
	
	private String message;
	private int code;
	
	public ExceptionPersonalService(int code, String message) {
		super();
		this.code = code;
		this.message = message;
	}
}
