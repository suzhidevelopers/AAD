package com.thoughtaccess.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thoughtaccess.model.Account;
import com.thoughtaccess.model.Entitlement;
import com.thoughtaccess.service.AzureADService;

@RestController
public class AzureADController {

	@Autowired
	AzureADService azureADService;

	@GetMapping("/accounts")
	private List<Account> getAccounts() {
		return azureADService.getAccounts();
	}
	
	@GetMapping("/entitlements")
	private List<Entitlement> getEntitlements() {
		return azureADService.getEntitlements();
	}

}