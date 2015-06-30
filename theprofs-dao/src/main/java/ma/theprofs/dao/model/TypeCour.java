package ma.theprofs.dao.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the type_cours database table.
 * 
 */
@Entity
@Table(name="type_cours")
@NamedQuery(name="TypeCour.findAll", query="SELECT t FROM TypeCour t")
public class TypeCour implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String libelle;

	private String niveau;

	private String type;

	//bi-directional many-to-one association to Cour
	@OneToMany(mappedBy="typeCour")
	private List<Cour> cours;

	public TypeCour() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
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

	public List<Cour> getCours() {
		return this.cours;
	}

	public void setCours(List<Cour> cours) {
		this.cours = cours;
	}

	public Cour addCour(Cour cour) {
		getCours().add(cour);
		cour.setTypeCour(this);

		return cour;
	}

	public Cour removeCour(Cour cour) {
		getCours().remove(cour);
		cour.setTypeCour(null);

		return cour;
	}

}