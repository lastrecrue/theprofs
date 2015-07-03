package ma.theprofs.service.dto;

import java.io.Serializable;

public class PersonneDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;

	private String email;

	private String nom;

	private String prenom;

	private String pwd;

	private Float note;

	public PersonneDTO() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Float getNote() {
		return this.note;
	}

	public void setNote(Float note) {
		this.note = note;
	}

}