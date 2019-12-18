package com.example.mediapp.sos;

//import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
@CrossOrigin(origins="*",allowedHeaders="*")
public class SosController {
	
	@Autowired
	SosService sosService;
	
	@PostMapping("/sos")
	public Response sosUser(@RequestBody SosDTO sosDto) {
		return sosService.sos(sosDto);
	}
	
	@PostMapping("/sos/new")
	public Response addSos(@RequestBody SosDTO sosDto) {
		System.out.println(sosDto.user_id);
		return sosService.addSos(sosDto);
	}

}
