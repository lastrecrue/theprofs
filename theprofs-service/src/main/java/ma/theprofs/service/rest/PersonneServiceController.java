package ma.theprofs.service.rest;

import ma.theprofs.service.PersonneService;
import ma.theprofs.service.dto.PersonneDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
		PersonneDTO personne= service.findById(id);
		return personne;
	}

}
