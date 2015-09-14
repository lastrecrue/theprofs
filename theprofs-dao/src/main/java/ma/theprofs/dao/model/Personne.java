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
  private int id;

  private String email;

  private String nom;

  private String prenom;

  private String pwd;

  // bi-directional many-to-one association to Annonce
  @OneToMany(mappedBy = "personne")
  private List<Annonce> annonces;

  // bi-directional many-to-one association to NoteProf
  @OneToMany(mappedBy = "prof")
  private List<NoteProf> notes;

  public Personne() {
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

  public List<Annonce> getAnnonces() {
    return this.annonces;
  }

  public void setAnnonces(List<Annonce> annonces) {
    this.annonces = annonces;
  }

  public Annonce addAnnonce(Annonce annonce) {
    getAnnonces().add(annonce);
    annonce.setPersonne(this);

    return annonce;
  }

  public Annonce removeAnnonce(Annonce annonce) {
    getAnnonces().remove(annonce);
    annonce.setPersonne(null);

    return annonce;
  }

  public List<NoteProf> getNotes() {
    return this.notes;
  }

  public void setNotes(List<NoteProf> notes) {
    this.notes = notes;
  }

  public NoteProf addNote(NoteProf note) {
    getNotes().add(note);
    note.setProf(this);

    return note;
  }

  public NoteProf removeNote(NoteProf note) {
    getNotes().remove(note);
    note.setProf(null);

    return note;
  }

}