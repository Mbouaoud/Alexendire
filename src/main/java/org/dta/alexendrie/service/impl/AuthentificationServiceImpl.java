package org.dta.alexendrie.service.impl;

import java.util.List;
import org.dta.alexendrie.model.Usr;
import org.dta.alexendrie.repository.AuthentificationRepository;
import org.dta.alexendrie.repository.UsrRepository;
import org.dta.alexendrie.service.AuthentificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthentificationServiceImpl implements AuthentificationService {

	@Autowired
	AuthentificationRepository authentificationRepository;

	public Boolean getLoginConnexion(String login, String password) {
		return authentificationRepository.findUsrbyLogin(login, password);
	}


}