package org.example.batailleDeCartes;

import java.util.List;

public class Carte {
  static final List<Character> couleurListe = List.of('♥', '♦', '♣', '♠');
  static final List<String> valeurListe =
      List.of( "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K","As");
  private final char couleur;
  private final String valeur;
  
  public Carte(int color, int value) {
    this.couleur = couleurListe.get(color);
    this.valeur = valeurListe.get(value);
  }


  public int Superieur(Carte carte) {
    return valeurListe.indexOf(this.valeur) - valeurListe.indexOf(carte.valeur);
  }
  
  @Override
  public String toString() {
    return valeur + couleur;
  }
}
