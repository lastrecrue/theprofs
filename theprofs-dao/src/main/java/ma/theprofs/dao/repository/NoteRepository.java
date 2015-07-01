package ma.theprofs.dao.repository;

import ma.theprofs.dao.model.NoteProf;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface NoteRepository extends PagingAndSortingRepository<NoteProf, Integer> {

}
