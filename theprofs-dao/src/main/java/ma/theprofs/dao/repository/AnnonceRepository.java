package ma.theprofs.dao.repository;

import ma.theprofs.dao.model.Annonce;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AnnonceRepository extends PagingAndSortingRepository<Annonce, Integer> {

	@Query("from Annonce a where a.ville = ?1 and a.cour.type = ?2 and a.cour.niveau = ?3")
	public Iterable<Annonce> findByVilleTypeAndNiveau(String ville, String type, String niveau);

}
