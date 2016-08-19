package org.dta.alexendrie;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.dta.alexendrie.member.dao.MemberDAO;
import org.dta.alexendrie.member.model.Member;

public class Run {
	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat date1 = new SimpleDateFormat("yyyy-mm-dd");
		Member member1 = MemberDAO.creationMember("Aragon", "Romain", "r.aragon@dta.fr", date1.parse("1992-05-12"), "10 rue atoulouse lol", date1.parse("2016-08-19"), 42);
	}
}