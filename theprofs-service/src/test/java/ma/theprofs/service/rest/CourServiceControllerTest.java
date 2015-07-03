package ma.theprofs.service.rest;

import org.hamcrest.Matchers;
import org.junit.Test;
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
						MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)));

	}
}
