package ma.theprofs.service.rest;

import ma.theprofs.dao.model.criterion.AnnonceCriterion;
import ma.theprofs.service.AnnonceService;
import ma.theprofs.service.dto.AnnonceDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service/annonce")
public class AnnonceServiceController {

	@Autowired
	private AnnonceService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody AnnonceDTO findById(@PathVariable Integer id) {
		AnnonceDTO annonce = service.findById(id);
		return annonce;
	}

	@RequestMapping(value = {"/{ville}/{type}/{niveau}"}, method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody Iterable<AnnonceDTO> findByVilleTypeAndNiveau(
			@PathVariable String ville, @PathVariable String type,
			@PathVariable String niveau) {

		AnnonceCriterion annonceCriterion = new AnnonceCriterion(ville, type,
				niveau);
		Iterable<AnnonceDTO> annonces = service
				.findAnnoncesByCriterion(annonceCriterion);
		return annonces;
	}

	@RequestMapping(method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody Iterable<AnnonceDTO> findAll() {
		Iterable<AnnonceDTO> annonces = service.findAll();
		return annonces;
	}

}
