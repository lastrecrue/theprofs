package ma.theprofs.service.dto;

import java.io.Serializable;

/**
 * The persistent class for the note_prof database table.
 * 
 */
public class NoteProfDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private NoteProfPKDTO id;

	private int note;

	private PersonneDTO eleve;

	private PersonneDTO prof;

	public NoteProfDTO() {
	}

	public NoteProfPKDTO getId() {
		return this.id;
	}

	public void setId(NoteProfPKDTO id) {
		this.id = id;
	}

	public int getNote() {
		return this.note;
	}

	public void setNote(int note) {
		this.note = note;
	}

	public PersonneDTO getEleve() {
		return this.eleve;
	}

	public void setEleve(PersonneDTO eleve) {
		this.eleve = eleve;
	}

	public PersonneDTO getProf() {
		return this.prof;
	}

	public void setProf(PersonneDTO prof) {
		this.prof = prof;
	}

}