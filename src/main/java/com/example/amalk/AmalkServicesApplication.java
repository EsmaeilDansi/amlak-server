package com.example.amalk;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import javax.annotation.Resource;
import java.util.Collections;

@SpringBootApplication
public class AmalkServicesApplication implements CommandLineRunner {
	@Resource
	FilesStorageService storageService;
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(AmalkServicesApplication.class);
		app.setDefaultProperties(Collections
				.singletonMap("server.port", "8090"));
		app.run(args);

		System.out.println("Start Server Successful .....");


	}


	@Override
	public void run(String... args) throws Exception {
		try{
			storageService.init();
		}catch (Exception e){

		}


	}
}
