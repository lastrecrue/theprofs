package ma.theprofs.service.dto;

import java.io.Serializable;

/**
 * The persistent class for the annonce database table.
 * 
 */
public class AnnonceDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;

	private String discription;

	private PersonneDTO personne;

	private CourDTO cour;

	private String ville;

	public AnnonceDTO() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDiscription() {
		return this.discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public PersonneDTO getPersonne() {
		return this.personne;
	}

	public void setPersonne(PersonneDTO personne) {
		this.personne = personne;
	}

	public CourDTO getCour() {
		return this.cour;
	}

	public void setCour(CourDTO cour) {
		this.cour = cour;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

}