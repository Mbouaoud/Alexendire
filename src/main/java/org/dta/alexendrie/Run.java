package org.dta.alexendrie;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Run {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit");
		EntityManager em = emf.createEntityManager();

	}
}