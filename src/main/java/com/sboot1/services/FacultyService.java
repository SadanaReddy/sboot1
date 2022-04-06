package com.sboot1.services;

import java.util.List;

import com.sboot1.model.Faculty;

public interface FacultyService {
	String facultyDetails();
	List<String> createFacultyDetails();
	List<Faculty> createFacultyDetails(List<Faculty> facultyList);
	 

}
