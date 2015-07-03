package ma.theprofs.service.dto;

import java.io.Serializable;

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

}