package org.dta.alexendrie.loan.repository.impl;

import org.dta.alexendrie.core.JpaRepositoryImpl;
import org.dta.alexendrie.loan.model.Loan;
import org.dta.alexendrie.loan.repository.LoanRepository;
import org.springframework.stereotype.Repository;

@Repository
public class LoanRepositoryImpl extends JpaRepositoryImpl<Loan> implements LoanRepository{
	
	@Override
	protected Class<Loan> getEntityClass() {
		return Loan.class;
	}
}