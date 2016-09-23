package org.dta.alexendrie.controller;

import org.dta.alexendrie.service.AuthentificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthentificationControllerRest {

	@Autowired
	private AuthentificationService authentificationService;

	@RequestMapping(value = "/resource/connexion.rights", method = RequestMethod.GET)
	public Boolean Authentification(@RequestParam("login") String login, @RequestParam("password") String password) {

		boolean usrFind = false;
		System.out.println(login + " " + password);
		
		if (login != null && password != null) {
			authentificationService.getLoginConnexion(login, password);
		}
		
		return usrFind;
	}
}