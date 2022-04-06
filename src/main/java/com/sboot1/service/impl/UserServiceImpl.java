package com.sboot1.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sboot1.services.UserService;

@Service
public class UserServiceImpl implements UserService{
	final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public String userNames() {
		LOG.info("The Request came into userNames method");
		//List<String> newUsernameList = new ArrayList<>();
		try {
			String userNames = restTemplate.getForObject("http://localhost:8102/test2/getUserFirstNames", String.class);
			LOG.info("retrive the usernames from the URL", userNames);
			if(userNames==null) {
				LOG.info("There is no names to display");
			}
			return userNames;
			//newUsernameList.add(userNames);
			//return newUsernameList;

		}catch(Exception e) {
			e.printStackTrace();
			throw(e);
		}		
	}
}
