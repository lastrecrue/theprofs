package ma.theprofs.dao.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the personne database table.
 * 
 */
@Entity
@NamedQuery(name = "Personne.findAll", query = "SELECT p FROM Personne p")
public class Personne implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String email;

	private String nom;

	private String prenom;

	private String pwd;

	// bi-directional many-to-one association to Cour
	@OneToMany(mappedBy = "prof")
	private List<Cour> coursDonnes;

	// bi-directional many-to-many association to Cour
	@ManyToMany
	@JoinTable(name = "personne_has_cours", joinColumns = { @JoinColumn(name = "eleve_id", referencedColumnName = "id") }, inverseJoinColumns = { @JoinColumn(name = "cours_id", referencedColumnName = "id") })
	private List<Cour> coursSuivie;

	// bi-directional many-to-many association to Droit
	@ManyToMany
	@JoinTable(name = "droit_has_personne", joinColumns = { @JoinColumn(name = "personne_id", referencedColumnName = "id") }, inverseJoinColumns = { @JoinColumn(name = "droit_id", referencedColumnName = "id") })
	private List<Droit> droits;

	public Personne() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
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

	public List<Cour> getCoursDonnes() {
		return this.coursDonnes;
	}

	public void setCoursDonnes(List<Cour> coursDonnes) {
		this.coursDonnes = coursDonnes;
	}

	public Cour addCoursDonne(Cour coursDonne) {
		getCoursDonnes().add(coursDonne);
		coursDonne.setProf(this);

		return coursDonne;
	}

	public Cour removeCoursDonne(Cour coursDonne) {
		getCoursDonnes().remove(coursDonne);
		coursDonne.setProf(null);

		return coursDonne;
	}

	public List<Cour> getCoursSuivie() {
		return this.coursSuivie;
	}

	public void setCoursSuivie(List<Cour> coursSuivie) {
		this.coursSuivie = coursSuivie;
	}

	public List<Droit> getDroits() {
		return this.droits;
	}

	public void setDroits(List<Droit> droits) {
		this.droits = droits;
	}

}