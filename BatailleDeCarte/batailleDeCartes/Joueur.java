package org.example.batailleDeCartes;

import java.util.ArrayList;
import java.util.List;

public class Joueur {
  private List<Carte> deck;

  public int getScore() {
    return score;
  }

  private int score;

  public Joueur() {
    this.deck = new ArrayList<>();
    this.score = 0;
  }

  public void ajoutCarte(Carte carte) {
    deck.add(carte);
  }

  public Carte tirerCarte(List<Carte> deck) {
    int i = (int) (Math.random() * deck.size());
    Carte carte = deck.get(i);
    ajoutCarte(carte);
    deck.remove(carte);
    return carte;
  }

  public void ajoutScore() {
    this.score += 1;
  }
}