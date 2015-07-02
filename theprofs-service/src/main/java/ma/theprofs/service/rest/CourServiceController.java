package ma.theprofs.service.rest;

import ma.theprofs.service.CourService;
import ma.theprofs.service.dto.CourDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service/cour")
public class CourServiceController {

	@Autowired
	private CourService service;

	@RequestMapping(method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody Iterable<CourDTO> findAll() {
		Iterable<CourDTO> cours = service.findAll();
		return cours;
	}

}
