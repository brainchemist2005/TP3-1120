/**
 * Cette classe permet la gestion des objets perdus. Elle peut être utilisée dans un comptoir des objets perdus.
 * Elle permet de supprimer, ajouter et lister les objets perdus. Elle permet également d'afficher les objets par
 * mots clés, date et catégorie. Enfin, elle sauvegarde les résultats dans un fichier texte.
 *
 * @author Zakariae Bouargan
 * Code Permanent: BOUZ90340206
 * Courriel: fg591955@uqam.ca
 * Cours : INF1120
 * @version 20/04/2023
 */



public class GestionObjetsPerdus {
    final static String LOCALISATION = "LOCALISATION : " , DATE = "DATE         : ", CATEGORIES = "CATEGORIE    : " , ID= "ID           : ",MOTS_CLE = "MOTS CLES    : ", ENTRER_ANNEE = "\tEntrez l'annee de la date : " , ENTRER_MOIS = "\tEntrez le mois de la date : " ,ENTRER_JOUR = "\tEntrez le jour de la date : " ,ENTRER_ID = "Entrez le numero d'identification (id) de l'objet a rendre : ", AUREVOIR = "AUREVOIR !", ENTREE = "Appuyez sur <ENTREE> pour revenir au menu... ", RECHERCHE_MOTCLE = "------------------------\r\nRECHERCHER PAR MOTS CLES\r\n------------------------", DATE_INVALIDE = "ERREUR, date invalide! RECOMMENCEZ...", MENU = "=========================\r\nGESTION DES OBJETS PERDUS\r\n=========================\r\n\r\n\r\n----\r\nMENU\r\n----\r\n1. Consigner un objet perdu\r\n2. Rendre un objet reclame\r\n3. Rechercher un objet par mots cles\r\n4. Rechercher un objet par date(s)\r\n5. Rechercher un objet par categorie\r\n6. Afficher tous les objets consignes\r\n7. Quitter", RESULAT_RECHERCHE = "RESULTAT(S) DE LA RECHERCHE : ", RECHERCHE_DATE = "----------------------\r\nRECHERCHER PAR DATE(S)\r\n----------------------", CHOIX = "Entrez votre choix : ", CATEGORIE = "CATEGORIES :\r\n1. bijou\r\n2. vetement\r\n3. argent / portefeuille\r\n4. cle(s)\r\n5. autre\n", ERR_REP_D_P = "ERREUR, entrez le caracere D ou P! RECOMMENCEZ...", DATE_PERIODE = "Specifier une (d)ate ou une (p)eriode : ", OBJET_NON_TROUVE = "** AUCUN OBJET TROUVE **", ERREUR_MENU = "ERREUR, vous devez entrer un choix entre 1 et 7! RECOMMENCEZ...", REMISE_SUCCES = "** LA REMISE DE L'OBJET PERDU A ETE EFFECTUEE AVEC SUCCES **", ERR_POSITIF = "ERREUR, entrez un entier strictement positif! RECOMMENCEZ...", MSG_SOL_MOTS_CLE = "Entrez les mots-cles decrivant l'objet a consigner : ", MSG_ERR_MOTS_CLE = "ERREUR, la chaine doit contenir entre 2 et 50 caracteres! RECOMMENCEZ...", RECHERCHE_CATEGORIE = "------------------------\r\nRECHERCHER PAR CATEGORIE\r\n------------------------", MSG_ERR_MOTS_LOCALISATION = "ERREUR, la chaine doit contenir entre 5 et 50 caracteres! RECOMMENCEZ...", ANNULATION_REMISE = "** LA REMISE DE L'OBJET PERDU A ETE ANNULEE **", ERREUR_MENU_CATEGORIE = "ERREUR, vous devez entrer un choix entre 1 et 5! RECOMMENCEZ...", MSG_TROUVER = "Voulez-vous vraiment rendre cet objet perdu (oui / non) : ", ERR_REP = "ERREUR, vous devez entrer OUI ou NON! RECOMMENCEZ...", MSG_PAS_DOBJET = "** AUCUN OBJET PERDU N'EST CONSIGNE **", MSG_SOL_MOTS_CLE_RECHERCHE = "Mot(s) cle(s) recherches : ", MSG_PAS_TROUVER = "** L'OBJET PERDU AYANT CET ID N'EST PAS CONSIGNE **";


