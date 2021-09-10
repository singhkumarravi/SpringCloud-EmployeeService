package com.olive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.olive.consumer.ProfileRestConsumer;

@RestController
@RequestMapping("/emp")
public class EmpRestController {
    @Autowired
  private ProfileRestConsumer consumer;
  
	@RequestMapping("/show")
	public ResponseEntity<String> show(){
		System.out.println("Consumer App Calling!");
		String data = consumer.getDataFromEureka();
		System.out.println("Data :: " + data);
		return ResponseEntity.ok(data);
	}
	
}
