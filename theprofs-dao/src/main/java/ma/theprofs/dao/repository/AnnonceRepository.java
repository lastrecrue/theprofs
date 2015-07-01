package ma.theprofs.dao.repository;


import ma.theprofs.dao.model.Annonce;

import org.springframework.data.repository.PagingAndSortingRepository;


public interface AnnonceRepository extends PagingAndSortingRepository<Annonce, Integer> {

	

}
