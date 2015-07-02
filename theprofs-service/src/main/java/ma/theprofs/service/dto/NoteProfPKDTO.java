package ma.theprofs.service.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The primary key class for the note_prof database table.
 * 
 */
@Embeddable
public class NoteProfPKDTO implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="eleve_id", insertable=false, updatable=false)
	private int eleveId;

	@Column(name="prof_id", insertable=false, updatable=false)
	private int profId;

	public NoteProfPKDTO() {
	}
	public int getEleveId() {
		return this.eleveId;
	}
	public void setEleveId(int eleveId) {
		this.eleveId = eleveId;
	}
	public int getProfId() {
		return this.profId;
	}
	public void setProfId(int profId) {
		this.profId = profId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof NoteProfPKDTO)) {
			return false;
		}
		NoteProfPKDTO castOther = (NoteProfPKDTO)other;
		return 
			(this.eleveId == castOther.eleveId)
			&& (this.profId == castOther.profId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.eleveId;
		hash = hash * prime + this.profId;
		
		return hash;
	}
}