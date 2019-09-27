package com.apirest.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
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
@Table(name="account")
public class Account implements Serializable{
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="statuskey")
	private String statuskey;
	
	@Column(name="keygen")
	private String keygen;
	
	@Column(name="password")
	private String password;

	@Column(name="name")
	private String name;

	@Column(name="gender")
	private String gender;
	
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	@Column(name="birthday")
	private Date birthday;

	@Column(name="avatar")
	private String avatar;
	
	@Column(name="idacc")
	private String idacc;
	
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

	public String getStatuskey() {
		return statuskey;
	}

	public void setStatuskey(String statuskey) {
		this.statuskey = statuskey;
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

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getIdacc() {
		return idacc;
	}

	public void setIdacc(String idacc) {
		this.idacc = idacc;
	}

}
