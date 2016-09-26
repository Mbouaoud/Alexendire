package org.dta.alexendrie;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.dta.alexendrie.model.MediaType;
import org.junit.Test;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

@Sql("classpath:test-media.sql")
public class MediaIT extends IntegrationTest {

	@Test

	public void testAjoutMedia() throws Exception {
		this.mockMvc.perform(post("/media_creation").param("auteur", "demoi").param("titre", "monlivre").param("type",
				MediaType.Livre.toString()));
		System.out.println(MediaType.Livre.toString());
		this.mockMvc.perform(get("/media_accession?id=1")).andDo(MockMvcResultHandlers.print())
				.andExpect(jsonPath("$.id").value(1))

		.andExpect(jsonPath("$.author").value("demoi")).andExpect(status().isOk());
	}

}