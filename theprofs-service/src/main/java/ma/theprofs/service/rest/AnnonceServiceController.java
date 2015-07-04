package ma.theprofs.service.rest;

import ma.theprofs.service.AnnonceService;
import ma.theprofs.service.dto.AnnonceDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service/annonce")
public class AnnonceServiceController {

	@Autowired
	private AnnonceService service;

	@RequestMapping(value = "/criterion", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody Iterable<AnnonceDTO> findByVilleTypeAndNiveau(@RequestParam(value = "ville") String ville,
	      @RequestParam(value = "type") String type, @RequestParam(value = "niveau") String niveau) {

		Iterable<AnnonceDTO> annonces = service.findByVilleTypeAndNiveau(ville, type, niveau);
		return annonces;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody AnnonceDTO findById(@PathVariable Integer id) {
		AnnonceDTO annonce = service.findById(id);
		return annonce;
	}

	@RequestMapping(method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody Iterable<AnnonceDTO> findAll() {
		Iterable<AnnonceDTO> annonces = service.findAll();
		return annonces;
	}

	@RequestMapping(method = RequestMethod.PUT, consumes = "application/json", headers = "Accept=application/json")
	public AnnonceDTO registerAnnonce(@RequestBody AnnonceDTO annonceDTO) throws Exception {
		return service.add(annonceDTO);
	}

}
