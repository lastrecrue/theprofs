package ma.theprofs.service;

import javax.transaction.Transactional;

import ma.theprofs.dao.model.Cour;
import ma.theprofs.dao.repository.CourRepository;
import ma.theprofs.service.dto.CourDTO;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CourService extends AbstractService<Cour, CourDTO> {
	@Autowired
	private CourRepository repository;

	public CourRepository getRepository() {
		return repository;
	}

	@Override
	protected Cour convertToEntity(CourDTO dto) {
		Cour cour = new Cour();
		BeanUtils.copyProperties(dto, cour);
		return cour;
	}

	@Override
	protected CourDTO converttoDTO(Cour entity) {
		CourDTO cour = new CourDTO();
		BeanUtils.copyProperties(entity, cour);
		return cour;
	}

}
