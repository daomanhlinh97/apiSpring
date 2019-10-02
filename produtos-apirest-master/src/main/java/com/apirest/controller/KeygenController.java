package com.apirest.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.dao.KeygenDAO;
import com.apirest.models.Keygen;


@RestController
@RequestMapping("/keygen")
public class KeygenController{
	
	@Autowired
	KeygenDAO DAO;
	
	/* to save an Account*/
	@PostMapping("/add")
	public String createAccount(@Valid @RequestBody Keygen req) {
		List<Keygen> listAcc = DAO.findAll();   
	    
		for(int i=0;i<listAcc.size();i++) {
			if(req.getAccount().equals(listAcc.get(i).getAccount())==true && req.getKeygen().equals(listAcc.get(i).getKeygen())==true) {
				return "false";
			}
		}
		DAO.save(req);
		return "true";

	}

	
	/*get all Account*/
	@GetMapping("/getall")
	public List<Keygen> getAllRequest(){
		List <Keygen> listReq= DAO.findAll();
		
		return DAO.findAll();
	}
	
	
//	/*get Account by id*/
	@GetMapping("/get/{account}")
	public List<Keygen> getDriverById(@PathVariable(value="account") String acc){
		
		List<Keygen> listKey = DAO.findAll();
		ArrayList<Keygen> list = new ArrayList<Keygen>();
		for(int i=0;i<listKey.size();i++) {
			if(acc.equals(listKey.get(i).getAccount())==true) {
				list.add(listKey.get(i));
			}
		}
		return list;
		
	}
}
