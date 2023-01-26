package com.rawson.person.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "persons")
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private Long id;
	
	@JsonIgnore
	@Column(length = 1, nullable = false)
	private String typeDocument;
	
	@JsonIgnore
	@Column(length = 12, nullable = false, unique = true)
	private String documentNumber;
	
	@Column(length = 20, nullable = false)
	private String firstName;
	
	@Column(length = 20, nullable = true)
	private String secondName;
	
	@Column(length = 20, nullable = false)
	private String surName;
	
	@Column(length = 20, nullable = true)
	private String secondSurName;
	
	@Column(length = 13, nullable = true)
	private String phoneNumber;
	
	@Column(length = 100, nullable = true)
	private String address;
	
	@Column(length = 20, nullable = true)
	private String cityOfResidence;
}
