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
public class CourServiceController {

	@Autowired
	private CourRepository courRepository;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET,headers="Accept=application/json")
	public @ResponseBody Cour findById(@PathVariable Integer id) {
		Cour cour =courRepository.findOne(id);
		return cour;
	}

}
