package ma.theprofs.service;

import javax.transaction.Transactional;

import ma.theprofs.dao.model.Personne;
import ma.theprofs.dao.repository.PersonneRepository;
import ma.theprofs.service.dto.PersonneDTO;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PersonneService extends AbstractService<Personne, PersonneDTO> {
	@Autowired
	private PersonneRepository repository;

	public PersonneRepository getRepository() {
		return repository;
	}

	@Override
	protected Personne convertToEntity(PersonneDTO dto) {
		Personne personne = new Personne();
		BeanUtils.copyProperties(dto, personne);
		return personne;
	}

	@Override
	protected PersonneDTO converttoDTO(Personne entity) {
		PersonneDTO personne = new PersonneDTO();
		BeanUtils.copyProperties(entity, personne);
		return personne;
	}

}
