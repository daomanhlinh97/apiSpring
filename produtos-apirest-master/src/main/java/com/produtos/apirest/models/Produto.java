package com.produtos.apirest.models;

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
public class Produto implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id;
	
	private String StatusKey;
	
	private String Keygen;

	private String Password;

	private String Name;

	private String Gender;
	
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date BirthDay;

	private String Avatar;
	
	private String IdAcc;
	
	public Produto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public Date getBirthDay() {
		return BirthDay;
	}

	public void setBirthDay(Date birthDay) {
		BirthDay = birthDay;
	}

	public String getAvatar() {
		return Avatar;
	}

	public void setAvatar(String avatar) {
		Avatar = avatar;
	}

	public String getIdAcc() {
		return IdAcc;
	}

	public void setIdAcc(String idAcc) {
		IdAcc = idAcc;
	}

	public String getStatusKey() {
		return StatusKey;
	}

	public void setStatusKey(String statusKey) {
		StatusKey = statusKey;
	}

	public String getKeygen() {
		return Keygen;
	}

	public void setKeygen(String keygen) {
		Keygen = keygen;
	}
	

}
