
public class GestionObjetsPerdus {
	final static String ERR_REP_D_P = "ERREUR, entrez le caracere D ou P! RECOMMENCEZ..." ,DATE_PERIODE = "Specifier une (d)ate ou une (p)eriode : " ,OBJET_NON_TROUVE = "** AUCUN OBJET TROUVE **", ERREUR_MENU = "ERREUR, vous devez entrer un choix entre 1 et 7! RECOMMENCEZ..." ,REMISE_SUCCES = "** LA REMISE DE L'OBJET PERDU A ETE EFFECTUEE AVEC SUCCES **",ERR_POSITIF = "ERREUR, entrez un entier strictement positif! RECOMMENCEZ...", MSG_SOL_MOTS_CLE = "Entrez les mots-cles decrivant l'objet a consigner : " , MSG_ERR_MOTS_CLE = "ERREUR, la chaine doit contenir entre 2 et 50 caracteres! RECOMMENCEZ...", MSG_ERR_MOTS_LOCALISATION = "ERREUR, la chaine doit contenir entre 5 et 50 caracteres! RECOMMENCEZ...",ANNULATION_REMISE = "** LA REMISE DE L'OBJET PERDU A ETE ANNULEE **", ERREUR_MENU_CATEGORIE = "ERREUR, vous devez entrer un choix entre 1 et 5! RECOMMENCEZ...", MSG_TROUVER = "Voulez-vous vraiment rendre cet objet perdu (oui / non) : ", ERR_REP = "ERREUR, vous devez entrer OUI ou NON! RECOMMENCEZ...",MSG_PAS_DOBJET = "** AUCUN OBJET PERDU N'EST CONSIGNE **",MSG_SOL_MOTS_CLE_RECHERCHE = "Mot(s) cle(s) recherches : " ,MSG_PAS_TROUVER = "** L'OBJET PERDU AYANT CET ID N'EST PAS CONSIGNE **";
	
	public static boolean containsArray(String[] tableau, String[] sousTableau) {
	    for (int i = 0; i <= tableau.length - sousTableau.length; i++) {
	        boolean found = true;
	        for (int j = 0; j < sousTableau.length; j++) {
	            if (!tableau[i+j].equalsIgnoreCase(sousTableau[j])) {
	                found = false;
	                break;
	            }
	        }
	        if (found) {
	            return true;
	        }
	    }
	    return false;
	}
	
	
	public static void rechercherObjetCategorie(ObjetPerdu[] objetsPerdus) {
		String choix;
		int categorie = 0, i=0;
		boolean flag = false;
		
		System.out.println("------------------------\r\n"
				+ "RECHERCHER PAR CATEGORIE\r\n"
				+ "------------------------");
		
		do {
			System.out.println("CATEGORIES :\r\n"
					+ "1. bijou\r\n"
					+ "2. vetement\r\n"
					+ "3. argent / portefeuille\r\n"
					+ "4. cle(s)\r\n"
					+ "5. autre");
			
			System.out.print("ERREUR, entrez un numero entre 1 et 5! RECOMMENCEZ..."); //a refaire msg erreur ?
			choix = Clavier.lireString();

	            switch (choix) {
	                case "1":
	                	categorie = ObjetPerdu.CAT_BIJOU ;
	                    break;

	                case "2":
	                	categorie = ObjetPerdu.CAT_VETEMENT;
	                    break;

	                case "3":
	                	categorie = ObjetPerdu.CAT_ARGENT_PORTEFEUILLE;
	                    break;

	                case "4":
	                	categorie = ObjetPerdu.CAT_CLE;
	                    break;
	                    
	                case "5":
	                	categorie = ObjetPerdu.CAT_AUTRE;
	                    break;
	                    
	                default:
	                    System.out.println(ERREUR_MENU_CATEGORIE);
	            }
		
		}while(!choix.equals("1") && !choix.equals("2") & !choix.equals("3") && !choix.equals("4") && !choix.equals("5")); //there is better

		System.out.println("RESULTAT(S) DE LA RECHERCHE : ");
		
		while(objetsPerdus[i] != null) {
			if(objetsPerdus[i].categorie == categorie) {
				flag = true;
				System.out.println("ID           : " + objetsPerdus[i].id);
				System.out.println("MOTS CLES    : " + objetsPerdus[i].obtenirMotsCles());
				System.out.println("CATEGORIE    : " + ObjetPerdu.CATEGORIES[objetsPerdus[i].categorie]);
				System.out.println("DATE         : " + objetsPerdus[i].getDate());
				System.out.println("LOCALISATION : " + objetsPerdus[i].getLocalisation());
				System.out.println();
			}
			i++;
		}
		
		if(!flag) 
			System.out.println(OBJET_NON_TROUVE);
		
		return ;
	}
	
