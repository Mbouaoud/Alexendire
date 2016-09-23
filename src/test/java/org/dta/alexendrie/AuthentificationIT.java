package org.dta.alexendrie;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

@Sql("classpath:test-user-data.sql")
public class AuthentificationIT extends IntegrationTest {

	// @Test
	// // @WithMockUser(authorities = "TEST")
	// public void testGetUser() throws Exception {
	// this.mockMvc.perform(get("/user/{id}",
	// 1)).andDo(MockMvcResultHandlers.print())
	// .andExpect(jsonPath("$.id").value(1)).andExpect(jsonPath("$.login").value("admin@iocean.fr"))
	// .andExpect(status().isOk());
	// }
	//
	// @Test
	// // @WithMockUser(authorities = "TEST")
	// public void testGetNotFoundUser() throws Exception {
	// this.mockMvc.perform(get("/user/{id}",
	// 1)).andDo(MockMvcResultHandlers.print())
	// .andExpect(status().isNotFound());
	// }

	@Test
	public void testAuthentificationOK() throws Exception {
		this.mockMvc.perform(post("/resource/connexion.rights").param("login", "admin").param("password", "admin"))
				.andDo(MockMvcResultHandlers.print()).andExpect(status().isOk()).andExpect(content().string("true"));
	}

}
