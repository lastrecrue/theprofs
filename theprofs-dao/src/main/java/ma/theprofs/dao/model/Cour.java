package ma.theprofs.dao.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the cours database table.
 * 
 */
@Entity
@Table(name="cours")
@NamedQuery(name="Cour.findAll", query="SELECT c FROM Cour c")
public class Cour implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String discription;

	//bi-directional many-to-one association to Personne
	@ManyToOne
	@JoinColumn(name="prof_id")
	private Personne prof;

	//bi-directional many-to-many association to Personne
	@ManyToMany(mappedBy="coursSuivie")
	private List<Personne> eleve;

	//bi-directional many-to-one association to TypeCour
	@ManyToOne
	@JoinColumn(name="type_cours_id")
	private TypeCour typeCour;

	//bi-directional many-to-one association to Seance
	@OneToMany(mappedBy="cour")
	private List<Seance> seances;

	public Cour() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDiscription() {
		return this.discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public Personne getProf() {
		return this.prof;
	}

	public void setProf(Personne prof) {
		this.prof = prof;
	}

	public List<Personne> getEleve() {
		return this.eleve;
	}

	public void setEleve(List<Personne> eleve) {
		this.eleve = eleve;
	}

	public TypeCour getTypeCour() {
		return this.typeCour;
	}

	public void setTypeCour(TypeCour typeCour) {
		this.typeCour = typeCour;
	}

	public List<Seance> getSeances() {
		return this.seances;
	}

	public void setSeances(List<Seance> seances) {
		this.seances = seances;
	}

	public Seance addSeance(Seance seance) {
		getSeances().add(seance);
		seance.setCour(this);

		return seance;
	}

	public Seance removeSeance(Seance seance) {
		getSeances().remove(seance);
		seance.setCour(null);

		return seance;
	}

}