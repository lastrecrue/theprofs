package ma.theprofs.service.dto;

import java.io.Serializable;
import java.util.List;

import ma.theprofs.dao.model.Annonce;
import ma.theprofs.dao.model.NoteProf;

public class PersonneDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;

	private String email;

	private String nom;

	private String prenom;

	private String pwd;

	private List<AnnonceDTO> annonces;

	private List<NoteProfDTO> notes;

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

	public List<AnnonceDTO> getAnnonces() {
		return this.annonces;
	}

	public void setAnnonces(List<AnnonceDTO> annonces) {
		this.annonces = annonces;
	}

	public AnnonceDTO addAnnonce(AnnonceDTO annonce) {
		getAnnonces().add(annonce);
		annonce.setPersonne(this);

		return annonce;
	}

	public AnnonceDTO removeAnnonce(AnnonceDTO annonce) {
		getAnnonces().remove(annonce);
		annonce.setPersonne(null);

		return annonce;
	}

	public List<NoteProfDTO> getNotes() {
		return this.notes;
	}

	public void setNotes(List<NoteProfDTO> notes) {
		this.notes = notes;
	}

	public NoteProfDTO addNote(NoteProfDTO note) {
		getNotes().add(note);
		note.setProf(this);

		return note;
	}

	public NoteProfDTO removeNote(NoteProfDTO note) {
		getNotes().remove(note);
		note.setProf(null);

		return note;
	}

}