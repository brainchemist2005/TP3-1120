
public class ObjetPerdu {
	
	final int CAT_BIJOU = 0, CAT_VETEMENT = 1, CAT_ARGENT_PORTEFEUILLE = 2,CAT_CLE  = 3, CAT_AUTRE = 4; 
	final String[] CATEGORIES = {"bijou", "vetement", "argent / portefeuille", "cle(s)", "autre"} ;
	
	static int sequenceId; 
	
	int id, categorie;
	
	Date date;
	
	String localisation;
	
	String[] motsCles;
	
	public ObjetPerdu(int categorie, Date date, String localisation){
		
		this.categorie = categorie; //check categorie doit etre entre 0 et length-1
		this.date = date;
		this.localisation = localisation;
		this.id = sequenceId;
		sequenceId++;
		motsCles = new String[0];
	}
	
	
	public int getId() {
		return id;
	}
	
	public int getCategorie() {
		return categorie;
	}
	
	public Date getDate() {
		return date;
	}
	
	public String getLocalisation() {
		return localisation;
	}
	
	public void setCategorie(int categorie) {
		this.categorie = categorie;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}
	
	
	
	/**
	 * Cette methode retourne une representation sous forme d'une chaine de caracteres de cet
	 * objet perdu. 
	 * 
	 * ANTECEDENTS : 
	 *   - la categorie de cet objet perdu est valide (entre 0 et CATEGORIES.length - 1)
	 *   - le tableau motsCles n'est pas null.
	 * 
	 * @return une representation sous forme d'une chaine de caracteres de cet objet perdu.
	 */
	public String toString() {
	   String listeMotsCles = "";
	   String desc = "ID           : " + id + "\n" + "MOTS CLES    : ";

	   for (String motCle : motsCles) {
	      listeMotsCles = listeMotsCles + motCle + ", ";
	   }

	   desc = desc + (!listeMotsCles.isEmpty() 
	      ? listeMotsCles.substring(0, listeMotsCles.length() - 2) : listeMotsCles);
	   desc = desc + "\n";
	   desc = desc + "CATEGORIE    : " + CATEGORIES[categorie] + "\n" 
	               + "DATE         : " + date + "\n"
	               + "LOCALISATION : " + localisation; 
	   return desc;
	}
}
