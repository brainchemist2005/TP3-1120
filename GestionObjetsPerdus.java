
public class GestionObjetsPerdus {
	final static String ERREUR_MENU = "ERREUR, vous devez entrer un choix entre 1 et 7! RECOMMENCEZ...",ERR_POSITIF = "ERREUR, entrez un entier strictement positif! RECOMMENCEZ..." ;
	
	public static boolean validationDate(int jour, int mois, int annee) {
		boolean flag = true;
		
		if(annee > 2023)
			flag = false;
		
		else if(mois > 12)
			flag = false;
		
		else if(mois < 8 && mois % 2 != 0) {
			if(jour > 31)
				flag = false;
			else if(mois == 2 && jour > 29)
				flag = false;
		}
		
		else if(mois > 7 && mois % 2 == 0) {
			if(jour > 31)
				flag = false;
		}
		
		
				
		return flag;
	}
	
	public static void consignerObjet(Date date) {
		String choix, type;
		boolean flag;
		int jour = 0, mois, annee;
		
		do {
		
		System.out.println("------------------------\r\n"
				+ "CONSIGNER UN OBJET PERDU\r\n"
				+ "------------------------\r\n"
				+ "\r\n"
				+ "CATEGORIES :\r\n"
				+ "1. bijou\r\n"
				+ "2. vetement\r\n"
				+ "3. argent / portefeuille\r\n"
				+ "4. cle(s)\r\n"
				+ "5. autre");
		
		System.out.print("Entrez votre choix : ");
		choix = Clavier.lireString();

            switch (choix) {
                case "1":
                	type = "bijou" ;
                    break;

                case "2":
                    type = "vetement";
                    break;

                case "3":
                	type = "argent / portefeuille";
                    break;

                case "4":
                	type = "cle(s)";
                    break;
                    
                case "5":
                	type = "autre";
                    break;
                    
                default:
                    System.out.println(ERREUR_MENU);
            }
		 
                       
		}while(choix.equals("1") || choix.equals("2") || choix.equals("3") || choix.equals("4") || choix.equals("5"));
		
		do {
			do {
				
				System.out.println("Date de consignation : ");
				jour = TP3Utils.validerTypeEntierStrictPositif(Clavier.lireString(),ERR_POSITIF);
				
			}while(jour != 0);
			
			do {
				
				System.out.println("Entrez le mois de la date : ");
				mois = TP3Utils.validerTypeEntierStrictPositif(Clavier.lireString(),ERR_POSITIF);
				
			}while(mois != 0);
			
			do {
				
				System.out.println("Entrez l'annee de la date : ");
				annee = TP3Utils.validerTypeEntierStrictPositif(Clavier.lireString(),ERR_POSITIF);
				
			}while(mois != 0);
			
			date.setJour(jour);
			date.setMois(mois);
			date.setAnnee(annee);
			
			flag = date.estDateValide();
			
			if(!flag)
				System.out.println("ERREUR, date invalide! RECOMMENCEZ...");
		
			
		}while(flag);
	}
	
	public static void menu() {
		System.out.println("=========================\r\n"
				+ "GESTION DES OBJETS PERDUS\r\n"
				+ "=========================\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "----\r\n"
				+ "MENU\r\n"
				+ "----\r\n"
				+ "1. Consigner un objet perdu\r\n"
				+ "2. Rendre un objet reclame\r\n"
				+ "3. Rechercher un objet par mots cles\r\n"
				+ "4. Rechercher un objet par date(s)\r\n"
				+ "5. Rechercher un objet par categorie\r\n"
				+ "6. Afficher tous les objets consignes\r\n"
				+ "7. Quitter");
	}
	
	public static void main(String[] args) {
		Date date = new Date();
        String choix;
        ObjetPerdu[] objetsPerdus = TP3Utils.recupererDonnees();

        do {
            menu();
            System.out.print("Entrez votre choix : ");
            
            choix = Clavier.lireString();

            switch (choix) {
                case "1":
                	consignerObjet(date);
                    break;
                    
                case "2":
                    
                    break;

                case "3":
                	
                    break;

                case "4":
                	
                    break;
                case "5":
                	
                    break;
                case "6":
                	
                    break;
                case "7":
                	TP3Utils.sauvegarder(objetsPerdus);
                	System.out.print("AUREVOIR !");
                    break;
                    
                    
                default:
                    System.out.println(ERREUR_MENU);
            }

            } while (!choix.equals("7"));
	}
	}