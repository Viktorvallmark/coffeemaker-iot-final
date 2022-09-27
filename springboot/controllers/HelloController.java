package com.example.springboot.controllers;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SuppressWarnings("unused")
@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class})
@RestController
public class HelloController{

    @RequestMapping(value = "/", method = RequestMethod.GET , produces = MediaType.TEXT_HTML_VALUE)
    public String root(){
        String index = "";
        index += "<html><head><title>Coffee maker API</title></head>";
        index += "<body>";
        index += "<h4>Methods for my coffee machine</h4>";
        index += "<ul>";
        index += "<li><a href=\"/isMachineOn\">Checks if the machine is already on</a></li> ";
        index += "<li><a href=\"/toggle\">Turns on/off the coffee machine</a></li>";
        index += "</ul>";
        index += "</body></html>";
        return index;

    }

}
