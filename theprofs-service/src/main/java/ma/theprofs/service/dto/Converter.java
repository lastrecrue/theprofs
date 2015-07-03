package ma.theprofs.service.dto;

import ma.theprofs.dao.model.Annonce;
import ma.theprofs.dao.model.Cour;
import ma.theprofs.dao.model.Personne;

import org.springframework.beans.BeanUtils;

public class Converter {

	public static Annonce convert(AnnonceDTO dto) {
		Annonce annonce = new Annonce();
		BeanUtils.copyProperties(dto, annonce);
		return annonce;
	}

	public static CourDTO convert(Cour entity){
		return null;
		
	}
	
	public static AnnonceDTO convert(Annonce entity) {
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
}
