/**
 * Cette classe contient les methodes pour pour gerer la gestion des objets perdus.
 * Les objets perdus sont stockés dans une liste et peuvent être ajoutés, modifiés
 * ou supprimés de la liste.
 *
 * @author Zakariae Bouargan
 * Code Permanent: BOUZ90340206
 * Courriel: fg591955@uqam.ca
 * Cours : INF1120
 * @version 20/04/2023
 */

public class ObjetPerdu {

    final static int CAT_BIJOU = 0, CAT_VETEMENT = 1, CAT_ARGENT_PORTEFEUILLE = 2, CAT_CLE = 3, CAT_AUTRE = 4;
    final static String[] CATEGORIES = {
        "bijou",
        "vetement",
        "argent / portefeuille",
        "cle(s)",
        "autre"
    };

    private static int sequenceId = 1;


    public int id, categorie, nbrElem = 0;

    private Date date = new Date();

    private String localisation;

    String[] motsCles;

    /**

    Constructeur de la classe ObjetPerdu.
    
    ANTECEDENTS :
    	-doit être une valeur entre 0 et CATEGORIES.length – 1 inclusivement.
    
    @param categorie La catégorie de l'objet perdu.
    
    @param date La date à laquelle l'objet a été perdu.
    
    @param localisation La localisation où l'objet a été perdu.
    */
    public ObjetPerdu(int categorie, Date date, String localisation) {
        this.categorie = categorie;
        this.date = date;
        this.localisation = localisation;
        this.id = sequenceId;
        sequenceId++;
        motsCles = new String[nbrElem];
    }

    /**

	Cette méthode permet d'agrandir un tableau de chaînes de caractères en ajoutant un nombre

	spécifié de cases supplémentaires à la fin du tableau. La méthode crée un nouveau tableau

	de chaînes de caractères avec la taille appropriée et copie les éléments du tableau original

	dans le nouveau tableau.

	@param tab le tableau de chaînes de caractères à agrandir

	@param nbrCasesDePlus le nombre de cases supplémentaires à ajouter au tableau

	@return le nouveau tableau de chaînes de caractères agrandi
*/

    public static String[] agrandirTableau(String[] tab, int nbrCasesDePlus) {
        //creer un nouveau tableau plus grand
        String[] tab2 = new String[tab.length + nbrCasesDePlus];

        //copier les éléments de tab dans tab2
        for (int i = 0; i < tab.length; i++) {
            tab2[i] = tab[i];
        }
        return tab2;
    }

    
    /**
     * Agrandit le tableau d'ObjetPerdu d'un nombre spécifié de cases.
     * 
     * @param tab le tableau à agrandir
     * 
     * @param nbrCasesDePlus le nombre de cases à ajouter au tableau
     * 
     * @return un nouveau tableau d'entiers agrandi
*/
    public static ObjetPerdu[] agrandirTableau(ObjetPerdu[] tab, int nbrCasesDePlus) {
        //creer un nouveau tableau plus grand
        ObjetPerdu[] tab2 = new ObjetPerdu[tab.length + nbrCasesDePlus];

        //copier les éléments de tab dans tab2
        for (int i = 0; i < tab.length; i++) {
            tab2[i] = tab[i];
        }
        return tab2;
    }

    /**
     * Agrandit le tableau d'entiers d'un nombre spécifié de cases.
     * 
     * @param tab le tableau à agrandir
     * 
     * @param nbrCasesDePlus le nombre de cases à ajouter au tableau
     * 
     * @return un nouveau tableau d'entiers agrandi
*/
    public static int[] agrandirTableau(int[] tab, int nbrCasesDePlus) {
        //creer un nouveau tableau plus grand
        int[] tab2 = new int[tab.length + nbrCasesDePlus];

        //copier les éléments de tab dans tab2
        for (int i = 0; i < tab.length; i++) {
            tab2[i] = tab[i];
        }
        return tab2;
    }

    /**
     * Diminue la taille du tableau de chaînes de caractères en supprimant les éléments spécifiés.
     * 
     * Les éléments à supprimer sont remplacés par la chaîne "$".
     * 
     * Antécédent:
	 *		-tab ne doit pas etre null ou vide
     *
     * @param tab Le tableau de chaînes de caractères à réduire
     * 
     * @param nbrCasesDeMoins Le nombre d'éléments à supprimer du tableau
     * 
     * @return Le nouveau tableau de chaînes de caractères avec les éléments supprimés
*/
    public static String[] diminuerTableau(String[] tab, int nbrCasesDeMoins) {
        //creer un nouveau tableau plus grand
        String[] tab2 = new String[tab.length - nbrCasesDeMoins];

        int j = 0;

        //copier les éléments de tab dans tab2
        for (int i = 0; i < tab.length - 1; i++) {
            if (tab[i].equals("$"))
                i++;

            tab2[j] = tab[i];
            j++;
        }

        return tab2;
    }

