
import java.io.*;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * Classe utilitaire contenant des methodes a utiliser dans le cadre du TP3 INF1120 H23. 
 * 
 * @author Melanie Lord
 * @version Hiver 2023
 */
public class TP3Utils {
   
   //--------------------------
   // CONSTANTES
   //--------------------------
   
   //Le nom du fichier qui contient les objets perdus sauvegardes.
   public final static String NOM_FIC = "objetsPerdus.txt";
   
   private final static Comparator COMP_ID = new Comparator() {
      @Override
      public int compare(Object o1, Object o2) {
         int rep = 0;
         if (((ObjetPerdu)o1).getId() < ((ObjetPerdu)o2).getId())
            rep = -1;
         else if (((ObjetPerdu)o1).getId() > ((ObjetPerdu)o2).getId()) 
            rep = 1;
         return rep;
      }
   };
 
   //comparateur pour trier les objets perdus par date de consignation
   private final static Comparator COMP_DATE = new Comparator() {
      @Override
      public int compare(Object o1, Object o2) {
         int rep = 1;
         if (((ObjetPerdu)o1).getDate().estPlusPetite(((ObjetPerdu)o2).getDate()))
            rep = -1;
         else if (((ObjetPerdu)o1).getDate().estEgale(((ObjetPerdu)o2).getDate())) 
            rep = 0;
         return rep;
      }
   };
   
   //--------------------------
   // METHODES PUBLIQUES
   //--------------------------

   /**
    * Valide un nombre entier entre min et max inclusivement.
    * 
    * NOTES : 
    * - Cette methode ne plante pas lors de la saisie d'une valeur non entiere.
    * - La saisie de ENTREE est consideree comme invalide.
    * 
    * @param msgSol le message de sollicitation a afficher
    * @param msgErr le message d'erreur a afficher lorsque la valeur saisie
    *               est invalide
    * @param min borne minimum incluse pour une valeur valide
    * @param max borne maximum incluse pour une valeur valide
    * @return un nombre entier entre min et max inclusivement
    */
   public static int validerEntier (String msgSol, String msgErr, int min, int max) {
      int entier = min - 1;
      String sEntier;
                                                                                                              
      do {
         try {
            System.out.print(msgSol);
            sEntier = Clavier.lireString();
            entier = Integer.parseInt(sEntier);

            if (entier < min || entier > max) {
               System.out.println(msgErr);
            }
         } catch (NumberFormatException e) {
            System.out.println(msgErr);
         }
      } while (entier < min || entier > max);

      return entier;

   }
   
   /**
    * Valide un nombre entier strictement positif (> 0).
    * 
    * NOTES :
    * - Cette methode ne plante pas lors de la saisie d'une valeur non entiere.
    * - La saisie de ENTREE est consideree comme invalide.
    * 
    * @param msgSol le message de sollicitation a afficher
    * @param msgErr le message d'erreur a afficher lorsque la valeur saisie
    *               est invalide
    * @return un nombre entier strictement positif
    */
   public static int validerTypeEntierStrictPositif(String msgSol, String msgErr) {
      int entier = 0;
      String sEntier;
      boolean typeOK = false;
                                                                                                              
      do {
         try {
            System.out.print(msgSol);
            sEntier = Clavier.lireString();
            entier = Integer.parseInt(sEntier);
            typeOK = entier > 0;
            
            if (!typeOK) {
               System.out.println(msgErr);
            }
         } catch (NumberFormatException e) {
            System.out.println(msgErr);
         }
      } while (!typeOK);

      return entier;
   }
   
   /**
    * Valide un caractere entre carMin et carMax inclusivement.
    * 
    * NOTES : 
    * - La validation ne tient pas compte de la casse.
    * - La saisie de ENTREE est consideree comme invalide.
    * 
    * @param msgSol le message de sollicitation a afficher
    * @param msgErr le message d'erreur a afficher lorsque la valeur saisie
    *               est invalide
    * @param carMin borne minimum incluse pour une valeur valide
    * @param carMax borne maximum incluse pour une valeur valide
    * @return le caractere saisi et valide entre carMin et carMax inclusivement
    */
   public static char validerCaractere(String msgSol, String msgErr, char carMin, char carMax) {
      String choix;
      String choixOriginal;
      carMin = Character.toUpperCase(carMin);
      carMax = Character.toUpperCase(carMax);
      
      System.out.print(msgSol);
      choixOriginal = Clavier.lireString();
      choix = choixOriginal.toUpperCase();
      
      while (!(choix.length() == 1 && choix.charAt(0) >= carMin 
              && choix.charAt(0) <= carMax)) {
         System.out.println(msgErr);
         System.out.print(msgSol);
         choix = Clavier.lireString();
      }
      return choix.charAt(0);
   }
   
