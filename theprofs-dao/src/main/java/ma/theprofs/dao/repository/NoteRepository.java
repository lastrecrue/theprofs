package ma.theprofs.dao.repository;

import java.util.List;

import ma.theprofs.dao.model.NoteProf;
import ma.theprofs.dao.model.Personne;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface NoteRepository extends PagingAndSortingRepository<NoteProf, Integer> {

	List<NoteProf> findByProf(Personne prof);

}
