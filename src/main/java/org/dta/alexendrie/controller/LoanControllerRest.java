package org.dta.alexendrie.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.dta.alexendrie.model.Loan;
import org.dta.alexendrie.model.Member;
import org.dta.alexendrie.model.Subscription;
import org.dta.alexendrie.model.Media;
import org.dta.alexendrie.service.LoanService;
import org.dta.alexendrie.service.MediaService;
import org.dta.alexendrie.service.MemberService;
import org.dta.alexendrie.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanControllerRest {

	@Autowired
	private LoanService loanService;

	@Autowired
	private MemberService memberService;

	@Autowired
	private MediaService mediaService;

	@Autowired
	private SubscriptionService subscriptionService;

	@RequestMapping(value = "/resource/loan.ajout", method = RequestMethod.GET)
	public Loan ajoutLoan(@RequestParam("id_media") long id_media, @RequestParam("id_adherent") long id_member,
			@RequestParam("depart") String depart) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		try {
			Date dateemprunt = sdf.parse(depart);
			Member member = memberService.getMemberById(id_member);
			Subscription subscription = subscriptionService.getById(member.getSubscription().getId());
			Media media = mediaService.getMediaById(id_media);
			Loan loan = new Loan(member, media, dateemprunt);
			subscription = subscriptionService.save(subscription);
			member = memberService.save(member);
			media = mediaService.save(media);
			
			loan = loanService.addLoan(loan);
			media.setCurrentLoan(loan);
			mediaService.save(media);
			
			//long idRetour = loan.getId();
			//loan = null;
			member = null;
			media = null;
			subscription = null;
			
			return loan;
			
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return null;
	}
}