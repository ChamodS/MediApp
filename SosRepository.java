package com.example.mediapp.sos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.mediapp.user.User;

//import com.example.mediapp.sos.SosService;
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.stereotype.Repository;

@Repository
public interface SosRepository extends CrudRepository<Sos, Long>{
	public Sos findById(long sosid);
}
