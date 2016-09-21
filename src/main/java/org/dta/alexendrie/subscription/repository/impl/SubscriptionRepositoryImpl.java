package org.dta.alexendrie.subscription.repository.impl;

import org.dta.alexendrie.core.JpaRepositoryImpl;
import org.dta.alexendrie.subscription.model.Subscription;
import org.dta.alexendrie.subscription.repository.SubscriptionRepository;
import org.springframework.stereotype.Repository;

@Repository
public class SubscriptionRepositoryImpl extends JpaRepositoryImpl<Subscription> implements SubscriptionRepository{
	
	@Override
	protected Class<Subscription> getEntityClass() {
		return Subscription.class;
	}
}