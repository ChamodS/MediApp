package com.example.mediapp;

import com.example.mediapp.storage.StorageService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.annotation.Resource;

@SpringBootApplication
@EnableScheduling
public class MediApp2Application {

	@Resource
	StorageService storageService;

	public static void main(String[] args) {
		SpringApplication.run(MediApp2Application.class, args);
	}


}
