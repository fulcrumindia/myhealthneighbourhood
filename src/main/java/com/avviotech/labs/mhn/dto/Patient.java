package com.avviotech.labs.mhn.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Patient {

	@Id
	private Long id;

	private String firstname;
	private String lastname;
	private String email;
	private String booking_date;
	private String booking_time;
	private String symtoms;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

	public String getSymtoms() {
		return symtoms;
	}

	public void setSymtoms(String symtoms) {
		this.symtoms = symtoms;
	}

	public String getBooking_date() {
		return booking_date;
	}

	public void setBooking_date(String booking_date) {
		this.booking_date = booking_date;
	}

	public String getBooking_time() {
		return booking_time;
	}

	public void setBooking_time(String booking_time) {
		this.booking_time = booking_time;
	}
	
	

}
