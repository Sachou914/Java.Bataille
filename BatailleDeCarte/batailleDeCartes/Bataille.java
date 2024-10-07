package org.example.batailleDeCartes;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Bataille {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    List<Carte> paquet = new ArrayList<>();

    for (int i = 0; i < Carte.couleurListe.size(); i++) {
      for (int j = 0; j < Carte.valeurListe.size(); j++) {
        paquet.add(new Carte(i, j));
      }
    }

    Joueur j1 = new Joueur();
    Joueur j2 = new Joueur();

    int manche = 0;

    while (!paquet.isEmpty()) {
      manche += 1;
      Carte carteJoueur1 = j1.tirerCarte(paquet);
      Carte carteJoueur2 = j2.tirerCarte(paquet);
      int carteValeur = carteJoueur1.Superieur(carteJoueur2);
      String gagnant;
      if (carteValeur > 0) {
        j1.ajoutScore();
        gagnant = "Joueur 1 a gagné la manche";
      } else if (carteValeur < 0) {
        j2.ajoutScore();
        gagnant = "Joueur 2 a gagné la manche";
      } else {
        gagnant = "Manche nulle";
      }
      System.out.printf(
              """
                    Manche %d
          |===========================
          |         %d - %d
          |---------------------------
          |   Joueur 1 carte : %s
          |   Joueur 2 carte : %s
          |---------------------------
          | %s
          |===========================
          %n""", manche, j1.getScore(), j2.getScore(), carteJoueur1, carteJoueur2, gagnant);
      System.out.println("Appuyer sur la touche 'entrée' pour jouer la manche suivante ! ");
      String sentence = scan.nextLine();
    }


    if (j1.getScore() > j2.getScore()) {
      System.out.println("""       
              ------------------------------
               Joueur 1 a gagné la partie !
              ------------------------------
              """);
    } else if (j1.getScore() < j2.getScore()) {
      System.out.println("""       
              ------------------------------
               Joueur 2 a gagné la partie !
              ------------------------------
              """);
    }else{
      System.out.println("""       
              ------------------------------
                         Match nul
              ------------------------------
              """);
    }

  }

}