	public static void rechercherObjetDate(ObjetPerdu[] objetsPerdus) {
		int jour,mois,annee,i=0,jourf,moisf,anneef;
		Date date = new Date(),date2 = new Date();
		boolean flag;
		String rep;
		
		
		
			System.out.println("----------------------\r\n"
					+ "RECHERCHER PAR DATE(S)\r\n"
					+ "----------------------");
			
			
			rep = TP3Utils.validerRepDeuxChoix(DATE_PERIODE, ERR_REP_D_P, "p", "d");
			
			if(rep.equalsIgnoreCase("d")) {
			
				do {
					do {
						
						jour = TP3Utils.validerTypeEntierStrictPositif("Date de consignation : ",ERR_POSITIF);
						
					}while(jour <= 0);
					
					do {
						
						mois = TP3Utils.validerTypeEntierStrictPositif("Entrez le mois de la date : ",ERR_POSITIF);
						
					}while(mois <= 0);
					
					do {
						
						annee = TP3Utils.validerTypeEntierStrictPositif("Entrez l'annee de la date : ",ERR_POSITIF);
						
					}while(mois <= 0);
					
					date.setJour(jour);
					date.setMois(mois);
					date.setAnnee(annee);
					
					flag = date.estDateValide();
					
					if(!flag)
						System.out.println("ERREUR, date invalide! RECOMMENCEZ...");
				
					
				}while(!flag);
				
				
				flag = false;
						
				System.out.println("RESULTAT(S) DE LA RECHERCHE : ");
				
				while(objetsPerdus[i] != null) {
					if(objetsPerdus[i].date.estEgale(date)) {
						flag = true;
						System.out.println("ID           : " + objetsPerdus[i].id);
						System.out.println("MOTS CLES    : " + objetsPerdus[i].obtenirMotsCles());
						System.out.println("CATEGORIE    : " + ObjetPerdu.CATEGORIES[objetsPerdus[i].categorie]);
						System.out.println("DATE         : " + objetsPerdus[i].getDate());
						System.out.println("LOCALISATION : " + objetsPerdus[i].getLocalisation());
						System.out.println();
					}
					i++;
				}
				
				if(!flag) 
					System.out.println(OBJET_NON_TROUVE);
			}
			
			else {
				flag = false;

				System.out.println("Date du debut de la periode : ");
				do {
					do {
						
						jour = TP3Utils.validerTypeEntierStrictPositif("Date le jour de la date : ",ERR_POSITIF);
						
					}while(jour <= 0);
					
					do {
						
						mois = TP3Utils.validerTypeEntierStrictPositif("Entrez le mois de la date : ",ERR_POSITIF);
						
					}while(mois <= 0);
					
					do {
						
						annee = TP3Utils.validerTypeEntierStrictPositif("Entrez l'annee de la date : ",ERR_POSITIF);
						
					}while(mois <= 0);
					
					date.setJour(jour);
					date.setMois(mois);
					date.setAnnee(annee);
					
					flag = date.estDateValide();
					
					if(!flag)
						System.out.println("ERREUR, date invalide! RECOMMENCEZ...");
				
					
				}while(!flag);
				
				flag = false;
				
				System.out.println("Date de la fin de la periode : ");
				do {
					do {
						
						jourf = TP3Utils.validerTypeEntierStrictPositif("Date le jour de la date : ",ERR_POSITIF);
						
					}while(jourf <= 0);
					
					do {
						
						moisf = TP3Utils.validerTypeEntierStrictPositif("Entrez le mois de la date : ",ERR_POSITIF);
						
					}while(moisf <= 0);
					
					do {
						
						anneef = TP3Utils.validerTypeEntierStrictPositif("Entrez l'annee de la date : ",ERR_POSITIF);
						
					}while(mois <= 0);
					
					date2.setJour(jourf);
					date2.setMois(moisf);
					date2.setAnnee(anneef);
					
					flag = date2.estDateValide();
					
					if(!flag)
						System.out.println("ERREUR, date invalide! RECOMMENCEZ...");
				
					
				}while(!flag);
				
				// i have start date and end date 
				
				
			}

		
		
		System.out.println("Appuyez sur <ENTREE> pour revenir au menu... ");
		Clavier.lireFinLigne();
		
		
	}
	
