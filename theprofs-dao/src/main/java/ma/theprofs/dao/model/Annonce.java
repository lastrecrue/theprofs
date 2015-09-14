package ma.theprofs.dao.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the annonce database table.
 * 
 */
@Entity
@NamedQuery(name = "Annonce.findAll", query = "SELECT a FROM Annonce a")
public class Annonce implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  private String discription;

  // bi-directional many-to-one association to Personne
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "prof_id")
  private Personne personne;

  // bi-directional many-to-one association to Cour
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "type_cours_id")
  private Cour cour;

  private String ville;

  public Annonce() {
  }

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getDiscription() {
    return this.discription;
  }

  public void setDiscription(String discription) {
    this.discription = discription;
  }

  public Personne getPersonne() {
    return this.personne;
  }

  public void setPersonne(Personne personne) {
    this.personne = personne;
  }

  public Cour getCour() {
    return this.cour;
  }

  public void setCour(Cour cour) {
    this.cour = cour;
  }

  public String getVille() {
    return ville;
  }

  public void setVille(String ville) {
    this.ville = ville;
  }

}