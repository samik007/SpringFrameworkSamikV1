package com.samik.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.samik.dto.ResponseDto;
import com.samik.util.BasicConstant;

@RestController
public class BasicController {
	
	@Autowired
	private ResponseDto responseDto;
	
	@RequestMapping(value = "/Home", method = RequestMethod.GET)
	public ResponseEntity<ResponseDto> getHomePage() {
		String homePage = "home.jsp";
		try {
			responseDto.setResponseCode(HttpStatus.OK);
			responseDto.setResponseMessage(BasicConstant.HOME_SUCCESS_MSG);
			responseDto.setData((Object) homePage);
			return new ResponseEntity<ResponseDto>(responseDto, responseDto.getResponseCode());
		}catch(Exception e) {
			responseDto.setResponseCode(HttpStatus.INTERNAL_SERVER_ERROR);
			responseDto.setResponseMessage(BasicConstant.HOME_FAILURE_MSG);
			responseDto.setData((Object) null);
			return new ResponseEntity<ResponseDto>(responseDto, responseDto.getResponseCode());
		}
	}	 
}
