package org.dta.alexendrie.service;

import org.dta.alexendrie.model.Loan;

public interface LoanService extends GenericService<Loan>{
	public Loan addLoan(Loan loan);
}