package ma.theprofs.service;

import java.util.List;

import javax.transaction.Transactional;

import ma.theprofs.dao.model.Annonce;
import ma.theprofs.dao.model.Cour;
import ma.theprofs.dao.model.Personne;
import ma.theprofs.dao.model.criterion.AnnonceCriterion;
import ma.theprofs.dao.repository.AnnonceRepository;
import ma.theprofs.service.dto.AnnonceDTO;
import ma.theprofs.service.dto.CourDTO;
import ma.theprofs.service.dto.PersonneDTO;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AnnonceService extends AbstractService<Annonce, AnnonceDTO> {
	@Autowired
	private AnnonceRepository repository;

	public AnnonceRepository getRepository() {
		return repository;
	}

	public List<AnnonceDTO> findAnnoncesByCriterion(
			AnnonceCriterion annonceCriterion) {
		// TODO
		return null;
	}

	@Override
	protected Annonce convertToEntity(AnnonceDTO dto) {
		Annonce annonce = new Annonce();
		BeanUtils.copyProperties(dto, annonce);
		return annonce;
	}

	@Override
	protected AnnonceDTO converttoDTO(Annonce entity) {
		AnnonceDTO annonce = new AnnonceDTO();
		BeanUtils.copyProperties(entity, annonce);
		Cour cour = entity.getCour();
		CourDTO courDTO = new CourDTO();
		BeanUtils.copyProperties(cour, courDTO);
		annonce.setCour(courDTO);
		Personne personne=entity.getPersonne();
		PersonneDTO personneDTO = new PersonneDTO();
		BeanUtils.copyProperties(personne, personneDTO);
		annonce.setPersonne(personneDTO);
		return annonce;
	}

}
