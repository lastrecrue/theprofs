package ma.theprofs.service;

import java.util.List;

import javax.transaction.Transactional;

import ma.theprofs.dao.model.NoteProf;
import ma.theprofs.dao.model.NoteProfPK;
import ma.theprofs.dao.model.Personne;
import ma.theprofs.dao.repository.NoteRepository;
import ma.theprofs.dao.repository.PersonneRepository;
import ma.theprofs.service.dto.NoteProfDTO;
import ma.theprofs.service.dto.PersonneDTO;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PersonneService extends AbstractService<Personne, PersonneDTO> {
	@Autowired
	private PersonneRepository repository;

	@Autowired
	private NoteRepository noteRepository;

	public PersonneRepository getRepository() {
		return repository;
	}

	@Override
	protected Personne convertToEntity(PersonneDTO dto) {
		Personne personne = new Personne();
		BeanUtils.copyProperties(dto, personne);
		return personne;
	}

	@Override
	protected PersonneDTO converttoDTO(Personne entity) {
		PersonneDTO personne = new PersonneDTO();
		BeanUtils.copyProperties(entity, personne, "annonces");
		List<NoteProf> notes = noteRepository.findByProf(entity);
		if (!notes.isEmpty()) {
			Float note = Float.valueOf("0.0");
			for (NoteProf noteProf : notes) {
				note += noteProf.getNote();
			}
			personne.setNote(note / notes.size());
		} else {
			personne.setNote(Float.valueOf("0.0"));
		}
		return personne;
	}

	public void addNote(NoteProfDTO noteProfDTO) {
		NoteProf noteProf = convertNote(noteProfDTO);
		noteRepository.save(noteProf);
	}

	private NoteProf convertNote(NoteProfDTO noteProfDTO) {
		NoteProf noteProf = new NoteProf();
		noteProf.setNote(noteProfDTO.getNote());
		NoteProfPK noteProfPK = new NoteProfPK();
		noteProfPK.setEleveId(noteProfDTO.getEleveId());
		noteProfPK.setProfId(noteProfDTO.getProfId());
		noteProf.setId(noteProfPK);
		return noteProf;
	}
}
