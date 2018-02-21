package com.avviotech.labs.mhn.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Booking {

	@Id
	private Long id;

	private Long patientid;
	private Long providerid;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getPatientid() {
		return patientid;
	}
	public void setPatientid(Long patientid) {
		this.patientid = patientid;
	}
	public Long getProviderid() {
		return providerid;
	}
	public void setProviderid(Long providerid) {
		this.providerid = providerid;
	}
	
	

}
