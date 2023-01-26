package com.rawson.person.service.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDTO {
	private boolean hasError;
	private Integer code;
	private List<String>  message;
	private Object  data;
}
