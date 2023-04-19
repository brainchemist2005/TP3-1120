
public class GestionObjetsPerdus {
	final static String ENTREE = "Appuyez sur <ENTREE> pour revenir au menu... ", RECHERCHE_MOTCLE= "------------------------\r\nRECHERCHER PAR MOTS CLES\r\n------------------------", DATE_INVALIDE = "ERREUR, date invalide! RECOMMENCEZ..." ,MENU = "=========================\r\nGESTION DES OBJETS PERDUS\r\n=========================\r\n\r\n\r\n----\r\nMENU\r\n----\r\n1. Consigner un objet perdu\r\n2. Rendre un objet reclame\r\n3. Rechercher un objet par mots cles\r\n4. Rechercher un objet par date(s)\r\n5. Rechercher un objet par categorie\r\n6. Afficher tous les objets consignes\r\n7. Quitter",  RESULAT_RECHERCHE = "RESULTAT(S) DE LA RECHERCHE : ", RECHERCHE_DATE = "----------------------\r\nRECHERCHER PAR DATE(S)\r\n----------------------", CHOIX = "Entrez votre choix : ", CATEGORIE = "CATEGORIES :\r\n1. bijou\r\n2. vetement\r\n3. argent / portefeuille\r\n4. cle(s)\r\n5. autre" ,ERR_REP_D_P = "ERREUR, entrez le caracere D ou P! RECOMMENCEZ..." ,DATE_PERIODE = "Specifier une (d)ate ou une (p)eriode : " ,OBJET_NON_TROUVE = "** AUCUN OBJET TROUVE **", ERREUR_MENU = "ERREUR, vous devez entrer un choix entre 1 et 7! RECOMMENCEZ..." ,REMISE_SUCCES = "** LA REMISE DE L'OBJET PERDU A ETE EFFECTUEE AVEC SUCCES **",ERR_POSITIF = "ERREUR, entrez un entier strictement positif! RECOMMENCEZ...", MSG_SOL_MOTS_CLE = "Entrez les mots-cles decrivant l'objet a consigner : " , MSG_ERR_MOTS_CLE = "ERREUR, la chaine doit contenir entre 2 et 50 caracteres! RECOMMENCEZ...",RECHERCHE_CATEGORIE = "------------------------\r\nRECHERCHER PAR CATEGORIE\r\n------------------------" ,MSG_ERR_MOTS_LOCALISATION = "ERREUR, la chaine doit contenir entre 5 et 50 caracteres! RECOMMENCEZ...",ANNULATION_REMISE = "** LA REMISE DE L'OBJET PERDU A ETE ANNULEE **", ERREUR_MENU_CATEGORIE = "ERREUR, vous devez entrer un choix entre 1 et 5! RECOMMENCEZ...", MSG_TROUVER = "Voulez-vous vraiment rendre cet objet perdu (oui / non) : ", ERR_REP = "ERREUR, vous devez entrer OUI ou NON! RECOMMENCEZ...",MSG_PAS_DOBJET = "** AUCUN OBJET PERDU N'EST CONSIGNE **",MSG_SOL_MOTS_CLE_RECHERCHE = "Mot(s) cle(s) recherches : " ,MSG_PAS_TROUVER = "** L'OBJET PERDU AYANT CET ID N'EST PAS CONSIGNE **";
	
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
		
		System.out.println(RECHERCHE_CATEGORIE);
		
