package org.dta.alexendrie.dao;

import java.util.Date;
import javax.persistence.EntityManager;
import org.dta.alexendrie.core.DatabaseHelper;
import org.dta.alexendrie.model.Loan;
import org.dta.alexendrie.model.Media;
import org.dta.alexendrie.model.Member;

public class LoanDAO {
	public static Loan creationEmprunt(Member member, Media media, Date dateEmprunt) {

		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		Loan insertion = new Loan(member, media, dateEmprunt);
		em.persist(insertion);
		DatabaseHelper.commitTxAndClose(em);
		
		return insertion;
	}
}