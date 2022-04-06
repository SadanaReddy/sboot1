package com.sboot1.service.impl;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sboot1.model.Faculty;
import com.sboot1.services.FacultyService;

@Service
public class FacultyServiceImpl implements FacultyService {
	final Logger LOG = LoggerFactory.getLogger(FacultyServiceImpl.class);
	@Autowired
	private RestTemplate restTemplate;
	//@Autowired
	//private JdbcTemplate jdbcTemplate;
	@Override
	public String facultyDetails() {
		LOG.info("The request came into facultyDetails method");
		//List<String> newFacultyDetailsList = new ArrayList<>();
		try {
			String facultyDetails = restTemplate.getForObject("http://localhost:8102/test2/getAllFacultyDetials", String.class);
			LOG.info("retrive the faculty details from the URL", facultyDetails);
			if(facultyDetails==null) {
				LOG.info("There is no faculty details to display");
			}
			return facultyDetails;
		}catch(Exception e) {
			e.printStackTrace();
			throw(e);
		}		
	}

	@Override
	public List<Faculty> createFacultyDetails(List<Faculty> facultyList)  {
		LOG.info("The Request came into createFacultyDetails");
		List<Faculty> newFacultyList = new ArrayList<>();
		LOG.info("create new Faculty array");
		try {
			for(int i=0;i<facultyList.size();i++) {
				Faculty faculty = facultyList.get(i);
				LOG.info(" new faculty details from sboot1 {}", faculty);
				newFacultyList.add(faculty);
				LOG.info(" newFacultyList {}", newFacultyList);
			}
		restTemplate.postForObject("http://localhost:8102/test2/postFacultyDetails", newFacultyList, Faculty.class);
		}catch(InputMismatchException e) {
			e.printStackTrace();
			throw(e);
		}catch(NegativeArraySizeException e) {
			e.printStackTrace();
			throw(e);
		}
		return newFacultyList;
	}

	@Override
	public List<String> createFacultyDetails() {
		//ResponseEntity<String> result = restTemplate.postForEntity(uri, employee, String.class);

		return null;
	};


}