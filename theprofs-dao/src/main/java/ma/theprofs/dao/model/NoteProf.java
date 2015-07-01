package ma.theprofs.dao.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the note_prof database table.
 * 
 */
@Entity
@Table(name="note_prof")
@NamedQuery(name="NoteProf.findAll", query="SELECT n FROM NoteProf n")
public class NoteProf implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private NoteProfPK id;

	private int note;

	//uni-directional many-to-one association to Personne
	@ManyToOne
	@JoinColumn(name="eleve_id",referencedColumnName="id",insertable=false, updatable=false)
	private Personne eleve;

	//bi-directional many-to-one association to Personne
	@ManyToOne
	@JoinColumn(name="prof_id",referencedColumnName="id",insertable=false, updatable=false)
	private Personne prof;

	public NoteProf() {
	}

	public NoteProfPK getId() {
		return this.id;
	}

	public void setId(NoteProfPK id) {
		this.id = id;
	}

	public int getNote() {
		return this.note;
	}

	public void setNote(int note) {
		this.note = note;
	}

	public Personne getEleve() {
		return this.eleve;
	}

	public void setEleve(Personne eleve) {
		this.eleve = eleve;
	}

	public Personne getProf() {
		return this.prof;
	}

	public void setProf(Personne prof) {
		this.prof = prof;
	}

}