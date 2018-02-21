package com.avviotech.labs.mhn.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.avviotech.labs.mhn.dto.Booking;
import com.avviotech.labs.mhn.dto.Patient;
import com.avviotech.labs.mhn.dto.Provider;
import com.avviotech.labs.mhn.repository.BookingRepository;
import com.avviotech.labs.mhn.repository.PatientRepository;
import com.avviotech.labs.mhn.repository.ProviderRepository;
import com.avviotech.labs.mhn.service.CounterService;

@Controller
public class HomeController {

	@Autowired
	private ProviderRepository providerRepository;
	
	@Autowired
	private BookingRepository bookingRepository;
	
	@Autowired
	private CounterService counterService;
	
	@Autowired
	private PatientRepository patientRepository;

	
	@RequestMapping("/aboutus")
	public String aboutus(ModelMap model) {
		model.addAttribute("pageName", "aboutus");
		return "aboutus";
	}
	
	@RequestMapping("/home")
	public String home(ModelMap model) {
		model.addAttribute("pageName", "main");
		return "main";
	}

	@RequestMapping("/")
	public String launch(ModelMap model) {
		model.addAttribute("pageName", "index");
		return "index";
	}

	@RequestMapping("/index")
	public String index(ModelMap model) {
		model.addAttribute("pageName", "index");
		return "index";
	}

	@RequestMapping("/search")
	public String search(ModelMap model) {
		model.addAttribute("providers", providerRepository.findAll());
		model.addAttribute("pageName", "search");
		return "search";
	}

	@RequestMapping("/book-page")
	public String bookPage(ModelMap model,BindingResult result, 
			@RequestParam("providerid") String providerid) {

		if (result.hasErrors()) {
			System.out.println(result.hasErrors());
            return "error";
        }
		
		Provider provider = providerRepository.findByid(Long
				.valueOf(providerid));

		model.addAttribute("provider", provider);
		return "book";
	}
	
	@RequestMapping("/book-patient")
	public String bookPatient(@Valid @ModelAttribute("patient")Patient
			patient,ModelMap model,BindingResult result, 
			@RequestParam("providerid") String providerid) {

		if (result.hasErrors()) {
			System.out.println(result.hasErrors());
            return "error";
        }
		
		
		
		patient.setId(counterService.getNext());
		patientRepository.save(patient);
		
		Booking booking = new Booking();
		booking.setPatientid(patient.getId());
		booking.setProviderid(Long.valueOf(providerid));
		booking.setId(counterService.getNext());
		
		bookingRepository.save(booking);
		
		
		return "success";
	}
	
	@RequestMapping("/book")
	public String book(ModelMap model,
			@RequestParam("providerid") String providerid) {

		Provider provider = providerRepository.findByid(Long
				.valueOf(providerid));

		model.addAttribute("provider", provider);
		return "book";
	}

}
