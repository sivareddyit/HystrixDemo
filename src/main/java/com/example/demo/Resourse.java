package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/test")
public class Resourse {

	@GetMapping("/hello")
	@HystrixCommand(fallbackMethod = "fallBackHello", commandKey = "hello", groupKey = "hello")
	public String hello() {
		return "Hello World";
	}
	
	public String fallBackHello() {
		return "Siva";
	}

}