    /**
     * Réduit la taille d'un tableau d'objets perdus en supprimant un certain nombre de cases à partir d'une position donnée.
     * 
     * Les éléments restants sont copiés dans un nouveau tableau.
     * 
	 * Antécédent:
	 *		-tab ne doit pas etre null
     * 
     * @param tab le tableau d'objets perdus initial
     * 
     * @param nbrCasesDeMoins le nombre de cases à supprimer à partir de la position m
     * 
     * @param m la position à partir de laquelle supprimer les cases
     * 
     * @return un nouveau tableau contenant les éléments restants de tab
*/
    public static ObjetPerdu[] diminuerTableau(ObjetPerdu[] tab, int nbrCasesDeMoins, int m) {
        //creer un nouveau tableau plus grand
        ObjetPerdu[] tab2 = new ObjetPerdu[tab.length - nbrCasesDeMoins];
        int i = 0;

        tab[m] = null;
        //copier les éléments de tab dans tab2
        for (int j = 0; j < tab2.length; j++) {
            if (i < tab.length - 1 && tab[i] == null) {
                i++;
            }

            if (tab[i] != null) {
                tab2[j] = tab[i];
                i++;
            }
        }


        return tab2;
    }

    // *** getters ****
    
    public static int getSequenceId() {
        return sequenceId;
    }

    public static void setSequenceId(int i) {
        sequenceId = i;

    }

    /**
     * Renvoie la valeur de id
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Renvoie la valeur de categorie
     * @return categorie
     */
    public int getCategorie() {
        return categorie;
    }

    /**
     * Renvoie la valeur de date
     * @return date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Renvoie la valeur de localisation
     * @return localisation
     */
    public String getLocalisation() {
        return localisation;
    }
    
    // *** setters ****

    /** 
     * Affecte la valeur donnee a categorie 
     * Antécédent:
	 *	- doit être une valeur entre 0 et CATEGORIES.length – 1 inclusivement.
     * @param categorie
     */
    public void setCategorie(int categorie) {
        this.categorie = categorie;
    }

    /** 
     * Affecte la valeur donnee a date
     * @param date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /** 
     * Affecte la valeur donnee a localisation
     * @param localisation
     */
    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    /**

    Renvoie une chaîne de caractères contenant tous les mots clés de l'objet perdu.
    
    Si l'objet perdu ne possède pas de mots clés, la chaîne de caractères renvoyée est vide.
    
    @return une chaîne de caractères contenant tous les mots clés de l'objet perdu, ou une chaîne vide si aucun mot clé n'est associé.
*/
    public String obtenirMotsCles() {
        String motsCle = "";

        if (motsCles.length != 0) {
            for (int i = 0; i < motsCles.length; i++) {
                if (motsCles[i] != null) {
                    motsCle += motsCles[i] + " ";
                }
            }
            motsCle = motsCle.substring(0, motsCle.length() - 1);
        }


        return motsCle;
    }

    /**
     * Ajoute un mot-clé à l'objet perdu, s'il n'existe pas déjà dans sa liste de mots-clés.
     * 
     * @param motCle le mot-clé à ajouter à l'objet perdu
     * 
     * @return true si le mot-clé a été ajouté avec succès, false sinon
*/
    public Boolean ajouterMotCle(String motCle) {
        Boolean flag = true;

        if (motCle != null && motCle != "") {
            if (estAssocieACeMotCle(motCle)) {
                flag = false;
            }

            if (flag) {
                motsCles = agrandirTableau(motsCles, 1);
                motsCles[motsCles.length - 1] = motCle;
                nbrElem++;
            }
        } else
            flag = false;

        return flag;
    }

    
    /**

    Vérifie si l'objet est associé au mot-clé donné en paramètre.
    
    @param motCle le mot-clé à vérifier
    
    @return true si l'objet est associé au mot-clé, false sinon
 */
    public boolean estAssocieACeMotCle(String motCle) {

        int i = 0;
        boolean flag = false;


        while (i < motsCles.length && !flag) {
            if (motCle.equalsIgnoreCase(motsCles[i]))
                flag = true;
            else
                i++;
        }


        return flag;
    }


    /**
     * Supprime un mot clé de la liste des mots clés associés à cette ressource.
     *
     * @param motCle le mot clé à supprimer
     * @return true si le mot clé a été supprimé, false sinon
     */
    public boolean supprimerMotCle(String motCle) {
        boolean flag = false;

        if (estAssocieACeMotCle(motCle)) {
            for (int i = 0; i < motsCles.length; i++) {
                if (motCle.equalsIgnoreCase(motsCles[i])) {
                    motsCles[i] = "$";
                    motsCles = diminuerTableau(motsCles, 1);
                    nbrElem--;
                    flag = true;
                }
            }
        } else
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

        for (String motCle: motsCles) {
            listeMotsCles = listeMotsCles + motCle + ", ";
        }

        desc = desc + (!listeMotsCles.isEmpty() ?
            listeMotsCles.substring(0, listeMotsCles.length() - 2) : listeMotsCles);
        desc = desc + "\n";
        desc = desc + "CATEGORIE    : " + CATEGORIES[categorie] + "\n" +
            "DATE         : " + date + "\n" +
            "LOCALISATION : " + localisation;
        return desc;
    }

}