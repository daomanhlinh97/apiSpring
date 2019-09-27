package com.apirest.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.dao.AccountDAO;
import com.apirest.models.Account;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/Account")
public class AccountController{
	
	@Autowired
	AccountDAO DAO;
	
	/* to save an Account*/
	@PostMapping("/add")
	public String createAccount(@Valid @RequestBody Account req) {
		List<Account> listAcc = DAO.findAll();   
	    
		for(int i=0;i<listAcc.size();i++) {
			if(req.getIdAcc().equals(listAcc.get(i).getIdAcc())==true) {
				return "false";
			}
		}
		DAO.save(req);
		return "true";

	}

	
	/* to save an Account*/
	@PostMapping("/addKey/{idacc}/{key}")
	public String createKey(@PathVariable(value="idacc") String idacc, @PathVariable(value="key") String key) {
		List<Account> listAcc = DAO.findAll();   
	    
		for(int i=0;i<listAcc.size();i++) {
			if(idacc.equals(listAcc.get(i).getIdAcc())==true) {
				listAcc.get(i).setKeygen(key);
				listAcc.get(i).setStatusKey("active");
				DAO.save(listAcc.get(i));
				return "true";
			}
		}
		
		return "false";
	}
	
	
	/* to save an Account*/
	@PostMapping("/updateKey/{idacc}/{statusKey}")
	public String updateKey(@PathVariable(value="idacc") String idacc, @PathVariable(value="statusKey") String statusKey) {
		List<Account> listAcc = DAO.findAll();   
	    
		for(int i=0;i<listAcc.size();i++) {
			if(idacc.equals(listAcc.get(i).getIdAcc())==true) {
				
				listAcc.get(i).setStatusKey(statusKey);
				DAO.save(listAcc.get(i));
				return "true";
			}
		}
		
		return "false";
	}
	
	/*get all Account*/
	@GetMapping("/getall")
	public List<Account> getAllRequest(){
		List <Account> listReq= DAO.findAll();
		
		return DAO.findAll();
	}

	@GetMapping("/login/{idacc}/{pass}")
	public String loginDriver(@PathVariable(value="idacc") String idacc, @PathVariable(value="pass") String pass ){
		
		List<Account> listAcc = DAO.findAll();

		for(int i=0;i<listAcc.size();i++) {
			if(idacc.equals(listAcc.get(i).getIdAcc())==true && pass.equals(listAcc.get(i).getPassword())==true) {
				return "true";
			}
		}		
		return "false";	
	}
	
}
