package org.dta.alexendrie.service.impl;

import org.dta.alexendrie.repository.AuthentificationRepository;
import org.dta.alexendrie.service.AuthentificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthentificationServiceImpl implements AuthentificationService {

	@Autowired
	AuthentificationRepository authentificationRepository;

	public Boolean getLoginConnexion(String login, String password) {
		return authentificationRepository.findUsrbyLogin(login, password);
	}
}