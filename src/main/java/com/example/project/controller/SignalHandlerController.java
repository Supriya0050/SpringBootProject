package com.example.project.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.service.SignalService;



@RestController
@RequestMapping("/signals")
public class SignalHandlerController {

	@Autowired
	public SignalService signalService;
	
	@PostMapping
	public ResponseEntity<String> handleSignal(@RequestBody int signal) {
		signalService.handleSignal(signal);
		return new ResponseEntity<>("Dummy rest call", HttpStatus.OK);
	}

}