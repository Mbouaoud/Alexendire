package org.dta.alexendrie.repository.impl;

import org.dta.alexendrie.core.JpaRepositoryImpl;
import org.dta.alexendrie.model.Subscription;
import org.dta.alexendrie.repository.SubscriptionRepository;
import org.springframework.stereotype.Repository;

@Repository
public class SubscriptionRepositoryImpl extends JpaRepositoryImpl<Subscription> implements SubscriptionRepository{
	
	@Override
	protected Class<Subscription> getEntityClass() {
		return Subscription.class;
	}
}