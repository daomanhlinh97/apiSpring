package com.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apirest.models.Keygen;

public interface KeygenRepository extends JpaRepository<Keygen, Long>{
	Keygen findById(long id);

}
