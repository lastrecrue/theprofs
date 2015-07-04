package ma.theprofs.service.rest;

import ma.theprofs.service.dto.NoteProfDTO;
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
public class PersonneServiceControllerTest extends AbstractControllerTest {

	@Test
	public void testRegisterPersonne() throws Exception {
		PersonneDTO personneDTO = initPersonne();
		mockMvc
		      .perform(
		            MockMvcRequestBuilders.put("/service/personne").contentType(MediaType.APPLICATION_JSON)
		                  .content(json(personneDTO))).andDo(MockMvcResultHandlers.print())
		      .andExpect(MockMvcResultMatchers.status().isOk())
		      .andExpect(MockMvcResultMatchers.content().contentType(contentType))
		      .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.notNullValue()));
	}

	@Test
	public void testAddNote() throws Exception {
		NoteProfDTO noteProf = initNoteProf();
		mockMvc
		      .perform(
		            MockMvcRequestBuilders.put("/service/personne/note").contentType(MediaType.APPLICATION_JSON)
		                  .content(json(noteProf))).andDo(MockMvcResultHandlers.print())
		      .andExpect(MockMvcResultMatchers.status().isOk());
	}

	private NoteProfDTO initNoteProf() {
		NoteProfDTO noteProf = new NoteProfDTO();
		noteProf.setEleveId(2);
		noteProf.setProfId(3);
		noteProf.setNote(5);
		return noteProf;
	}

	private PersonneDTO initPersonne() {
		PersonneDTO personneDTO = new PersonneDTO();
		personneDTO.setEmail("email test");
		personneDTO.setNom("nom test");
		personneDTO.setPrenom("prenom test");
		personneDTO.setPwd("pwd test");
		return personneDTO;
	}

}
