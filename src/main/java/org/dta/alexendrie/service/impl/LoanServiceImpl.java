package org.dta.alexendrie.service.impl;

import org.dta.alexendrie.model.Loan;
import org.dta.alexendrie.repository.LoanRepository;
import org.dta.alexendrie.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("loanService")
public class LoanServiceImpl implements LoanService{
	
	@Autowired private LoanRepository loanRepository;

	@Override
	public Loan addLoan(Loan loan) {
		
		return loanRepository.save(loan);
	}
}