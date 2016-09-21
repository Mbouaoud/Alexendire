package org.dta.alexendrie.loan.service.impl;

import org.dta.alexendrie.loan.repository.LoanRepository;
import org.dta.alexendrie.loan.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("mediaService")
public class LoanServiceImpl implements LoanService{
	@Autowired private LoanRepository loanRepository;
}