   /**
    * Valide la longueur de la chaine de caracteres saisie entre lngMin et lngMax inclusivement.
    * 
    * @param msgSol le message de sollicitation a afficher
    * @param msgErr le message d'erreur a afficher lorsque la chaine saisie
    *               est de longueur invalide
    * @param lngMin borne minimum incluse pour une longueur de chaine valide
    * @param lngMax borne maximum incluse pour une longueur de chaine valide
    * @return la chaine saisie dont la longueur est entre lngMin et lngMax inclus
    */
   public static String validerLngChaine(String msgSol, String msgErr, int lngMin, int lngMax) {
      String chaine; 
      System.out.print(msgSol);
      chaine = Clavier.lireString();
      
      while (chaine.length() < lngMin || chaine.length() > lngMax) {
         System.out.println(msgErr);
         System.out.print(msgSol);
         chaine = Clavier.lireString();
      }
      return chaine;
   }
   
   /**
    * Valide que la reponse donnee par l'utilisateur est soit repValide1, soit 
    * repValide2 (peu importe la casse).
    * 
    * @param msgSol le message de sollicitation a afficher
    * @param msgErr le message d'erreur a afficher lorsque la reponse saisie
    *               est invalide
    * @param repValide1 une des deux reponses qui est valide
    * @param repValide2 l'autre reponse valide
    * @return une reponse valide 
    *         (soit repValide1, soit repValide2, peu importe la casse)
    */
   public static String validerRepDeuxChoix (String msgSol, String msgErr, 
           String repValide1, String repValide2) {
      String rep;
      
      System.out.print(msgSol);
      rep = Clavier.lireString();
      
      while (!rep.equalsIgnoreCase(repValide1)
              && !rep.equalsIgnoreCase(repValide2)) {
         System.out.println(msgErr);
         System.out.print(msgSol);
         rep = Clavier.lireString();
      }
      return rep;
   }
   
   /**
    * Retourne un nouveau tableau contenant tous les objets perdus non null contenus 
    * dans objetsPerdus, et trie en ordre croissant sur l'id de ces objets. 
    * Par exemple, si le tableau passe en parametre ne contient que 3 objets perdus 
    * non null, le tableau retourne par cette methode sera de longueur 3. 
    * 
    * NOTEZ QUE CETTE METHODE NE MODIFIE PAS LE TABLEAU objetsPerdus PASSE
    * EN PARAMETRE.
    * 
    * ATTENTION : si le tableau donne en parametre est null, cette methode leve une 
    * NullPoiterException.
    * 
    * @param objetsPerdus le tableau d'objets perdus a trier par id.
    * @return un nouveau tableau contenant tous les objets perdus non null contenus 
    * dans objetsPerdus, trie en ordre croissant sur l'id des objets.
    * @throws NullPointerException si le tableau donne en parametre est null.
    */
   public static ObjetPerdu[] ordonnerObjetsPerdusParId(ObjetPerdu[] objetsPerdus) {
      ObjetPerdu[] tab;
      
      //Enlever tous les null dans objetsPerdus et le trier
      tab = supprimerLesNull(objetsPerdus);
      Arrays.sort(tab, COMP_ID); //trier par id
      return tab;
   }
   
   
   /**
    * Retourne un nouveau tableau contenant tous les objets perdus non null contenus 
    * dans objetsPerdus, et trie en ordre croissant sur la date de consignation de ces objets. 
    * Par exemple, si le tableau passe en parametre ne contient que 3 objets perdus 
    * non null, le tableau retourne par cette methode sera de longueur 3. 
    * 
    * NOTEZ QUE CETTE METHODE NE MODIFIE PAS LE TABLEAU objetsPerdus PASSE
    * EN PARAMETRE.
    * 
    * ATTENTION : si le tableau donne en parametre est null, cette methode leve une 
    * NullPoiterException.
    * 
    * @param objetsPerdus le tableau d'objets perdus a trier par date.
    * @return un nouveau tableau contenant tous les objets perdus non null contenus 
    * dans objetsPerdus, trie en ordre croissant sur la date de consignation des objets.
    * @throws NullPointerException si le tableau donne en parametre est null.
    */
   public static ObjetPerdu[] ordonnerObjetsPerdusParDate(ObjetPerdu[] objetsPerdus) {
      ObjetPerdu[] tab;
      
      //Enlever tous les null dans objetsPerdus et le trier
      tab = supprimerLesNull(objetsPerdus);
      Arrays.sort(tab, COMP_DATE); //trier par date
      return tab;
   }
   
