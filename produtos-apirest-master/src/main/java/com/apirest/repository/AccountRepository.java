package com.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apirest.models.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{
	Account findById(long id);

}