    /**

    Cette méthode vérifie si un tableau de chaînes de caractères contient un autre tableau de chaînes de caractères.
    @param tableau le tableau de chaînes de caractères dans lequel chercher
    @param sousTableau le tableau de chaînes de caractères à chercher
    @return true si le sous-tableau est contenu dans le tableau, false sinon
    */
    public static boolean containsArray(String[] tableau, String[] sousTableau) {
        // Parcours le tableau principal jusqu'à la dernière position possible pour un sous-tableau
        int i = 0;
        while (i <= tableau.length - sousTableau.length) {
            // Initialise un flag pour vérifier si tous les éléments du sous-tableau sont présents
            boolean found = true;

            // Parcours les éléments du sous-tableau
            int j = 0;
            while (j < sousTableau.length) {
                // Vérifie si l'élément actuel du sous-tableau est présent dans le tableau principal (en ignorant la casse)
                if (!tableau[i + j].equalsIgnoreCase(sousTableau[j])) {
                    // Si l'élément n'est pas présent, on passe le flag à false et on sort de la boucle
                    found = false;
                    j++;
                } else {
                    // Sinon, on continue la vérification avec l'élément suivant du sous-tableau
                    j++;
                }
            }

            // Si tous les éléments du sous-tableau ont été trouvés, on retourne true
            if (found) {
                return true;
            }

            // Si on n'a pas trouvé le sous-tableau, on avance d'une position dans le tableau principal
            i++;
        }

        // Si on n'a pas trouvé le sous-tableau, on retourne false
        return false;
    }




    /**

    Cette méthode permet de rechercher les objets perdus en fonction de leur catégorie.

    Elle affiche les informations de chaque objet trouvé et affiche un message d'erreur si aucun objet

    correspondant à la catégorie spécifiée n'est trouvé.

    @param objetsPerdus le tableau d'objets perdus à parcourir pour effectuer la recherche
    */

    public static void rechercherObjetCategorie(ObjetPerdu[] objetsPerdus) {
        int categorie, i = 0;
        boolean flag = false;

        System.out.println(RECHERCHE_CATEGORIE);

        System.out.println(CATEGORIE);

        System.out.print(CHOIX);
        categorie = TP3Utils.validerEntier(CHOIX, ERREUR_MENU_CATEGORIE, 1, 5);


        System.out.println(RESULAT_RECHERCHE);

        //Boucle permettant de parcourir le tableau d'objets perdus et d'afficher les informations des objets
        while (i < ObjetPerdu.getSequenceId() - 1) {
            if (objetsPerdus[i].getCategorie() +1 == categorie) {
                flag = true;
                System.out.println(ID + objetsPerdus[i].getId());
                System.out.println(MOTS_CLE + objetsPerdus[i].obtenirMotsCles());
                System.out.println(CATEGORIES + ObjetPerdu.CATEGORIES[objetsPerdus[i].getCategorie()]);
                System.out.println(DATE + objetsPerdus[i].getDate());
                System.out.println(LOCALISATION + objetsPerdus[i].getLocalisation());
                System.out.println();
            }
            i++;
        }


        //Affichage d'un message d'erreur si aucun objet correspondant à la catégorie spécifiée n'est trouvé
        if (!flag)
            System.out.println(OBJET_NON_TROUVE);

    }


