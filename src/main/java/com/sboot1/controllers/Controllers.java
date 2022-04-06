package com.sboot1.controllers;

import java.util.InputMismatchException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sboot1.model.Faculty;
import com.sboot1.services.FacultyService;
import com.sboot1.services.UserService;

@RestController
public class Controllers {
	final Logger LOG = LoggerFactory.getLogger(Controllers.class);
	@Autowired
	private FacultyService facultyService;

	//Test2
	
	@Autowired
	private UserService userService;

	@GetMapping("/getAllFacultyDetails1")
	public ResponseEntity<?> getFacultyDetails() {
		LOG.info("The Request came into getFacultyDetails");
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		try {
			String facultyList = facultyService.facultyDetails();
			LOG.info("The faculty details {} ",facultyList);
			return new ResponseEntity<>(facultyList, headers, HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Expectation failed", headers, HttpStatus.EXPECTATION_FAILED);
		}
	}

	@GetMapping("/getAllUserNames1")
	public ResponseEntity<?> getAllUserNames() {
		LOG.info("The Request came into getAllUserNames");
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		try {
			String usernames = userService.userNames();
			LOG.info("The User names{} ", usernames);
			return new ResponseEntity<>(usernames, headers, HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Expectation failed", headers, HttpStatus.EXPECTATION_FAILED);
		}

	}

	@PostMapping("/postFacultyDetails")
	public ResponseEntity<?> postFacutlyDetails(@RequestBody List<Faculty> facultyList) {
		LOG.info("The Request came into postFacutlyDetails");
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		try {
			List<Faculty> newInsertedFacultyDetaisl = facultyService.createFacultyDetails(facultyList);
			LOG.info("newInsertedFacultyDetaisl {}", newInsertedFacultyDetaisl);
			return new ResponseEntity<>(facultyList, headers, HttpStatus.OK);
		}catch(InputMismatchException e) {
			e.printStackTrace();
			LOG.error("The Datatype mismatch");
			return new ResponseEntity<>(e.getMessage(), headers, HttpStatus.PARTIAL_CONTENT);
		}catch(NegativeArraySizeException e) {
			e.printStackTrace();
			LOG.error("The The size of Array Exception");
			return new ResponseEntity<>(e.getMessage(), headers, HttpStatus.INSUFFICIENT_STORAGE);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(e.getMessage(), headers, HttpStatus.FAILED_DEPENDENCY);


		}

	}}



