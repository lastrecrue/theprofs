package ma.theprofs.service.rest;

import ma.theprofs.service.dto.CourDTO;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

public class CourServiceControllerTest extends AbstractControllerTest {
	@Test
	public void testFindAll() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/service/cour"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(
						MockMvcResultMatchers.content()
								.contentType(contentType))
				.andExpect(
						MockMvcResultMatchers.jsonPath("$",
								Matchers.hasSize(Matchers.greaterThan(2))));

	}

	@Test
	public void testRegisterCour() throws Exception {
		CourDTO cour = new CourDTO();
		cour.setLibelle("libelle test");
		cour.setNiveau("niveau test");
		cour.setType("type test");
		mockMvc.perform(
				MockMvcRequestBuilders.put("/service/cour")
						.contentType(MediaType.APPLICATION_JSON)
						.content(json(cour)))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(
						MockMvcResultMatchers.content()
								.contentType(contentType))
				.andExpect(
						MockMvcResultMatchers.jsonPath("$.id",
								Matchers.notNullValue()));
		;

	}
}
