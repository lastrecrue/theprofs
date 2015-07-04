package ma.theprofs.service.criterion;

public class AnnonceCriterion {

	private String ville;
	private String type;
	private String niveau;

	public AnnonceCriterion(String ville, String type, String niveau) {
		super();
		this.ville = ville;
		this.type = type;
		this.niveau = niveau;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNiveau() {
		return niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

}
