package ma.theprofs.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

public abstract class AbstractService<Entity, DTO> {

	abstract public PagingAndSortingRepository<Entity, Integer> getRepository();

	abstract protected Entity convertToEntity(DTO dto);

	abstract protected DTO converttoDTO(Entity entity);

	public DTO add(DTO dto) {
		Entity entity = convertToEntity(dto);
		entity = getRepository().save(entity);
		return converttoDTO(getRepository().save(entity));
	}

	public List<DTO> findAll() {
		Iterable<Entity> entitys = getRepository().findAll();
		List<DTO> dTOs = convertToDTOs(entitys);
		return dTOs;
	}

	protected List<DTO> convertToDTOs(Iterable<Entity> entitys) {
		List<DTO> dTOs = new ArrayList<DTO>();
		for (Entity entity : entitys) {
			dTOs.add(converttoDTO(entity));
		}
		return dTOs;
	}

	public DTO findById(Integer id) {
		return converttoDTO(getRepository().findOne(id));
	}
}
