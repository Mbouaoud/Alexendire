package org.dta.alexendrie.controller;

import org.dta.alexendrie.service.AuthentificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthentificationControllerRest {

	@Autowired
	private AuthentificationService authentificationService;

	@RequestMapping(value = "/rest/connexion_rights", method = RequestMethod.POST)
	public ResponseEntity<Boolean> Authentification(@RequestParam String login, @RequestParam String password) {

		boolean usrFind = false;
		
		if (login != null && password != null) {
			usrFind = authentificationService.getLoginConnexion(login, password);
		}
		
		if(!usrFind)return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		else return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
}