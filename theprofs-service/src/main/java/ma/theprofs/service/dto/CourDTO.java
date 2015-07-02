package ma.theprofs.service.dto;

import java.io.Serializable;
import java.util.List;

/**
 * The persistent class for the cours database table.
 * 
 */
public class CourDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;

	private String libelle;

	private String niveau;

	private String type;

	// bi-directional many-to-one association to AnnonceDTO
	private List<AnnonceDTO> annonces;

	public CourDTO() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getNiveau() {
		return this.niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<AnnonceDTO> getAnnonceDTOs() {
		return this.annonces;
	}

	public void setAnnonceDTOs(List<AnnonceDTO> annonces) {
		this.annonces = annonces;
	}

	public AnnonceDTO addAnnonceDTO(AnnonceDTO annonce) {
		getAnnonceDTOs().add(annonce);
		annonce.setCour(this);

		return annonce;
	}

	public AnnonceDTO removeAnnonceDTO(AnnonceDTO annonce) {
		getAnnonceDTOs().remove(annonce);
		annonce.setCour(null);

		return annonce;
	}

}