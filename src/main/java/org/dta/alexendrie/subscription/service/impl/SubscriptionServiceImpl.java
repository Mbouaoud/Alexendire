package org.dta.alexendrie.subscription.service.impl;

import org.dta.alexendrie.subscription.repository.SubscriptionRepository;
import org.dta.alexendrie.subscription.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("subscriptionService")
public class SubscriptionServiceImpl implements SubscriptionService{
	@Autowired private SubscriptionRepository subscriptionRepository;
}