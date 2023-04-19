
public class ObjetPerdu {
	
	final static int CAT_BIJOU = 0, CAT_VETEMENT = 1, CAT_ARGENT_PORTEFEUILLE = 2,CAT_CLE  = 3, CAT_AUTRE = 4; 
	final static String[] CATEGORIES = {"bijou", "vetement", "argent / portefeuille", "cle(s)", "autre"} ;
	
	private static int sequenceId = 1; 
	

	public int id, categorie, nbrElem=0;
	
	private Date date = new Date();
	
	private String localisation;
	
	String[] motsCles;
	
	public ObjetPerdu(int categorie, Date date, String localisation){
		this.categorie = categorie;
		this.date = date;
		this.localisation = localisation;
		this.id = sequenceId;
		sequenceId++;
		motsCles = new String[nbrElem];
	}
	
	public static String[] agrandirTableau(String[] tab, int nbrCasesDePlus) {
		 //creer un nouveau tableau plus grand
		 String [] tab2 = new String [tab.length + nbrCasesDePlus];

		 //copier les éléments de tab dans tab2
		 for (int i = 0 ; i < tab.length ; i++) {
		 tab2[i] = tab[i];
		 }
		 return tab2;
	 }
	
	public static ObjetPerdu[] agrandirTableau(ObjetPerdu[] tab, int nbrCasesDePlus) {
		 //creer un nouveau tableau plus grand
		ObjetPerdu [] tab2 = new ObjetPerdu [tab.length + nbrCasesDePlus];

		 //copier les éléments de tab dans tab2
		 for (int i = 0 ; i < tab.length ; i++) {
		 tab2[i] = tab[i];
		 }
		 return tab2;
	 }
	
	public static int[] agrandirTableau(int[] tab, int nbrCasesDePlus) {
		 //creer un nouveau tableau plus grand
		int [] tab2 = new int [tab.length + nbrCasesDePlus];

		 //copier les éléments de tab dans tab2
		 for (int i = 0 ; i < tab.length ; i++) {
		 tab2[i] = tab[i];
		 }
		 return tab2;
	 }
	
	
	public static String[] diminuerTableau(String[] tab, int nbrCasesDeMoins) {
			 //creer un nouveau tableau plus grand
			 String [] tab2 = new String [tab.length - nbrCasesDeMoins];

			 int j = 0;

			 //copier les éléments de tab dans tab2
			 for (int i = 0; i < tab.length -1 ;i++) {
				 if(tab[i].equals("$"))
				 	i++;
				 
				 tab2[j] = tab[i];
				 j++;
			 }
			 
			 return tab2;
		 }
	
	public static ObjetPerdu[] diminuerTableau(ObjetPerdu[] tab, int nbrCasesDeMoins,int m) {
			 //creer un nouveau tableau plus grand
		ObjetPerdu [] tab2 = new ObjetPerdu [tab.length - nbrCasesDeMoins];
		int i=0;

		tab[m] = null;
			 //copier les éléments de tab dans tab2
			 for (int j = 0; j < tab2.length ;j++) {
				 if(i<tab.length-1 && tab[i] == null) {
				 	i++;
				 }
				 
				 if(tab[i] != null) {
					 tab2[j] = tab[i];
					 i++;
				 }
			 }
			 

			 return tab2;
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
	
	
	public String obtenirMotsCles() {
		String motsCle = "";
		
		if(motsCles.length != 0) {
			for(int i=0 ; i<motsCles.length ; i++) {
				if(motsCles[i] != null) {
						motsCle += motsCles[i] + " " ;
				}
			}
			motsCle = motsCle.substring(0, motsCle.length() - 1);
		}	
		
		
		return motsCle;
	}
	
	public Boolean ajouterMotCle(String motCle) {
		Boolean flag = true;
		
		if(motCle != null && motCle != "") {
			if(estAssocieACeMotCle(motCle)) {
				flag = false;
			}
			
			if(flag) {
				motsCles = agrandirTableau(motsCles,1);
				motsCles[motsCles.length - 1] = motCle;
				nbrElem++;
			}
		}
		else 
			flag = false;
			
		return flag;
	}
	
	public boolean estAssocieACeMotCle(String motCle) {
		
		int i=0; 
		boolean flag= false;
		
		
		while(i < motsCles.length && !flag)  {
			if(motCle.equalsIgnoreCase(motsCles[i]))
				flag = true;
			else
				i++;
		}
		
		
		return flag;
	}
	
	public boolean supprimerMotCle(String motCle) {
		boolean flag = false;
		
		if(estAssocieACeMotCle(motCle)) {
			for(int i = 0; i < motsCles.length ; i++) {
				if(motCle.equalsIgnoreCase(motsCles[i])) {
					motsCles[i] = "$"; 
					motsCles = diminuerTableau(motsCles,1);
					nbrElem--;
					flag = true;
				}
			}
		}
		
		else 
			flag = false;
		
		return flag;
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
	
	
	public static int getSequenceId() {
		return sequenceId;
	}

	public static void setSequenceId(int i) {
		sequenceId = i;
		
	}
	
}