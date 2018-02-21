package com.avviotech.labs.mhn.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.avviotech.labs.mhn.repository.ProviderRepository;

@Controller
public class LoginController {

	@Autowired
	private ProviderRepository providerReporsitory;
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
}
