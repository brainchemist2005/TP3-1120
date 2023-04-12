
public class GestionObjetsPerdus {
	final static String ERREUR_MENU = "ERREUR, vous devez entrer un choix entre 1 et 7! RECOMMENCEZ...";
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
        String choix;
        ObjetPerdu[] objetsPerdus;

        do {
            menu();
            System.out.print("Entrez votre choix : ");
            
            choix = Clavier.lireString();

            switch (choix) {
                case "1":
                    
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
                	System.out.print("AUREVOIR !");
                    break;
                    
                    
                default:
                    System.out.println(ERREUR_MENU);
            }

            } while (!choix.equals("7")); /// this DOESN'T WORK s.equals();
}
