package org.dta.alexendrie;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.dta.alexendrie.loan.dao.LoanDAO;
import org.dta.alexendrie.loan.model.Loan;
import org.dta.alexendrie.media.dao.MediaDAO;
import org.dta.alexendrie.media.model.Media;
import org.dta.alexendrie.media.model.MediaType;
import org.dta.alexendrie.member.dao.MemberDAO;
import org.dta.alexendrie.member.model.Member;

public class Run {
	public static void main(String[] args) throws ParseException {

		SimpleDateFormat date1 = new SimpleDateFormat("yyyy-MM-dd");
		Member member1 = MemberDAO.creationMember("Angora", "Marion", "r.aragon@dta.fr", date1.parse("1992-05-12"),
				"10 rue atoulouse lol", date1.parse("2016-08-19"), 42);

		Media media = MediaDAO.creationMedia("Fight Club", "Chuck Palakniuk", MediaType.Livre);

		Loan loan1 = LoanDAO.creationEmprunt(member1, media, date1.parse("2016-08-19"));

		/*
		 * EntityManagerFactory emf =
		 * Persistence.createEntityManagerFactory("unit"); EntityManager em =
		 * emf.createEntityManager();
		 */

	}
}