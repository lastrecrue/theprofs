package ma.theprofs.dao;

import static org.junit.Assert.assertEquals;
import ma.theprofs.dao.model.TypeCour;
import ma.theprofs.dao.repository.TypeCourRepository;

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
public class TypeCourRepositoryTest {

	@Autowired
	TypeCourRepository typeCourRepository;
	TypeCour typeCour;

	@Before
	public void setUp() {
		typeCour = new TypeCour();
		typeCour.setLibelle("libelle");
		typeCour.setNiveau("niveau");
		typeCour.setType("type");
	}

	@Test
	public void findSavedUserById() {

		typeCour = typeCourRepository.save(typeCour);

		assertEquals(typeCour, typeCourRepository.findOne(typeCour.getId()));
	}

}
