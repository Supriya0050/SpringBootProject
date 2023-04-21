package com.example.project.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/signals")
public class SignalHandlerController {

	
	@GetMapping("/{signal}")
	public ResponseEntity<String> handleSignal(@PathVariable("signal") int signal) {
		return new ResponseEntity<>("Dummy rest call", HttpStatus.OK);
	}

}