package com.avviotech.labs.mhn.controllers;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.avviotech.labs.mhn.dto.Patient;
import com.avviotech.labs.mhn.model.PateintProviderModel;
import com.avviotech.labs.mhn.repository.BookingRepository;
import com.avviotech.labs.mhn.repository.PatientRepository;
import com.avviotech.labs.mhn.repository.ProviderRepository;
import com.avviotech.labs.mhn.service.CounterService;

@Controller
public class DashboardController {
	
	@Autowired
	private ProviderRepository providerRepository;
	
	@Autowired
	private BookingRepository bookingRepository;
	
	@Autowired
	private CounterService counterService;
	
	@Autowired
	private PatientRepository patientRepository;
	
	@RequestMapping("/dashboard")
	public String home(ModelMap model) {
		model.addAttribute("pageName","dashbaord");
		return "layout";
	}
	
	@RequestMapping("/bookings")
	public String bookings(ModelMap model) {
		
		
		Collection<Patient> bookings = patientRepository.findAll();
		
		model.addAttribute("bookings",bookings);
		model.addAttribute("pageName","bookings");
		
		getData(model);
		return "layout";
	}
	
	public void getData(ModelMap model)
	{
		Collection<Patient> bookings = patientRepository.findAll();
		Collection<PateintProviderModel> pps = new ArrayList<PateintProviderModel>();
		for(Patient p : bookings)
		{
			RestTemplate restTemplate = new RestTemplate();
			PateintProviderModel models = restTemplate.getForObject("http://127.0.0.1:8089/patient-records?email=" + p.getEmail(), PateintProviderModel.class);
			if(models != null)
				pps.add(models);
			
		}
		
		
		model.addAttribute("pps",pps);
		
		
	}
	
}

