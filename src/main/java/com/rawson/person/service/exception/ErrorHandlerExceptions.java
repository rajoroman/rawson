package com.rawson.person.service.exception;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.rawson.person.service.dto.ResponseDTO;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ErrorHandlerExceptions {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDTO> handleValidationErrors(HttpServletRequest request, MethodArgumentNotValidException ex) {
		
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        
        List<String> message = this.buildMessage(fieldErrors);
        
        ResponseDTO responseDTO = ResponseDTO.builder()
        						.hasError(Boolean.TRUE)
        						.code(HttpStatus.BAD_REQUEST.value())
        						.message(message)
        						.build();
        
        return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
    }
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ResponseDTO> runtimeException(HttpServletRequest request, RuntimeException e) {
		ResponseDTO responseDTO = new ResponseDTO();
		HttpStatus httpStatus = HttpStatus.OK; 
		if(e instanceof DataAccessResourceFailureException) {
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
			 responseDTO = ResponseDTO.builder()
					.hasError(Boolean.TRUE)
					.message(Arrays.asList(e.getMessage()))
					.code(httpStatus.value())
					.build();
			
		}
		return new ResponseEntity<>(responseDTO, httpStatus);
	}
	
	@ExceptionHandler(ExceptionPersonalService.class)
	public ResponseEntity<ResponseDTO> runtimeException( ExceptionPersonalService e) {
		ResponseDTO responseDTO = new ResponseDTO();
		HttpStatus httpStatus = HttpStatus.NOT_FOUND; 
			 
		responseDTO = ResponseDTO.builder()
					.hasError(Boolean.TRUE)
					.message(Arrays.asList(e.getMessage()))
					.code(httpStatus.value())
					.build();
			
		return new ResponseEntity<>(responseDTO, httpStatus);
	}
	
	private List<String> buildMessage(List<FieldError> fieldErrors) {
		List<String> message = new ArrayList<>();
		fieldErrors.forEach(field ->{
			message.add(field.getDefaultMessage().toUpperCase());
		});
		return message;
	}
}
