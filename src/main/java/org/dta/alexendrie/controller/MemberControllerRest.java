package org.dta.alexendrie.controller;

import org.dta.alexendrie.model.Member;
import org.dta.alexendrie.model.Subscription;
import org.dta.alexendrie.service.MemberService;
import org.dta.alexendrie.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/")
public class MemberControllerRest {
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private SubscriptionService subscriptionService;
	
	
	@RequestMapping(value = "/member_creation", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean ajoutMember(@RequestBody Member mmb){
		
		Member newMember = mmb;
		Subscription sub = subscriptionService.save(mmb.getSubscription());
		newMember.setSubscription(sub);
		Member check = memberService.save(newMember);
		
		if(check != null){
			return true;
		}else{
			return false;
		}
	}
	
	@RequestMapping(value = "/member_modification", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean modificationMember(@RequestBody Member mmb){
		Member member = memberService.getById(mmb.getId());
		Subscription sub = subscriptionService.getById(member.getSubscription().getId());
		
		sub.setAmount(mmb.getSubscription().getAmount());
		sub.setPaymentDate(mmb.getSubscription().getPaymentDate());
		Subscription newSub = subscriptionService.save(sub);
		
		member.setAddress(mmb.getAddress());
		member.setBirthday(mmb.getBirthday());
		member.setFirstname(mmb.getFirstname());
		member.setLastname(mmb.getLastname());
		member.setMail(mmb.getMail());
		member.setSubscription(newSub);
		Member check = memberService.save(member);
		
		if(check != null){
			return true;
		}else{
			return false;
		}
	}
	
	@RequestMapping(value="/member_recherche", method=RequestMethod.GET)
	public List<Member> rechercheMember(@RequestParam(name="id", required=false) String id, @RequestParam(name="nom", required=false) String nom){
		List<Member> member= null;
		
		if(id == null) id = "";
		if(nom == null) nom = "";
		
		if(id.equals("") && nom.equals("")){
			member = memberService.getMemberAll();
		} else {
			member = memberService.getMemberBy(id, nom);
		}
		
		return member;		
	}

	@RequestMapping(value = "member_accession", method = RequestMethod.GET)
	public Member rechercheMember(@RequestParam("id") long id) {
		return memberService.getMemberById(id);
	}
}