	public static void rechercherObjetMots(ObjetPerdu[] objetsPerdus) {
		String motsCle;
		int i=0;
		String[] motsCles;
		boolean flag = false;
		
			System.out.println("------------------------\r\n"
					+ "RECHERCHER PAR MOTS CLES\r\n"
					+ "------------------------");
			
			motsCle = TP3Utils.validerLngChaine(MSG_SOL_MOTS_CLE_RECHERCHE,MSG_ERR_MOTS_CLE,2,50);
			motsCle = motsCle.trim();
			
			motsCles = motsCle.split("\\s+");
			
			System.out.println("RESULTAT(S) DE LA RECHERCHE :");
			
			while(objetsPerdus[i] != null) {
				objetsPerdus[i].motsCles =  objetsPerdus[i].obtenirMotsCles().split(" ");
					if(containsArray(objetsPerdus[i].motsCles ,motsCles)) {
						flag = true;
						System.out.println("ID           : " + objetsPerdus[i].id);
						System.out.println("MOTS CLES    : " + objetsPerdus[i].obtenirMotsCles());
						System.out.println("CATEGORIE    : " + ObjetPerdu.CATEGORIES[objetsPerdus[i].categorie]);
						System.out.println("DATE         : " + objetsPerdus[i].getDate());
						System.out.println("LOCALISATION : " + objetsPerdus[i].getLocalisation());
						System.out.println();
						}
					i++;
			}
			
			if(!flag) 
				System.out.println(OBJET_NON_TROUVE);
			
		
		
		System.out.println("Appuyez sur <ENTREE> pour revenir au menu... ");
		Clavier.lireFinLigne();
	}
	
	public static void reclamation(ObjetPerdu[] objetsPerdus) {
		int id, i=0;
		String rep;
		boolean flag = false;
		
		System.out.println("-----------------------\r\n"
				+ "RENDRE UN OBJET RECLAME\r\n"
				+ "-----------------------");
		
		id = TP3Utils.validerTypeEntierStrictPositif("Entrez le numero d'identification (id) de l'objet a rendre : ",ERR_POSITIF);
				
		while(i < objetsPerdus.length -1 && !flag) {
			if(objetsPerdus[i].id == id)
				flag = true;
			else 
				i++;
		}
		
		System.out.println(i);
		
		if(!flag) {
			System.out.println(MSG_PAS_TROUVER);
		
		System.out.println("Appuyez sur <ENTREE> pour revenir au menu... ");
		Clavier.lireFinLigne();
		}
		
		else {
			System.out.println("ID           : " + objetsPerdus[i].id);
			System.out.println("MOTS CLES    : " + objetsPerdus[i].obtenirMotsCles());
			System.out.println("CATEGORIE    : " + ObjetPerdu.CATEGORIES[objetsPerdus[i].categorie]);
			System.out.println("DATE         : " + objetsPerdus[i].getDate());
			System.out.println("LOCALISATION : " + objetsPerdus[i].getLocalisation());
			System.out.println();
			
			rep = TP3Utils.validerRepDeuxChoix(MSG_TROUVER, ERR_REP, "oui", "non");
			
			if(rep.equalsIgnoreCase("non")) {
				System.out.println(ANNULATION_REMISE);
				System.out.println("Appuyez sur <ENTREE> pour revenir au menu... ");
				Clavier.lireFinLigne();
			}
			
			else if(rep.equalsIgnoreCase("oui")) {
				objetsPerdus[i] = null;
				objetsPerdus = TP3Utils.ordonnerObjetsPerdusParDate(objetsPerdus);
				ObjetPerdu.sequenceId--;
				System.out.println(REMISE_SUCCES);
				System.out.println("Appuyez sur <ENTREE> pour revenir au menu... ");
				Clavier.lireFinLigne();
			}
				
		}
		
	}
	
	public static void affichage(ObjetPerdu[] objetsPerdus) {
		int i=0; 
		System.out.println("----------------------------------\r\n"
				+ "AFFICHER TOUS LES OBJETS CONSIGNES\r\n"
				+ "----------------------------------");
		
		while(objetsPerdus[i] != null) {
			System.out.println("ID           : " + objetsPerdus[i].id);
			System.out.println("MOTS CLES    : " + objetsPerdus[i].obtenirMotsCles());
			System.out.println("CATEGORIE    : " + ObjetPerdu.CATEGORIES[objetsPerdus[i].categorie]);
			System.out.println("DATE         : " + objetsPerdus[i].getDate());
			System.out.println("LOCALISATION : " + objetsPerdus[i].getLocalisation());
			System.out.println();
			i++;
		}
		
		System.out.println("Appuyez sur <ENTREE> pour revenir au menu... ");
		Clavier.lireFinLigne();
	}
	
