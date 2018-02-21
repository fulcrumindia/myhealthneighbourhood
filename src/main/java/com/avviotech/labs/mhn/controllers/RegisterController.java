package com.avviotech.labs.mhn.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.avviotech.labs.mhn.dto.Provider;
import com.avviotech.labs.mhn.repository.ProviderRepository;
import com.avviotech.labs.mhn.service.CounterService;

@Controller
public class RegisterController {

	@Autowired
	private ProviderRepository providerReporsitory;
	
	@Autowired
	private CounterService counterService;
	
	@RequestMapping("/register")
	public String register() {
		return "register-doctor";
	}
	
	@RequestMapping("/register-doctor")
	public String registerDoctor(@Valid @ModelAttribute("provider")Provider provider,BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			System.out.println(result.hasErrors());
            return "error";
        }
		
		if(!provider.getFirstname().isEmpty())
		{
			provider.setId(counterService.getNext());
			providerReporsitory.save(provider);
		}
		
		return "login";
	}
	
	
}
