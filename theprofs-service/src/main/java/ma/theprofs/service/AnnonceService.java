package ma.theprofs.service;

import javax.transaction.Transactional;

import ma.theprofs.dao.model.Annonce;
import ma.theprofs.dao.model.Cour;
import ma.theprofs.dao.model.Personne;
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

	@Override
	protected Annonce convertToEntity(AnnonceDTO dto) {
		Annonce annonce = convert(dto);
		Cour cour = new Cour();
		BeanUtils.copyProperties(dto.getCour(), cour);
		annonce.setCour(cour);
		Personne personne = new Personne();
		BeanUtils.copyProperties(dto.getPersonne(), personne);
		annonce.setPersonne(personne);
		return annonce;
	}

	public Annonce convert(AnnonceDTO dto) {
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
		BeanUtils.copyProperties(cour, courDTO, "annonces");
		annonce.setCour(courDTO);
		Personne personne = entity.getPersonne();
		PersonneDTO personneDTO = new PersonneDTO();
		BeanUtils.copyProperties(personne, personneDTO, "annonces", "notes");
		annonce.setPersonne(personneDTO);
		return annonce;
	}

	public Iterable<AnnonceDTO> findByVilleTypeAndNiveau(String ville, String type, String niveau) {
		return convertToDTOs(repository.findByVilleTypeAndNiveau(ville, type, niveau));
	}

}
