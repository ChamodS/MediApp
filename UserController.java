package com.example.mediapp.user;

import java.util.List;
import java.util.Map;

//import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;

//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@CrossOrigin(origins="*",allowedHeaders="*")
public class UserController {	
	
	@Autowired
	UserService userService;
	
	
	@PostMapping("/addUser")
	public Response addUser(@RequestBody UserDTO userDTO){
		System.out.println(userDTO.email);
		return userService.addUser(userDTO);
	}

	
	@PostMapping("/user/login")
	public Response loginUser(@RequestBody UserDTO userDTO){
		System.out.println(userDTO.roleName);
		return userService.login(userDTO);
	}
	
	@PostMapping("/user/clzStudents")
	public List<UserDTO> findStudents(@RequestBody UserDTO userDTO){
		System.out.println(userDTO.grade);
		return (List<UserDTO>)userService.findStudents(userDTO);
	}
	
	@PostMapping("/user/children")
	public List<UserDTO> findChildren(@RequestBody UserDTO userDTO){
		System.out.println(userDTO.uid);
		return (List<UserDTO>)userService.findChildren(userDTO);
	}
	
	@PostMapping("/user/contactNo")
	public Response getContactNo(@RequestBody Map<String,Object> body){
		//body.get("name");
		System.out.print(body.get("name"));
		return userService.contactNo((String) body.get("name"));
	}
	
	@PostMapping("/getAllStudents")//this api return any user details accordingly to request role
    public List<User> findAllStudents(@RequestBody UserDTO userDTO ){
        String userType=userDTO.roleName;
        System.out.println("controller awa");
        return userService.getAllStudents(userType);
    }
    @PostMapping("/getDataByEmail")
	public UserDTO getDataByEmail(@RequestBody UserDTO userDTO){
		System.out.println(userDTO.email);
		return userService.getDataByEmail(userDTO);
	}
	
	
}

