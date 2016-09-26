package org.dta.alexendrie.service.impl;

import org.dta.alexendrie.core.JpaRepository;
import org.dta.alexendrie.model.Usr;
import org.dta.alexendrie.repository.UsrRepository;
import org.dta.alexendrie.service.UsrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsrServiceImpl implements UsrService{

	@Autowired
	private UsrRepository usrRepository;
	
	@Override
	public JpaRepository<Usr> getRepository() {
		return usrRepository;
	}

}