	public static void consignerObjet(Date date, ObjetPerdu[] objetsPerdus) {
		ObjetPerdu objet;
		String choix, motsCle, localisation;
		int categorie = 0;
		String motsCles[]; 
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
                	categorie = ObjetPerdu.CAT_BIJOU ;
                    break;

                case "2":
                	categorie = ObjetPerdu.CAT_VETEMENT;
                    break;

                case "3":
                	categorie = ObjetPerdu.CAT_ARGENT_PORTEFEUILLE;
                    break;

                case "4":
                	categorie = ObjetPerdu.CAT_CLE;
                    break;
                    
                case "5":
                	categorie = ObjetPerdu.CAT_AUTRE;
                    break;
                    
                default:
                    System.out.println(ERREUR_MENU_CATEGORIE);
            }
		 
                       
		}while(!choix.equals("1") && !choix.equals("2") & !choix.equals("3") && !choix.equals("4") && !choix.equals("5")); //there is better
		
		do {
			do {
				
				jour = TP3Utils.validerTypeEntierStrictPositif("Date de consignation : ",ERR_POSITIF);
				
			}while(jour <= 0);
			
			do {
				
				mois = TP3Utils.validerTypeEntierStrictPositif("Entrez le mois de la date : ",ERR_POSITIF);
				
			}while(mois <= 0);
			
			do {
				
				annee = TP3Utils.validerTypeEntierStrictPositif("Entrez l'annee de la date : ",ERR_POSITIF);
				
			}while(mois <= 0);
			
			date.setJour(jour);
			date.setMois(mois);
			date.setAnnee(annee);
			
			flag = date.estDateValide();
			
			if(!flag)
				System.out.println("ERREUR, date invalide! RECOMMENCEZ...");
		
			
		}while(!flag);
	
		motsCle = TP3Utils.validerLngChaine(MSG_SOL_MOTS_CLE,MSG_ERR_MOTS_CLE,2,50);
		motsCles = motsCle.split("\\s+") ; 
		
		
		localisation = TP3Utils.validerLngChaine("Entrez la localisation de l'objet perdu consigne : \r\n",MSG_ERR_MOTS_CLE,5,50);
		
		objet = new ObjetPerdu(categorie,date,localisation);
		
		
		if(objetsPerdus.length == 0 || objetsPerdus[objetsPerdus.length - 1] != null)
			objetsPerdus = ObjetPerdu.agrandirTableau(objetsPerdus,4);
		
		
		else {
			objetsPerdus[ObjetPerdu.sequenceId -2] = objet;
			objetsPerdus[ObjetPerdu.sequenceId -2].motsCles = ObjetPerdu.agrandirTableau(objetsPerdus[ObjetPerdu.sequenceId -2].motsCles,motsCles.length); 
			for(int i=0 ; i<motsCles.length ; i++)
				objetsPerdus[ObjetPerdu.sequenceId -2].ajouterMotCle(motsCles[i]); //Msg d erreur ?
			
		}
		

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
        ObjetPerdu[] objetsPerdus = new ObjetPerdu[10];
        //objetsPerdus = TP3Utils.recupererDonnees();

        do {
            menu();
            System.out.print("Entrez votre choix : ");
            
            choix = Clavier.lireString();

            switch (choix) {
                case "1":
                	consignerObjet(date,objetsPerdus);
                    break;
                    
                case "2":
                	if(ObjetPerdu.sequenceId > 0)
                		reclamation(objetsPerdus);
                	else
                		System.out.println(MSG_PAS_DOBJET);
                	
                    break;

                case "3":
                	if(ObjetPerdu.sequenceId > 0)
                		rechercherObjetMots(objetsPerdus);
                	else
                		System.out.println(MSG_PAS_DOBJET);
                    break;

                case "4":
                	if(ObjetPerdu.sequenceId > 0)
                		rechercherObjetDate(objetsPerdus);
                	else
                		System.out.println(MSG_PAS_DOBJET);
                    break;
                case "5":
                	if(ObjetPerdu.sequenceId > 0)
                		rechercherObjetCategorie(objetsPerdus);
                		
                	else
                    	System.out.println(MSG_PAS_DOBJET);
                		
                    break;
                case "6":
                	affichage(objetsPerdus);
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