package org.dta.alexendrie.service.impl;

import org.dta.alexendrie.repository.SubscriptionRepository;
import org.dta.alexendrie.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("subscriptionService")
public class SubscriptionServiceImpl implements SubscriptionService{
	@Autowired private SubscriptionRepository subscriptionRepository;
}