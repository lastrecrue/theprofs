package ma.theprofs.service.rest;

import ma.theprofs.dao.model.Cour;
import ma.theprofs.dao.repository.CourRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service/greeting")
public class RestServiceController {

	@Autowired
	private CourRepository courRepository;

	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public @ResponseBody String getGreeting(@PathVariable String name) {
		String result = "Hello " + name;
		Iterable<Cour> cours = courRepository.findAll();
		for (Cour cour : cours) {
			result+=cour;
		}
		return result;
	}

}