    /**

    Cette méthode permet de rechercher les objets perdus en fonction de leur date.

    Elle affiche les informations de chaque objet trouvé et affiche un message d'erreur si aucun objet

    correspondant à la catégorie spécifiée n'est trouvé.

    @param objetsPerdus le tableau d'objets perdus à parcourir pour effectuer la recherche
    */
    public static void rechercherObjetDate(ObjetPerdu[] objetsPerdus) {
        int jour, mois, annee,l,r = 0, j = 0, i = 0, jourf, moisf, anneef;
        int[] id = new int[0];
        Date date = new Date(), date2 = new Date();
        boolean flag, flag1;
        String rep;



        System.out.println(RECHERCHE_DATE);


        rep = TP3Utils.validerRepDeuxChoix(DATE_PERIODE, ERR_REP_D_P, "p", "d");
        date2.setMois(1);
        date2.setJour(1);
        date2.setAnnee(1);


        if (rep.equalsIgnoreCase("p")) {
            flag = false;

            System.out.println("Date du debut de la periode : ");
            do {
            	
            	//je stocke les valeurs du debut de la periode
                jour = TP3Utils.validerTypeEntierStrictPositif(ENTRER_JOUR, ERR_POSITIF);
                mois = TP3Utils.validerTypeEntierStrictPositif(ENTRER_MOIS, ERR_POSITIF);
                annee = TP3Utils.validerTypeEntierStrictPositif(ENTRER_ANNEE, ERR_POSITIF);

                date.setJour(jour);
                date.setMois(mois);
                date.setAnnee(annee);

                flag = date.estDateValide();


                flag1 = date.estPlusPetite(Date.dateDuJour());

                if (!flag1)
                    flag = date.estEgale(Date.dateDuJour());

                if (!flag)
                    System.out.println(DATE_INVALIDE);

                else if (!flag1)
                    System.out.println(DATE_INVALIDE);



            } while (!flag || !flag1);

            flag = false;

            System.out.println("Date de la fin de la periode : ");
            do {
            		
            	//je stocke les valeurs de la fin de la periode
                jourf = TP3Utils.validerTypeEntierStrictPositif(ENTRER_JOUR, ERR_POSITIF);
                moisf = TP3Utils.validerTypeEntierStrictPositif(ENTRER_MOIS, ERR_POSITIF);
                anneef = TP3Utils.validerTypeEntierStrictPositif(ENTRER_ANNEE, ERR_POSITIF);


                date2.setJour(jourf + 1); // J'ai ajouté 1 pour inclure le jour jourf
                date2.setMois(moisf);
                date2.setAnnee(anneef);

                flag = date2.estDateValide();


                flag = date2.estPlusPetite(Date.dateDuJour());

                if (!flag)
                    flag = date2.estEgale(Date.dateDuJour());

                if (!flag && date.estPlusPetite(date2))
                    System.out.println(DATE_INVALIDE);


            } while (!flag);

            if (!date.estEgale(date2)) {

                flag = false;

                objetsPerdus = TP3Utils.ordonnerObjetsPerdusParDate(objetsPerdus);

                i = 0;
                while (i < ObjetPerdu.getSequenceId() - 1 && !flag) {
                    if ((objetsPerdus[i].getDate().estPlusPetite(date))) {
                        i++;
                    } else {
                        flag = true;
                    }
                }

                if (!flag) {
                    System.out.println(OBJET_NON_TROUVE);
                } else {
                    while (r < objetsPerdus.length && objetsPerdus[j] != null) {
                        if ((objetsPerdus[j].getDate().estPlusPetite(date2))) {
                            j++;
                            r++;
                        } else
                            r++;
                    }

                    j--;
                    l = 0;
                    for (int z = i; z <= j;  z++) {
                        id = ObjetPerdu.agrandirTableau(id, 1);
                        id[l] = objetsPerdus[z].getId() - 1;
                        l++;
                    }


                    objetsPerdus = TP3Utils.ordonnerObjetsPerdusParId(objetsPerdus);
                    i = 0;
                    if (flag && id.length != 0) {
                        while (i < id.length) {
                            System.out.println(ID + objetsPerdus[id[i]].getId());
                            System.out.println(MOTS_CLE + objetsPerdus[id[i]].obtenirMotsCles());
                            System.out.println(CATEGORIES + ObjetPerdu.CATEGORIES[objetsPerdus[id[i]].getCategorie()]);
                            System.out.println(DATE + objetsPerdus[id[i]].getDate());
                            System.out.println(LOCALISATION + objetsPerdus[id[i]].getLocalisation());
                            System.out.println();
                            i++;
                        }
                    } else {
                        System.out.println(OBJET_NON_TROUVE);
                    }
                }
            }


        }

        if (rep.equalsIgnoreCase("d") || date.estEgale(date2)) {

            if (date.estEgale(date2)) {
                System.out.println(date.estEgale(date2));
            } else {
                do {
                    System.out.println("Date du debut de la periode ");
                    jour = TP3Utils.validerTypeEntierStrictPositif(ENTRER_JOUR ,ERR_POSITIF);
                    mois = TP3Utils.validerTypeEntierStrictPositif(ENTRER_MOIS, ERR_POSITIF);
                    annee = TP3Utils.validerTypeEntierStrictPositif(ENTRER_ANNEE, ERR_POSITIF);


                    date.setJour(jour);
                    date.setMois(mois);
                    date.setAnnee(annee);

                    flag = date.estDateValide();

                    flag1 = date.estPlusPetite(Date.dateDuJour());

                    if (!flag1)
                        flag = date.estEgale(Date.dateDuJour());

                    if (!flag)
                        System.out.println(DATE_INVALIDE);

                    else if (!flag1)
                        System.out.println(DATE_INVALIDE);

                } while (!flag || !flag1);

            }
            flag = false;

            System.out.println("RESULTAT(S) DE LA RECHERCHE : ");

            while (i < ObjetPerdu.getSequenceId() - 1) {
                if (objetsPerdus[i].getDate().estEgale(date)) {
                    flag = true;
                    System.out.println(ID + objetsPerdus[i].getId());
                    System.out.println(MOTS_CLE + objetsPerdus[i].obtenirMotsCles());
                    System.out.println(CATEGORIES + ObjetPerdu.CATEGORIES[objetsPerdus[i].getCategorie()]);
                    System.out.println(DATE + objetsPerdus[i].getDate());
                    System.out.println(LOCALISATION + objetsPerdus[i].getLocalisation());
                    System.out.println();
                }
                i++;
            }

            if (!flag)
                System.out.println(OBJET_NON_TROUVE);

        }

        System.out.println(ENTREE);
        Clavier.lireFinLigne();

    }


