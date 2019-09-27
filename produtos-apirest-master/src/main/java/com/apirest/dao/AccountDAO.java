package com.apirest.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.models.Account;
import com.apirest.repository.AccountRepository;

@Service
public class AccountDAO {
	
	@Autowired
	AccountRepository AccountRepository;
	
	/*to save an Request*/
	
	public Account save(Account dri) {
		return AccountRepository.save(dri);
	}
	
	
	/* search all Request*/
	
	public List<Account> findAll(){
		return AccountRepository.findAll();
	}
	
	
	/*delete an Request*/
	public void delete(Account dri) {
		AccountRepository.delete(dri);
	}
	
}
