package ma.theprofs.dao;

import static org.junit.Assert.assertEquals;
import ma.theprofs.dao.model.Cour;
import ma.theprofs.dao.repository.CourRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = DaoConfiguration.class)
public class CourRepositoryTest {

	@Autowired
	CourRepository courRepository;
	Cour cour;

	@Before
	public void setUp() {
		cour = new Cour();
		cour.setLibelle("libelle");
		cour.setNiveau("niveau");
		cour.setType("type");
	}

	@Test
	public void findSavedUser() {

		cour = courRepository.save(cour);

		assertEquals(cour, courRepository.findOne(cour.getId()));
	}

}