    /**
     * Recherche des objets perdus en fonction des mots-clés saisis par l'utilisateur. Les objets trouvés sont affichés
     * à l'écran. La méthode prend en entrée un tableau d'objets perdus.
     *
     * @param objetsPerdus un tableau d'objets perdus dans lequel la recherche est effectuée.
     */
    public static void rechercherObjetMots(ObjetPerdu[] objetsPerdus) {
        String motsCle;
        int i = 0;
        String[] motsCles;
        boolean flag = false;

        System.out.println(RECHERCHE_MOTCLE);

        // Validation de la saisie de l'utilisateur pour les mots-clés à rechercher

        motsCle = TP3Utils.validerLngChaine(MSG_SOL_MOTS_CLE_RECHERCHE, MSG_ERR_MOTS_CLE, 2, 50);
        motsCle = motsCle.trim();

        motsCles = motsCle.split("\\s+");

        System.out.println("RESULTAT(S) DE LA RECHERCHE :");
        // Parcours du tableau d'objets perdus pour vérifier si les mots-clés recherchés sont présents dans chaque objet

        while (i < ObjetPerdu.getSequenceId() - 1) {
            objetsPerdus[i].motsCles = objetsPerdus[i].obtenirMotsCles().split(" ");
            // Vérification si les mots-clés recherchés sont présents dans l'objet actuellement parcouru

            if (containsArray(objetsPerdus[i].motsCles, motsCles)) {
                flag = true;
                System.out.println(ID + objetsPerdus[i].getId());
                System.out.println(MOTS_CLE + objetsPerdus[i].obtenirMotsCles());
                System.out.println(CATEGORIES + ObjetPerdu.CATEGORIES[objetsPerdus[i].getCategorie()]);
                System.out.println(DATE + objetsPerdus[i].getDate());
                System.out.println(LOCALISATION + objetsPerdus[i].getLocalisation());
                System.out.println();
            }
            i++;
        }


        // Affichage d'un message demandant à l'utilisateur de presser la touche Entrée pour continuer
        if (!flag)
            System.out.println(OBJET_NON_TROUVE);



        System.out.println(ENTREE);
        Clavier.lireFinLigne();
    }

