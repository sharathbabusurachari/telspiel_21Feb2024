package com.saswath.telspiel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saswath.telspiel.module.Telspiel;
import com.saswath.telspiel.service.SaswathService;

@RestController
@RequestMapping("/saswath")
public class TelspielController {
	
	@Autowired
	SaswathService saswathService;

	@PostMapping(value = "saswathfinance", produces = MediaType.APPLICATION_JSON_VALUE)
	public String saswathStatus(@RequestBody Telspiel telspiel) {
		return saswathService.getSaswathStatus(telspiel);

	}

}
