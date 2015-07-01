package ma.theprofs.dao.repository;

import ma.theprofs.dao.model.Personne;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface PersonneRepository extends PagingAndSortingRepository<Personne, Integer>{

}
