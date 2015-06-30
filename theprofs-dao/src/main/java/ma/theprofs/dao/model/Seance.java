package ma.theprofs.dao.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the seance database table.
 * 
 */
@Entity
@NamedQuery(name="Seance.findAll", query="SELECT s FROM Seance s")
public class Seance implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Column(name="date_debut")
	private Timestamp dateDebut;

	@Column(name="nb_minute")
	private int nbMinute;

	//bi-directional many-to-one association to Cour
	@ManyToOne
	@JoinColumn(name="cours_id")
	private Cour cour;

	public Seance() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getDateDebut() {
		return this.dateDebut;
	}

	public void setDateDebut(Timestamp dateDebut) {
		this.dateDebut = dateDebut;
	}

	public int getNbMinute() {
		return this.nbMinute;
	}

	public void setNbMinute(int nbMinute) {
		this.nbMinute = nbMinute;
	}

	public Cour getCour() {
		return this.cour;
	}

	public void setCour(Cour cour) {
		this.cour = cour;
	}

}