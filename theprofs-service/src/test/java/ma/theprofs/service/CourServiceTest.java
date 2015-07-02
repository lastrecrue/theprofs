package ma.theprofs.service;

import static org.junit.Assert.assertEquals;
import ma.theprofs.WebApp.WebAppConfig;
import ma.theprofs.service.dto.CourDTO;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@WebAppConfiguration
@ContextConfiguration(classes = WebAppConfig.class)
public class CourServiceTest {

	@Autowired
	CourService service;
	CourDTO cour;

	@Before
	public void setUp() {
		cour = new CourDTO();
		cour.setLibelle("libelle");
		cour.setNiveau("niveau");
		cour.setType("type");
	}

	@Test
	public void findSavedUser() {

		cour = service.add(cour);

		assertEquals(cour, service.findById(cour.getId()));
	}

}
