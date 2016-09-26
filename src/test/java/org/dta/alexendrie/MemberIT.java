package org.dta.alexendrie;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

@Sql("classpath:test-member.sql")
public class MemberIT extends IntegrationTest {

	@Test
	public void testMemberAccession() throws Exception {
		
		this.mockMvc.perform(get("/resource/member.accession?id=1")).andDo(MockMvcResultHandlers.print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id").value(1))
				.andExpect(jsonPath("$.lastname").value("user"))
				.andExpect(jsonPath("$.firstname").value("user"))
				.andExpect(jsonPath("$.mail").value("user@user.fr"))
				.andExpect(jsonPath("$.address").value("user"))
				.andExpect(jsonPath("$.birthday").value("1985-05-05"))
				.andExpect(jsonPath("$.subscription.id").value(1))
				.andExpect(jsonPath("$.subscription.paymentDate").value("2015-05-05"))
				.andExpect(jsonPath("$.subscription.amount").value(20.0));
	}

	@Test
	public void testMemberRecherche() throws Exception {

		this.mockMvc.perform(get("/member_recherche?id=1&nom=")).andDo(MockMvcResultHandlers.print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$[0].id").value(1))
				.andExpect(jsonPath("$[0].lastname").value("user"))
				.andExpect(jsonPath("$[0].firstname").value("user"))
				.andExpect(jsonPath("$[0].mail").value("user@user.fr"))
				.andExpect(jsonPath("$[0].address").value("user"))
				.andExpect(jsonPath("$[0].birthday").value("1985-05-05"))
				.andExpect(jsonPath("$[0].subscription.id").value(1))
				.andExpect(jsonPath("$[0].subscription.paymentDate").value("2015-05-05"))
				.andExpect(jsonPath("$[0].subscription.amount").value(20.0));
	}

	@Test
	public void testMemberCreation() throws Exception {
		
		this.mockMvc.perform(post("/member_creation")
			    .contentType(MediaType.APPLICATION_JSON)
			    .content("{\"id\":0,"
						+ "\"lastname\":\"user\","
						+ "\"firstname\":\"user\","
						+ "\"mail\":\"user@user.fr\","
						+ "\"birthday\":\"1985-05-05\","
						+ "\"address\":\"user\","
						+ "\"subscription\":{\"id\":2,\"paymentDate\":\"2015-05-05\",\"amount\":20.0}}"
						));

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH");
		Date birthday = sdf.parse("1985-05-05 02");
		Date paymentDate = sdf.parse("2015-05-05 02");
		
		this.mockMvc.perform(get("/resource/member.accession?id=2")).andDo(MockMvcResultHandlers.print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id").value(2))
				.andExpect(jsonPath("$.lastname").value("user"))
				.andExpect(jsonPath("$.firstname").value("user"))
				.andExpect(jsonPath("$.mail").value("user@user.fr"))
				.andExpect(jsonPath("$.address").value("user"))
				.andExpect(jsonPath("$.birthday").value(birthday.getTime()))
				.andExpect(jsonPath("$.subscription.id").value(2))
				.andExpect(jsonPath("$.subscription.paymentDate").value(paymentDate.getTime()))
				.andExpect(jsonPath("$.subscription.amount").value(20.0));
	}

	@Test
	public void testMemberModification() throws Exception {

		this.mockMvc.perform(post("/member_modification")
			    .contentType(MediaType.APPLICATION_JSON)
			    .content("{\"id\":1,"
						+ "\"lastname\":\"user2\","
						+ "\"firstname\":\"user2\","
						+ "\"mail\":\"user2@user.fr\","
						+ "\"birthday\":\"1985-05-05\","
						+ "\"address\":\"user2\","
						+ "\"subscription\":{\"id\":1,\"paymentDate\":\"2015-05-05\",\"amount\":40.0}}"
						))
				.andExpect(status().isOk());

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH");
		Date birthday = sdf.parse("1985-05-05 02");
		Date paymentDate = sdf.parse("2015-05-05 02");
		
		this.mockMvc.perform(get("/resource/member.accession?id=1")).andDo(MockMvcResultHandlers.print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id").value(1))
				.andExpect(jsonPath("$.lastname").value("user2"))
				.andExpect(jsonPath("$.firstname").value("user2"))
				.andExpect(jsonPath("$.mail").value("user2@user.fr"))
				.andExpect(jsonPath("$.address").value("user2"))
				.andExpect(jsonPath("$.birthday").value(birthday.getTime()))
				.andExpect(jsonPath("$.subscription.id").value(1))
				.andExpect(jsonPath("$.subscription.paymentDate").value(paymentDate.getTime()))
				.andExpect(jsonPath("$.subscription.amount").value(40.0));
	}

}
