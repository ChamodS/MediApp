package com.example.mediapp.sos;

import java.util.Date;

//import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mediapp.sos.Response;
import com.example.mediapp.user.User;
import com.example.mediapp.user.UserDTO;
import com.example.mediapp.user.UserRepository;

@Service
public class SosService {
	
	@Autowired
	SosRepository sosRepository;
	
	@Autowired
	UserRepository userRepository;
	
	public Response sos(SosDTO sosDto) {
		// TODO Auto-generated method stub
		Sos em = sosRepository.findById(sosDto.sosid);
		
		if(em==null)
			return new Response("failed","no user with email",null);
		else
			return new Response("success","user found",em);
	}
	
	public Response addSos(SosDTO sosDto) {
		// TODO Auto-generated method stub
		User u = userRepository.findByUid(sosDto.user_id);
		
		UserDTO user = new UserDTO();

		
		System.out.println(u.getName());		
		Sos sos = new Sos();		
		Date date = new Date();
		
		sos.occuredDate = date;
		
		sos.users=u;
		System.out.println(sos);
		sosRepository.save(sos);
		//sosRepository.save(String users.getUid());
		return new Response("success","New sos Details Added Successfully",sos);
	}

}
