package com.samik.util;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.servlet.NoHandlerFoundException;
import com.samik.controller.BasicController;
import com.samik.dto.ResponseDto;

@RestControllerAdvice(basePackageClasses = BasicController.class)
public class GlobalExceptionHandler {

	@Autowired
	ResponseDto responseDto;

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = JsonProcessingException.class)
	public ResponseEntity<ResponseDto> handleJsonProcessingException(HttpServletRequest request,
			JsonProcessingException e) {
		responseDto.setResponseCode(HttpStatus.BAD_REQUEST);
		responseDto.setResponseMessage(BasicConstant.BAD_REQUEST);
		responseDto.setData(e);
		return new ResponseEntity<ResponseDto>(responseDto, responseDto.getResponseCode());
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = IllegalArgumentException.class)
	public ResponseEntity<ResponseDto> handleIllegalArgumentException(HttpServletRequest request,
			IllegalArgumentException e) {
		responseDto.setResponseCode(HttpStatus.BAD_REQUEST);
		responseDto.setResponseMessage(BasicConstant.BAD_REQUEST);
		responseDto.setData(e);
		return new ResponseEntity<ResponseDto>(responseDto, responseDto.getResponseCode());
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = UnsupportedOperationException.class)
	public ResponseEntity<ResponseDto> handleUnsupportedOperationException(HttpServletRequest request,
			UnsupportedOperationException e) {
		responseDto.setResponseCode(HttpStatus.BAD_REQUEST);
		responseDto.setResponseMessage(BasicConstant.BAD_REQUEST);
		responseDto.setData(e);
		return new ResponseEntity<ResponseDto>(responseDto, responseDto.getResponseCode());
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = MissingServletRequestParameterException.class)
	public ResponseEntity<ResponseDto> handleMissingServletRequestParameterException(HttpServletRequest request,
			MissingServletRequestParameterException e) {
		responseDto.setResponseCode(HttpStatus.BAD_REQUEST);
		responseDto.setResponseMessage(BasicConstant.BAD_REQUEST);
		responseDto.setData(e);
		return new ResponseEntity<ResponseDto>(responseDto, responseDto.getResponseCode());
	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(value = NoHandlerFoundException.class)
	public ResponseEntity<ResponseDto> handleNoHandlerFoundException(HttpServletRequest request,
			NoHandlerFoundException e) {
		responseDto.setResponseCode(HttpStatus.NOT_FOUND);
		responseDto.setResponseMessage(BasicConstant.NOT_FOUND);
		responseDto.setData(e);
		return new ResponseEntity<ResponseDto>(responseDto, responseDto.getResponseCode());
	}

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<ResponseDto> handleException(HttpServletRequest request, Exception e) {
		responseDto.setResponseCode(HttpStatus.INTERNAL_SERVER_ERROR);
		responseDto.setResponseMessage(BasicConstant.INTERNAL_SERVER_ERROR);
		responseDto.setData(e);
		return new ResponseEntity<ResponseDto>(responseDto, responseDto.getResponseCode());
	}
}
