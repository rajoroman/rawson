package com.rawson.person.service.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties
public class PersonDTO {
	private String firstName;
	private String secondName;
	private String surName;
	private String secondSurName;
	private String phoneNumber;
	private String address;
	private String cityOfResidence;
}