   /**
    * Sauvegarde tous les objets perdus (non null) contenus dans le tableau objetsPerdus dans
    * le fichier texte NOM_FIC.
    * @param objetsPerdus le tableau contenant les objets perdus a sauvegarder dans le fichier
    *        texte NOM_FIC.
    */
   public static void sauvegarder(ObjetPerdu[] objetsPerdus) {
      PrintWriter out = null;
      
      try {
         out = new PrintWriter(new FileWriter(NOM_FIC));

         if (objetsPerdus != null) {

            for (ObjetPerdu obj : objetsPerdus) {
               if (obj != null) {
                  out.println(obj.obtenirMotsCles());
                  out.println(obj.getCategorie());
                  out.println(obj.getDate());
                  out.println(obj.getLocalisation());
               }
            }
         }
         
      } catch (IOException e) {
         System.err.println("\nERREUR pendant la sauvegarde des donnees.\n");
      }   
      
      if (out != null)    
         out.close(); 
   }
   
   /**
    * Recupere tous les objets perdus sauvegardes dans le fichier texte NOM_FIC, et 
    * retourne un tableau de longueur minimale contenant ces objets.
    * Si le ficher NOM_FIC est vide ou n'existe pas, la methode retourne un tableau 
    * de longueur 0.
    * @return un tableau de longueur minimale contenant les objets perdus sauvegardes
    *         dans le fichier NOM_FIC. 
    */
   public static ObjetPerdu[] recupererDonnees() {
      BufferedReader in;
      ArrayList<ObjetPerdu> liste = new ArrayList<>();
      ObjetPerdu obj;
      File fic = new File(NOM_FIC);
      String sMotsCles;
      String[] motsCles;
      int categorie;
      String sDate;
      Date date;
      String localisation;
      
      try {
      
         if (fic.exists()) {
            in = new BufferedReader(new FileReader(NOM_FIC));

            while(in.ready()) {
               sMotsCles = in.readLine().trim();
               categorie = Integer.parseInt(in.readLine().trim());
               sDate = in.readLine().trim();
               localisation = in.readLine().trim();
               motsCles = sMotsCles.split("\\s+");
               date = convertirEnDate(sDate);

               obj = new ObjetPerdu(categorie, date, localisation);
               for (String mc : motsCles) {
                  obj.ajouterMotCle(mc);
               }
               
               liste.add(obj);
            }
         }
         
      } catch (IOException e) {
         System.err.println("\nERREUR pendant la lecture des donnees !\n");
         liste = new ArrayList<>();
      }
      
      return liste.toArray(new ObjetPerdu[0]);
   }
   
   // -----------------------
   // METHODES PRIVEES 
   // -----------------------
   
   /**
    * Retourne un NOUVEAU tableau contenant les objets perdus non null qui sont dans
    * objetsPerdus. Le tableau retourne est de longueur minimale. Par exemple, si 
    * objetsPerdus contient 3 objets perdus non null, le tableau retourne sera de 
    * longueur 3.
    * 
    * CETTE METHODE NE MODIFIE PAS LE TABLEAU objetsPerdus PASSE EN PARAMETRE.
    * 
    * @param objetsPerdus le tableau dont on veut retirer les null.
    *        ANTECEDENT : est non null
    *        
    * @return un NOUVEAU tableau contenant les objets perdus non null qui sont dans
    *         objetsPerdus.
    */
   private static ObjetPerdu[] supprimerLesNull(ObjetPerdu[] objetsPerdus) {
      ArrayList<ObjetPerdu> liste = new ArrayList<>();
      
      //Enlever tous les null dans objetsPerdus
      for (ObjetPerdu o : objetsPerdus) {
         if (o != null)
            liste.add(o);
      }
      return liste.toArray(new ObjetPerdu[0]);
   }
   
   /**
    * Cette methode convertit sDate (date en format String) en objet de type Date.
    * @param sDate la date au format "jj/mm/aaaa" a transformer en objet de type Date.
    *        ANTECEDENT : ne doit pas etre null et doit etre du bon format
    * @return un objet Date correspondant a la date sDate (String) donnee en parametre.
    */
   private static Date convertirEnDate(String sDate) {
      String[] tabDate = sDate.split("/");
      Date date = new Date(Integer.parseInt(tabDate[0]), Integer.parseInt(tabDate[1]), 
         Integer.parseInt(tabDate[2]));
      
      return date;
   }
   
}
