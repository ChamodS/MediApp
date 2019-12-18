package com.example.mediapp.Role;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.mediapp.user.User;


@Repository
public interface RoleRepository extends CrudRepository<Role, Long>{
	
	public Role findByRoleName(String roleName);
}
