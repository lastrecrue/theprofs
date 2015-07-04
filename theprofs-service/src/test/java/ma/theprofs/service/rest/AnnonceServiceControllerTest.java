package ma.theprofs.service.rest;

import ma.theprofs.service.dto.AnnonceDTO;
import ma.theprofs.service.dto.CourDTO;
import ma.theprofs.service.dto.PersonneDTO;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringJUnit4ClassRunner.class)
public class AnnonceServiceControllerTest extends AbstractControllerTest {

	@Test
	public void testRegisterAnnonce() throws Exception {
		AnnonceDTO annonceDTO = initAnnonce();
		mockMvc
		      .perform(
		            MockMvcRequestBuilders.put("/service/annonce").contentType(MediaType.APPLICATION_JSON)
		                  .content(json(annonceDTO))).andDo(MockMvcResultHandlers.print())
		      .andExpect(MockMvcResultMatchers.status().isOk())
		      .andExpect(MockMvcResultMatchers.content().contentType(contentType))
		      .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.notNullValue()));
	}

	@Test
	public void testFindByVilleTypeAndNiveau() throws Exception {

		mockMvc
		      .perform(
		            MockMvcRequestBuilders.get("/service/annonce/criterion").param("type", "2").param("niveau", "1")
		                  .param("ville", "1")).andExpect(MockMvcResultMatchers.status().isOk())
		      .andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.content().contentType(contentType))
		      .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(Matchers.equalTo(2))));
	}

	private AnnonceDTO initAnnonce() {
		AnnonceDTO annonceDTO = new AnnonceDTO();
		annonceDTO.setDiscription("discription test");
		annonceDTO.setVille("ville test");
		PersonneDTO personneDTO = new PersonneDTO();
		personneDTO.setEmail("email test");
		personneDTO.setId(1);
		CourDTO cour = new CourDTO();
		cour.setId(2);
		annonceDTO.setCour(cour);
		annonceDTO.setPersonne(personneDTO);
		return annonceDTO;
	}

}
