package org.dta.alexendrie.member.dao;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.dta.alexendrie.core.DatabaseHelper;
import org.dta.alexendrie.member.model.Member;
import org.dta.alexendrie.subscription.model.Subscription;

public class MemberDAO {
	public static Member consulterMember(int id_member) {
		EntityManager em = DatabaseHelper.createEntityManager();
		
		Member result = em.find(Member.class, id_member);

		em.close();
		
		return result;
	}

	public static Member creationMember(String lastname, String firstname, String mail, Date birthday, String address, Date cotisation, float amount) {
		EntityManager em = DatabaseHelper.createEntityManager();

		DatabaseHelper.beginTx(em);
		
		Subscription subscription = new Subscription(cotisation,amount);
		em.persist(subscription);
		
		Member insertion = new Member(lastname, firstname, mail, birthday, address,subscription);		
		em.persist(insertion);

		DatabaseHelper.commitTxAndClose(em);
		
		return insertion;
	}

	public static List<Member> rechercheMember(Long id, String lastname) {
		EntityManager em = DatabaseHelper.createEntityManager();

		String str_query = "select * from Member m join fetch m.emprunts e join fetch m.subscription";

		if ((id != null) || (lastname != "")) {
			str_query += " where";
			
			if (id != null)
				str_query += " id like " + id + "%";
			
			if (lastname != "")
				str_query += " lastname like %" + lastname + "%";
		}

		TypedQuery<Member> query = em.createQuery(str_query, Member.class);

		return query.getResultList();
	}
}