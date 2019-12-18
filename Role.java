package com.example.mediapp.Role;

import java.util.List;

import javax.persistence.*;

import com.example.mediapp.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonIgnore;


//import com.example.mediapp.user.User;

//import java.util.List;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    long roleID;
    String roleName;
    
    @ManyToMany(mappedBy = "roles")
    @JsonIgnore
    List<User> users;
	 
	 public void addUser(User user) {
		 users.add(user);
		 user.getRoles().add(this);
	    }

	public long getRoleID() {
		return roleID;
	}

	public void setRoleID(long roleID) {
		this.roleID = roleID;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}
