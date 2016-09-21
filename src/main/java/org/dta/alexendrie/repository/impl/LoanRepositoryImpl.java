package org.dta.alexendrie.repository.impl;

import org.dta.alexendrie.core.JpaRepositoryImpl;
import org.dta.alexendrie.model.Loan;
import org.dta.alexendrie.repository.LoanRepository;
import org.springframework.stereotype.Repository;

@Repository
public class LoanRepositoryImpl extends JpaRepositoryImpl<Loan> implements LoanRepository{
	
	@Override
	protected Class<Loan> getEntityClass() {
		return Loan.class;
	}
}