/**
 * Cette classe contient des tests PARTIELS pour tester la classe ObjetPerdu. 
 * Pour tester adequatement votre classe, vous devrez faire / ajouter vos propres tests.
 * @author melanie lord
 * @version H23
 */
public class TestsPartielsObjetPerdu {
   
   /*
   Executez la methode main, et verifiez que ce qui s'affiche a la console est identique a ce qui suit (si ce n'est 
   pas le cas ou si les tests plantent, corrigez votre code, et executez de nouveau).
   
   
   DEBUT DES TESTS

   true
   false
   false
   false
   ---------------------------------
   ID           : 1
   MOTS CLES    : 
   CATEGORIE    : bijou
   DATE         : null
   LOCALISATION : null
   ---------------------------------
   ID           : 2
   MOTS CLES    : 
   CATEGORIE    : vetement
   DATE         : null
   LOCALISATION : 
   ---------------------------------
   ID           : 3
   MOTS CLES    : porte-cles, banane
   CATEGORIE    : cle(s)
   DATE         : 17/06/2021
   LOCALISATION : casier # 102
   ---------------------------------
   ID           : 4
   MOTS CLES    : disque, usb, 30, go
   CATEGORIE    : autre
   DATE         : 03/10/2018
   LOCALISATION : premier tiroir bureau rouge
   ---------------------------------
   1
   0
   null
   null
   17/06/2021
   casier # 102
   ---------------------------------
   false
   true
   disque usb 30
   ---------------------------------
   ID           : 1
   MOTS CLES    : 
   CATEGORIE    : argent / portefeuille
   DATE         : 04/07/2022
   LOCALISATION : Armoire grise, 3e tablette
   ---------------------------------
   false
   false
   false
   true
   ---------------------------------
   5
   100
   100
   101

   FIN DES TESTS
   
   */
   

   /**
    * Tests partiels de la classe ObjetPerdu
    * @param args 
    */
   public static void main(String[] args) {
      
      System.out.println("DEBUT DES TESTS\n");
      
      ObjetPerdu o1 = new ObjetPerdu(ObjetPerdu.CAT_BIJOU, null, null);
      ObjetPerdu o2 = new ObjetPerdu(ObjetPerdu.CAT_VETEMENT, null, "");
      ObjetPerdu o3 = new ObjetPerdu(ObjetPerdu.CAT_CLE, new Date(17, 6, 2021), "casier # 102");
      ObjetPerdu o4;
      o3.ajouterMotCle("porte-cles");
      o3.ajouterMotCle("banane");
      o4 = new ObjetPerdu(ObjetPerdu.CAT_AUTRE, new Date(3, 10, 2018), "premier tiroir bureau rouge");
      o4.ajouterMotCle("disque");
      o4.ajouterMotCle("usb");
      o4.ajouterMotCle("30");
      System.out.println(o4.ajouterMotCle("go"));
      System.out.println(o4.ajouterMotCle(""));
      System.out.println(o4.ajouterMotCle(null));
      System.out.println(o4.ajouterMotCle("USB"));
      
      System.out.println("---------------------------------");
      
      System.out.println(o1);
      System.out.println("---------------------------------");
      System.out.println(o2);
      System.out.println("---------------------------------");
      System.out.println(o3);
      System.out.println("---------------------------------");
      System.out.println(o4);
      System.out.println("---------------------------------");
      
      System.out.println(o1.getId());
      System.out.println(o1.getCategorie());
      System.out.println(o1.getDate());
      System.out.println(o1.getLocalisation());
      System.out.println(o3.getDate());
      System.out.println(o3.getLocalisation());
      
      System.out.println("---------------------------------");
      
      System.out.println(o4.supprimerMotCle("toto"));
      System.out.println(o4.supprimerMotCle("GO"));
      System.out.println(o4.obtenirMotsCles());
      
      System.out.println("---------------------------------");
      
      o1.setCategorie(ObjetPerdu.CAT_ARGENT_PORTEFEUILLE);
      o1.setDate(new Date(4, 7, 2022));
      o1.setLocalisation("Armoire grise, 3e tablette");
      System.out.println(o1);
      
      System.out.println("---------------------------------");
      
      System.out.println(o1.estAssocieACeMotCle("USB"));
      System.out.println(o2.estAssocieACeMotCle("USB"));
      System.out.println(o3.estAssocieACeMotCle("USB"));
      System.out.println(o4.estAssocieACeMotCle("USB"));
      
      System.out.println("---------------------------------");

      System.out.println(ObjetPerdu.getSequenceId());      
      ObjetPerdu.setSequenceId(100);
      System.out.println(ObjetPerdu.getSequenceId());
      o4 = new ObjetPerdu(ObjetPerdu.CAT_VETEMENT, null, null);
      System.out.println(o4.getId()); 
      o4 = new ObjetPerdu(ObjetPerdu.CAT_VETEMENT, null, null);
      System.out.println(o4.getId()); 
      System.out.println("\nFIN DES TESTS\n");
   }
   
}
