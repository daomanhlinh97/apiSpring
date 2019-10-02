package com.apirest.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.models.Keygen;
import com.apirest.repository.KeygenRepository;

@Service
public class KeygenDAO {
	
	@Autowired
	KeygenRepository AccountRepository;
	
	/*to save an Request*/
	
	public Keygen save(Keygen dri) {
		return AccountRepository.save(dri);
	}
	
	
	/* search all Request*/
	
	public List<Keygen> findAll(){
		return AccountRepository.findAll();
	}
	
	
	/*delete an Request*/
	public void delete(Keygen dri) {
		AccountRepository.delete(dri);
	}
	
}