    /**

    Cette méthode permet de gérer la réclamation d'un objet perdu. Elle prend en entrée un tableau d'ObjetPerdu
    et demande à l'utilisateur d'entrer l'identifiant de l'objet à rendre. Elle parcourt le tableau pour
    trouver l'objet correspondant à l'identifiant. Si l'objet est trouvé, elle affiche les informations
    de l'objet et demande à l'utilisateur s'il a trouvé l'objet. Si la réponse est non, elle annule la remise de l'objet.
    Si la réponse est oui, elle supprime l'objet du tableau et affiche un message de succès.
    Elle renvoie le tableau d'ObjetPerdu modifié.
    @param objetsPerdus le tableau d'ObjetPerdu à modifier
    @return le tableau d'ObjetPerdu modifié
    */
    public static ObjetPerdu[] reclamation(ObjetPerdu[] objetsPerdus) {
        int id, i = 0;
        String rep;
        boolean flag = false;

        System.out.println("-----------------------\r\n" +
            "RENDRE UN OBJET RECLAME\r\n" +
            "-----------------------");

        id = TP3Utils.validerTypeEntierStrictPositif(ENTRER_ID, ERR_POSITIF);

        // Vérifie si l'objet existe dans le tableau des objets perdus
        while (i < objetsPerdus.length && !flag) {
            if (objetsPerdus[i].getId() == id)
                flag = true;
            else
                i++;
        }

        // Si l'objet n'est pas trouvé, affiche un message d'erreur
        if (!flag) {
            System.out.println(MSG_PAS_TROUVER);

        }

        // Si l'objet est trouvé, affiche ses informations et demande confirmation pour sa remise
        else {
            System.out.println(ID + objetsPerdus[i].getId());
            System.out.println(MOTS_CLE + objetsPerdus[i].obtenirMotsCles());
            System.out.println(CATEGORIES + ObjetPerdu.CATEGORIES[objetsPerdus[i].getCategorie()]);
            System.out.println(DATE + objetsPerdus[i].getDate());
            System.out.println(LOCALISATION + objetsPerdus[i].getLocalisation());
            System.out.println();

            // Demande confirmation pour la remise de l'objet
            rep = TP3Utils.validerRepDeuxChoix(MSG_TROUVER, ERR_REP, "oui", "non");

            if (rep.equalsIgnoreCase("non")) {
                System.out.println(ANNULATION_REMISE);
            }

            // Si l'utilisateur confirme la remise, retire l'objet du tableau des objets perdus
            else if (rep.equalsIgnoreCase("oui")) {

                objetsPerdus = ObjetPerdu.diminuerTableau(objetsPerdus, 1, i);
                ObjetPerdu.setSequenceId(ObjetPerdu.getSequenceId() - 1);
                System.out.println(REMISE_SUCCES);



            }

        }

        System.out.println(ENTREE);
        Clavier.lireFinLigne();

        return objetsPerdus;

    }

    /**

    Affiche tous les objets perdus dans le tableau d'objets passés en paramètre.

    @param objetsPerdus le tableau d'objets perdus à afficher
    */
    public static void affichage(ObjetPerdu[] objetsPerdus) {
        int i = 0;
        System.out.println("----------------------------------\r\nAFFICHER TOUS LES OBJETS CONSIGNES\r\n----------------------------------");

        while (i < ObjetPerdu.getSequenceId() - 1) {
            System.out.println(ID + objetsPerdus[i].getId());
            System.out.println(MOTS_CLE + objetsPerdus[i].obtenirMotsCles());
            System.out.println(CATEGORIES + ObjetPerdu.CATEGORIES[objetsPerdus[i].getCategorie()]);
            System.out.println(DATE + objetsPerdus[i].getDate());
            System.out.println(LOCALISATION + objetsPerdus[i].getLocalisation());
            System.out.println();
            i++;
        }

        System.out.println(ENTREE);
        Clavier.lireFinLigne();
    }