		do {
			System.out.println(CATEGORIE);
			
			System.out.print(CHOIX);
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

		System.out.println(RESULAT_RECHERCHE);
		
		while(i < ObjetPerdu.getSequenceId() - 1) {
			if(objetsPerdus[i].getCategorie() == categorie) {
				flag = true;
				System.out.println("ID           : " + objetsPerdus[i].getId());
				System.out.println("MOTS CLES    : " + objetsPerdus[i].obtenirMotsCles());
				System.out.println("CATEGORIE    : " + ObjetPerdu.CATEGORIES[objetsPerdus[i].getCategorie()]);
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
		int jour,mois,annee,r=0,j=0, i=0,jourf,moisf,anneef;
		int[] id = new int[0];
		Date date = new Date(),date2 = new Date();
		boolean flag;
		String rep;
		
		
		
			System.out.println(RECHERCHE_DATE);
			
			
			rep = TP3Utils.validerRepDeuxChoix(DATE_PERIODE, ERR_REP_D_P, "p", "d");
			
			
			
			if(rep.equalsIgnoreCase("p")) {
				flag = false;

				System.out.println("Date du debut de la periode : ");
				do {
					do {
						
						jour = TP3Utils.validerTypeEntierStrictPositif("\tEntrez le jour de la date : ",ERR_POSITIF);
						
					}while(jour <= 0);
					
					do {
						
						mois = TP3Utils.validerTypeEntierStrictPositif("\tEntrez le mois de la date : ",ERR_POSITIF);
						
					}while(mois <= 0);
					
					do {
						
						annee = TP3Utils.validerTypeEntierStrictPositif("\tEntrez l'annee de la date : ",ERR_POSITIF);
						
					}while(mois <= 0);
					
					date.setJour(jour);
					date.setMois(mois);
					date.setAnnee(annee);
					
					flag = date.estDateValide();
					

					flag = date.estPlusPetite(Date.dateDuJour());
					
					if(!flag)
						flag = date.estEgale(Date.dateDuJour());
					
					if(!flag)
						System.out.println(DATE_INVALIDE);
				
					
				}while(!flag);
				
				flag = false;
				
				System.out.println("Date de la fin de la periode : ");
				do {
					do {
						
						jourf = TP3Utils.validerTypeEntierStrictPositif("\tEntrez le jour de la date : ",ERR_POSITIF);
						
					}while(jourf <= 0);
					
					do {
						
						moisf = TP3Utils.validerTypeEntierStrictPositif("\tEntrez le mois de la date : ",ERR_POSITIF);
						
					}while(moisf <= 0);
					
					do {
						
						anneef = TP3Utils.validerTypeEntierStrictPositif("\tEntrez l'annee de la date : ",ERR_POSITIF);
						
					}while(mois <= 0);
					
					date2.setJour(jourf);
					date2.setMois(moisf);
					date2.setAnnee(anneef);
					
					flag = date2.estDateValide();
					

					flag = date2.estPlusPetite(Date.dateDuJour());
					
					if(!flag)
						flag = date2.estEgale(Date.dateDuJour());
					
					if(!flag && date.estPlusPetite(date2))
						System.out.println(DATE_INVALIDE);
				
					
				}while(!flag);
				
				if(!date.estEgale(date2)) {
				
				flag = false;
			
				objetsPerdus = TP3Utils.ordonnerObjetsPerdusParDate(objetsPerdus);
				

				i=0;
				while(i < ObjetPerdu.getSequenceId() -1 && !flag) {	
					if((objetsPerdus[i].getDate().estPlusPetite(date))) {
						i++;
					}
					else {
						flag = true;
					}
				}
				
				if(!flag) {
					System.out.println(OBJET_NON_TROUVE);
				}
				
				else {
				//flag = false;
				
				//j=i;
				while(r < objetsPerdus.length && objetsPerdus[j] != null  /*&& !flag*/) {
					if((objetsPerdus[j].getDate().estPlusPetite(date2))) {
						j++;
						r++;
					}
					else
						r++;
						//flag = true;
				}
				
				j--;
				
				for(int z=i,l=0; z<=j; l++,z++) {
					id = ObjetPerdu.agrandirTableau(id,1);
					id[l] = objetsPerdus[z].getId()-1;
				}
								
				
				objetsPerdus = TP3Utils.ordonnerObjetsPerdusParId(objetsPerdus);
				i=0;
				if(flag && id.length != 0) {
					while(i < id.length) {
						System.out.println("ID           : " + objetsPerdus[id[i]].getId());
						System.out.println("MOTS CLES    : " + objetsPerdus[id[i]].obtenirMotsCles());
						System.out.println("CATEGORIE    : " + ObjetPerdu.CATEGORIES[objetsPerdus[id[i]].getCategorie()]);
						System.out.println("DATE         : " + objetsPerdus[id[i]].getDate());
						System.out.println("LOCALISATION : " + objetsPerdus[id[i]].getLocalisation());
						System.out.println();
						i++;
					}
				}
				
				else {
					System.out.println(OBJET_NON_TROUVE);
				}
				}
				}
							
				
			}
			
			if(rep.equalsIgnoreCase("d") || date.estEgale(date2)) {
				System.out.println("Date du debut de la periode ++++d++++: ");
				if(date.estEgale(date2)) {
					
				}
				
				else {

				do {
					do {
						
						jour = TP3Utils.validerTypeEntierStrictPositif("\tEntrez le jour de la date : ",ERR_POSITIF);
						
					}while(jour <= 0);
					
					do {
						
						mois = TP3Utils.validerTypeEntierStrictPositif("\tEntrez le mois de la date : ",ERR_POSITIF);
						
					}while(mois <= 0);
					
					do {
						
						annee = TP3Utils.validerTypeEntierStrictPositif("\tEntrez l'annee de la date : ",ERR_POSITIF);
						
					}while(mois <= 0);
					
					date.setJour(jour);
					date.setMois(mois);
					date.setAnnee(annee);
					
					flag = date.estDateValide();
					
					flag = date.estPlusPetite(Date.dateDuJour());
					
					if(!flag)
						flag = date.estEgale(Date.dateDuJour());
					
					if(!flag)
						System.out.println(DATE_INVALIDE);
				
					
				}while(!flag);
				
				}
				flag = false;
						
				System.out.println("RESULTAT(S) DE LA RECHERCHE : ");
				
				while(i < ObjetPerdu.getSequenceId() - 1) {
					if(objetsPerdus[i].getDate().estEgale(date)) {
						flag = true;
						System.out.println("ID           : " + objetsPerdus[i].getId());
						System.out.println("MOTS CLES    : " + objetsPerdus[i].obtenirMotsCles());
						System.out.println("CATEGORIE    : " + ObjetPerdu.CATEGORIES[objetsPerdus[i].getCategorie()]);
						System.out.println("DATE         : " + objetsPerdus[i].getDate());
						System.out.println("LOCALISATION : " + objetsPerdus[i].getLocalisation());
						System.out.println();
					}
					i++;
				}
				
				if(!flag) 
					System.out.println(OBJET_NON_TROUVE);
				
			}
		
		
		System.out.println(ENTREE);
		Clavier.lireFinLigne();
		
		
	}
	
	public static void rechercherObjetMots(ObjetPerdu[] objetsPerdus) {
		String motsCle;
		int i=0;
		String[] motsCles;
		boolean flag = false;
		
			System.out.println(RECHERCHE_MOTCLE);
			
			motsCle = TP3Utils.validerLngChaine(MSG_SOL_MOTS_CLE_RECHERCHE,MSG_ERR_MOTS_CLE,2,50);
			motsCle = motsCle.trim();
			
			motsCles = motsCle.split("\\s+");
			
			System.out.println("RESULTAT(S) DE LA RECHERCHE :");
			
			while(i < ObjetPerdu.getSequenceId() - 1) {
				objetsPerdus[i].motsCles =  objetsPerdus[i].obtenirMotsCles().split(" ");
					if(containsArray(objetsPerdus[i].motsCles ,motsCles)) {
						flag = true;
						System.out.println("ID           : " + objetsPerdus[i].getId());
						System.out.println("MOTS CLES    : " + objetsPerdus[i].obtenirMotsCles());
						System.out.println("CATEGORIE    : " + ObjetPerdu.CATEGORIES[objetsPerdus[i].getCategorie()]);
						System.out.println("DATE         : " + objetsPerdus[i].getDate());
						System.out.println("LOCALISATION : " + objetsPerdus[i].getLocalisation());
						System.out.println();
						}
					i++;
			}
			
			if(!flag) 
				System.out.println(OBJET_NON_TROUVE);
			
		
		
		System.out.println(ENTREE);
		Clavier.lireFinLigne();
	}
	
	public static ObjetPerdu[] reclamation(ObjetPerdu[] objetsPerdus) {
		int id, i=0;
		String rep;
		boolean flag = false;
		
		System.out.println("-----------------------\r\n"
				+ "RENDRE UN OBJET RECLAME\r\n"
				+ "-----------------------");
		
		id = TP3Utils.validerTypeEntierStrictPositif("Entrez le numero d'identification (id) de l'objet a rendre : ",ERR_POSITIF);
				
		while(i < objetsPerdus.length  && !flag) {
			if(objetsPerdus[i].getId() == id)
				flag = true;
			else 
				i++;
		}
		
		
		if(!flag) {
			System.out.println(MSG_PAS_TROUVER);
		
		System.out.println(ENTREE);
		Clavier.lireFinLigne();
		}
		
		else {
			System.out.println("ID           : " + objetsPerdus[i].getId());
			System.out.println("MOTS CLES    : " + objetsPerdus[i].obtenirMotsCles());
			System.out.println("CATEGORIE    : " + ObjetPerdu.CATEGORIES[objetsPerdus[i].getCategorie()]);
			System.out.println("DATE         : " + objetsPerdus[i].getDate());
			System.out.println("LOCALISATION : " + objetsPerdus[i].getLocalisation());
			System.out.println();
			
			rep = TP3Utils.validerRepDeuxChoix(MSG_TROUVER, ERR_REP, "oui", "non");
			
			if(rep.equalsIgnoreCase("non")) {
				System.out.println(ANNULATION_REMISE);
				System.out.println(ENTREE);
				Clavier.lireFinLigne();
			}
			
			else if(rep.equalsIgnoreCase("oui")) {
				objetsPerdus = ObjetPerdu.diminuerTableau(objetsPerdus, 1, i);
				ObjetPerdu.setSequenceId(ObjetPerdu.getSequenceId()-1);
				System.out.println(REMISE_SUCCES);
				System.out.println(ENTREE);
				Clavier.lireFinLigne();
				
						
			}
				
		}
		return objetsPerdus;
		
	}
	
	public static void affichage(ObjetPerdu[] objetsPerdus) {
		int i=0; 
		System.out.println("----------------------------------\r\n"
				+ "AFFICHER TOUS LES OBJETS CONSIGNES\r\n"
				+ "----------------------------------");
		
		while(i < ObjetPerdu.getSequenceId() - 1) {
			System.out.println("ID           : " + objetsPerdus[i].getId());
			System.out.println("MOTS CLES    : " + objetsPerdus[i].obtenirMotsCles());
			System.out.println("CATEGORIE    : " + ObjetPerdu.CATEGORIES[objetsPerdus[i].getCategorie()]);
			System.out.println("DATE         : " + objetsPerdus[i].getDate());
			System.out.println("LOCALISATION : " + objetsPerdus[i].getLocalisation());
			System.out.println();
			i++;
		}
		
		System.out.println(ENTREE);
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
				
				jour = TP3Utils.validerTypeEntierStrictPositif("\tEntrez le jour de la date : ",ERR_POSITIF);
				
			}while(jour <= 0);
			
			do {
				
				mois = TP3Utils.validerTypeEntierStrictPositif("\tEntrez le mois de la date : ",ERR_POSITIF);
				
			}while(mois <= 0);
			
			do {
				
				annee = TP3Utils.validerTypeEntierStrictPositif("\tEntrez l'annee de la date : ",ERR_POSITIF);
				
			}while(mois <= 0);
			
			date.setJour(jour);
			date.setMois(mois);
			date.setAnnee(annee);
			
			flag = date.estDateValide();
			

			flag = date.estPlusPetite(Date.dateDuJour());
			
			if(!flag)
				flag = date.estEgale(Date.dateDuJour());
			
			if(!flag)
				System.out.println(DATE_INVALIDE);
		
			
		}while(!flag);
	
		motsCle = TP3Utils.validerLngChaine(MSG_SOL_MOTS_CLE,MSG_ERR_MOTS_CLE,2,50);
		motsCles = motsCle.split("\\s+") ; 
		
		
		localisation = TP3Utils.validerLngChaine("Entrez la localisation de l'objet perdu consigne : \r\n",MSG_ERR_MOTS_CLE,5,50);
		
		objet = new ObjetPerdu(categorie,date,localisation);
		
		
		if(objetsPerdus.length == 0 || objetsPerdus[objetsPerdus.length - 1] != null)
			objetsPerdus = ObjetPerdu.agrandirTableau(objetsPerdus,4);
		
		
		else {
			objetsPerdus[ObjetPerdu.getSequenceId() -2] = objet;
			objetsPerdus[ObjetPerdu.getSequenceId() -2].motsCles = ObjetPerdu.agrandirTableau(objetsPerdus[ObjetPerdu.getSequenceId() -2].motsCles,motsCles.length); 
			for(int i=0 ; i<motsCles.length ; i++)
				objetsPerdus[ObjetPerdu.getSequenceId() -2].ajouterMotCle(motsCles[i]); //Msg d erreur ?
			
		}
		

	}
	
	
	public static void menu() {
		System.out.println(MENU);
	}
	
	public static void main(String[] args) {
        String choix;
        ObjetPerdu[] objetsPerdus = null; //= new ObjetPerdu[10];
        //objetsPerdus = TP3Utils.recupererDonnees();

        do {
            menu();
            System.out.print("Entrez votre choix : ");
            
            choix = Clavier.lireString();

            switch (choix) {
                case "1":
                	//consignerObjet(date,objetsPerdus);
                    objetsPerdus = TP3Utils.recupererDonnees();
                    break;
                    
                case "2":
                	if(ObjetPerdu.getSequenceId() > 0)
                		objetsPerdus = reclamation(objetsPerdus);
                	else
                		System.out.println(MSG_PAS_DOBJET);
                	
                    break;

                case "3":
                	if(ObjetPerdu.getSequenceId() > 0)
                		rechercherObjetMots(objetsPerdus);
                	else
                		System.out.println(MSG_PAS_DOBJET);
                    break;

                case "4":
                	if(ObjetPerdu.getSequenceId() > 0)
                		rechercherObjetDate(objetsPerdus);
                	else
                		System.out.println(MSG_PAS_DOBJET);
                    break;
                case "5":
                	if(ObjetPerdu.getSequenceId() > 0)
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