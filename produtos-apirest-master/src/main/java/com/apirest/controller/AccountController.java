package com.apirest.controller;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;
import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
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


@RestController
@RequestMapping("/account")
public class AccountController{
	
	@Autowired
	AccountDAO DAO;
	
	/* to save an Account*/
	@PostMapping("/add")
	public String createAccount(@Valid @RequestBody Account req) throws NoSuchAlgorithmException {
		List<Account> listAcc = DAO.findAll();   
	    
		for(int i=0;i<listAcc.size();i++) {
			if(req.getAccount().equals(listAcc.get(i).getAccount())==true) {
				return "false";
			}
		}
		
		String hash = "35454B055CC325EA1AF2126E27707052";
	    String password = req.getPassword();
	         
	    MessageDigest md = MessageDigest.getInstance("MD5");
	    md.update(password.getBytes());
	    byte[] digest = md.digest();
	    String myHash = DatatypeConverter
	      .printHexBinary(digest).toUpperCase();
	         
		
	    req.setPassword(myHash);
		DAO.save(req);
		return "true";

	}

	
	
	/* to save an Account*/
//	@PostMapping("/updateKey/{idacc}/{statusKey}")
//	public String updateKey(@PathVariable(value="idacc") String idacc, @PathVariable(value="statusKey") String statusKey) {
//		List<Account> listAcc = DAO.findAll();   
//	    
//		for(int i=0;i<listAcc.size();i++) {
//			if(idacc.equals(listAcc.get(i).getIdacc())==true) {
//				
//				listAcc.get(i).setStatuskey(statusKey);
//				DAO.save(listAcc.get(i));
//				return "true";
//			}
//		}
//		
//		return "false";
//	}
	
	/*get all Account*/
	@GetMapping("/getall")
	public List<Account> getAllRequest(){
		List <Account> listReq= DAO.findAll();
		
		return DAO.findAll();
	}

	@GetMapping("/login/{idacc}/{pass}")
	public String loginDriver(@PathVariable(value="idacc") String idacc, @PathVariable(value="pass") String pass ) throws NoSuchAlgorithmException{
		
		String hash = "35454B055CC325EA1AF2126E27707052";
	    String password = pass;
	         
	    MessageDigest md = MessageDigest.getInstance("MD5");
	    md.update(password.getBytes());
	    byte[] digest = md.digest();
	    String myHash = DatatypeConverter
	      .printHexBinary(digest).toUpperCase();
		
		List<Account> listAcc = DAO.findAll();

		for(int i=0;i<listAcc.size();i++) {
			if(idacc.equals(listAcc.get(i).getAccount())==true && myHash.equals(listAcc.get(i).getPassword())==true) {
				return "true";
			}
		}		
		return "false";	
	}
	
	
//	/*get Account by id*/
	@GetMapping("/get/{idacc}")
	public Account getDriverById(@PathVariable(value="idacc") String idacc){
		
		List<Account> listAcc = DAO.findAll();
		
		for(int i=0;i<listAcc.size();i++) {
			if(idacc.equals(listAcc.get(i).getAccount())==true) {
				return listAcc.get(i);
			}
		}
		Account acc = new Account();
			return acc;
		
	}
}