    /**

    Cette méthode permet de consigner un objet perdu dans un tableau d'objets perdus.
    @param date La date à laquelle l'objet perdu a été consigné.
    @param objetsPerdus Le tableau d'objets perdus dans lequel consigner l'objet.
    @return Le tableau d'objets perdus mis à jour avec le nouvel objet consigné.
    */
    public static ObjetPerdu[] consignerObjet(Date date, ObjetPerdu[] objetsPerdus) {
        ObjetPerdu objet;
        String motsCle, localisation;
        int categorie = 0;
        String motsCles[];
        boolean flag, flag1;
        int jour = 0, mois, annee;


        System.out.println("------------------------\r\nCONSIGNER UN OBJET PERDU\r\n------------------------");
        System.out.print(CATEGORIE);
        categorie = TP3Utils.validerEntier(CHOIX, ERREUR_MENU_CATEGORIE, 1, 5);


        do {
            jour = TP3Utils.validerTypeEntierStrictPositif(ENTRER_JOUR, ERR_POSITIF);
            mois = TP3Utils.validerTypeEntierStrictPositif(ENTRER_MOIS, ERR_POSITIF);
            annee = TP3Utils.validerTypeEntierStrictPositif(ENTRER_ANNEE, ERR_POSITIF);

            date.setJour(jour);
            date.setMois(mois);
            date.setAnnee(annee);

            flag = date.estDateValide();


            flag1 = date.estPlusPetite(Date.dateDuJour());

            if (!flag1)
                flag = date.estEgale(Date.dateDuJour());

            if (!flag)
                System.out.println(DATE_INVALIDE);

            else if (!flag1)
                System.out.println(DATE_INVALIDE);



        } while (!flag || !flag1);

        motsCle = TP3Utils.validerLngChaine(MSG_SOL_MOTS_CLE, MSG_ERR_MOTS_CLE, 2, 50);
        motsCles = motsCle.split("\\s+");


        localisation = TP3Utils.validerLngChaine("Entrez la localisation de l'objet perdu consigne : ", MSG_ERR_MOTS_CLE, 5, 50);

        objet = new ObjetPerdu(categorie-1, date, localisation);


        if (objetsPerdus.length == 0 || objetsPerdus[objetsPerdus.length - 1] != null)
            objetsPerdus = ObjetPerdu.agrandirTableau(objetsPerdus, 4);


        objetsPerdus[ObjetPerdu.getSequenceId() - 2] = objet;
        objetsPerdus[ObjetPerdu.getSequenceId() - 2].motsCles = ObjetPerdu.agrandirTableau(objetsPerdus[ObjetPerdu.getSequenceId() - 2].motsCles, motsCles.length);
        for (int i = 0; i < motsCles.length; i++)
            objetsPerdus[ObjetPerdu.getSequenceId() - 2].ajouterMotCle(motsCles[i]);


        return objetsPerdus;
    }


    public static void menu() {
        System.out.println(MENU);
    }

    public static void main(String[] args) {
        Date date = new Date();
        int choix;
        ObjetPerdu[] objetsPerdus = TP3Utils.recupererDonnees();

        do {
            menu();

            choix = TP3Utils.validerEntier(CHOIX, ERREUR_MENU, 1, 7);

            switch (choix) {
                case 1:
                    objetsPerdus = consignerObjet(date, objetsPerdus);
                    break;

                case 2:
                    if (ObjetPerdu.getSequenceId() > 0)
                        objetsPerdus = reclamation(objetsPerdus);
                    else
                        System.out.println(MSG_PAS_DOBJET);

                    break;

                case 3:
                    if (ObjetPerdu.getSequenceId() > 0)
                        rechercherObjetMots(objetsPerdus);
                    else
                        System.out.println(MSG_PAS_DOBJET);
                    break;

                case 4:
                    if (ObjetPerdu.getSequenceId() > 0)
                        rechercherObjetDate(objetsPerdus);
                    else
                        System.out.println(MSG_PAS_DOBJET);
                    break;
                case 5:
                    if (ObjetPerdu.getSequenceId() > 0)
                        rechercherObjetCategorie(objetsPerdus);

                    else
                        System.out.println(MSG_PAS_DOBJET);

                    break;
                case 6:
                    affichage(objetsPerdus);
                    break;
                case 7:
                    TP3Utils.sauvegarder(objetsPerdus);
                    System.out.print(AUREVOIR);
                    break;



            }

        } while (choix != 7);
    }
}