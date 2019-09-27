package com.apirest;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.models.Account;

@SpringBootApplication
public class ApiRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiRestApplication.class, args);
	}
}

@RestController
class HelloController{
	@GetMapping("/")
	public List<Account> getAllRequest(){
		List <Account> listReq= DAO.findAll();
		
		return DAO.findAll();
	}
}