package ma.theprofs.service.dto;

import java.io.Serializable;

/**
 * The persistent class for the note_prof database table.
 * 
 */
public class NoteProfDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private int eleveId;

	private int profId;

	private int note;

	public NoteProfDTO() {
	}

	public int getNote() {
		return this.note;
	}

	public void setNote(int note) {
		this.note = note;
	}

	public int getEleveId() {
		return eleveId;
	}

	public void setEleveId(int eleveId) {
		this.eleveId = eleveId;
	}

	public int getProfId() {
		return profId;
	}

	public void setProfId(int profId) {
		this.profId = profId;
	}

}