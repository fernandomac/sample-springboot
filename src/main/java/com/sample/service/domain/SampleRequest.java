package com.sample.service.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class SampleRequest {

	@JsonIgnore
	private Long id;
	private String name;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "GMT")
	private Date birth;
	private Double balance;
	
	public SampleRequest() {}
	
	public SampleRequest(Long id, String name, Date birth, Double balance) {
		this.id = id;
		this.name = name;
		this.birth = birth;
		this.balance = balance;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Date getBirth() {
		return birth;
	}
	
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	
	public Double getBalance() {
		return balance;
	}
	
	public void setBalance(Double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "SampleRequest [id=" + id + ", name=" + name + ", birth=" + birth + ", balance=" + balance + "]";
	}
	
}
