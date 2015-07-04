package ma.theprofs.service.rest;

import ma.theprofs.service.PersonneService;
import ma.theprofs.service.dto.NoteProfDTO;
import ma.theprofs.service.dto.PersonneDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service/personne")
public class PersonneServiceController {

	@Autowired
	private PersonneService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody PersonneDTO findById(@PathVariable Integer id) {
		PersonneDTO personne = service.findById(id);
		return personne;
	}

	@RequestMapping(method = RequestMethod.PUT, consumes = "application/json", headers = "Accept=application/json")
	public PersonneDTO registerPersonne(@RequestBody PersonneDTO personneDTO) throws Exception {
		return service.add(personneDTO);
	}

	@RequestMapping(value = "/note", method = RequestMethod.PUT, consumes = "application/json", headers = "Accept=application/json")
	public void addNote(@RequestBody NoteProfDTO noteProf) throws Exception {
		service.addNote(noteProf);
	}

}
