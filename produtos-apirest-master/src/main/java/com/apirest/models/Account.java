package com.apirest.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.LastModifiedDate;


@Entity
@Table(name="Account")
public class Account implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String status_key;
	
	private String keygen;

	private String password;

	private String name;

	private String gender;
	
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date birth_day;

	private String avatar;
	
	private String id_acc;
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatus_key() {
		return status_key;
	}

	public void setStatus_key(String status_key) {
		this.status_key = status_key;
	}

	public String getKeygen() {
		return keygen;
	}

	public void setKeygen(String keygen) {
		this.keygen = keygen;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirth_day() {
		return birth_day;
	}

	public void setBirth_day(Date birth_day) {
		this.birth_day = birth_day;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getId_acc() {
		return id_acc;
	}

	public void setId_acc(String id_acc) {
		this.id_acc = id_acc;
	}

	

}
