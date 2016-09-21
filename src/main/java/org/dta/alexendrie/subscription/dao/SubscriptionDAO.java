package org.dta.alexendrie.subscription.dao;

import java.util.Date;
import javax.persistence.EntityManager;

import org.dta.alexendrie.core.DatabaseHelper;
import org.dta.alexendrie.subscription.model.Subscription;

public class SubscriptionDAO {
	public static Subscription consulterSubscription(int id_sub) {
		EntityManager em = DatabaseHelper.createEntityManager();
		
		Subscription result = em.find(Subscription.class, id_sub);

		em.close();
		
		return result;
	}

	public static Subscription creationSubscription(Date paymentDate, float amount) {
		EntityManager em = DatabaseHelper.createEntityManager();

		DatabaseHelper.beginTx(em);
		
		Subscription insertion = new Subscription(paymentDate, amount);

		em.persist(insertion);

		DatabaseHelper.commitTxAndClose(em);
		
		return insertion;
	}
}
