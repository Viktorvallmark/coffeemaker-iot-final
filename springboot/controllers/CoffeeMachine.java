package com.example.springboot.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoffeeMachine extends Thread{
	
	private boolean on;
	
	public CoffeeMachine() {
		super();
	}
	
	public boolean getOn() {
		return on;
	}
	
	@RequestMapping(value ="/isMachineOn", method = RequestMethod.GET , produces = MediaType.TEXT_HTML_VALUE)
	public String displayStatus () {
		String status = "";
		if(this.on == false) {
			status += "No";
		}else {
			status += "Yes";
		}
		String temp = "";
		temp += "<html><head><title>Is the machine on?</title></head>";
		temp += "<body>";
		temp += "<h4>" + status + "</h4>";
		temp += "</body></html>";
		
		return temp;
	}
	@RequestMapping(value="/toggle", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
	public String toggleMachine() {
		String temp = "";
		temp += "<html><head><title>Toggle the machine</title></head>";
		temp += "<body>";
		if(this.on == false) {
			this.on = true;
			temp += "<html><head><title>Toggle the machine</title></head>";
			temp += "<body>";
			temp += "<h3>The machine is on and is starting to brew coffee </h3>";
			temp += "</body></html>";
			return temp;
		}else if(this.on == true) {
			this.on = false;
			temp += "<html><head><title>Toggle the machine</title></head>";
			temp += "<body>";
			temp += "<h3>The machine is off</h3>";
			temp += "</body></html>";
			return temp;
		}else {
			temp += "<html><head><title>Toggle the machine</title></head>";
			temp += "<body>";
			temp += "<h3>Something very bad has happened </h3>";
			temp += "</body></html>";
		return temp;
		}
	}

}
