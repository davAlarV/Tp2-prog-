package jeu.facile;

import jeu.Joueur;
import jeu.AbstractPersonnage;

import java.util.*;

public class JeuFacile {
    private List<Joueur> joueurs;
    private Map<String, AbstractPersonnage> personnagesFacile; // la clé est le nom du joueur

    public JeuFacile() {
        //TODO JF1
    }

    public void joue() {
        //TODO JF3
    }

    /*package*/ void joueJoueurFacile(String nom) {
        //TODO JF3
        AbstractPersonnage perso = personnagesFacile.get(nom);
        if (perso != null){
            perso.joue();
        }
    }

    /*package*/ void retireVaincuFacile() {
        //TODO JF4
    }

    //Ne pas changer cette méthde
    /*package*/ boolean encoreUnVivant() {
        return personnagesFacile.size() != 0;
    }


    public void ajouteJoueur(Joueur joueur) {
        //TODO JF2
        joueurs.add(joueur);
    }


    public void ajoutePersonnageFacile(AbstractPersonnage perso, Joueur joueur) {
        //TODO JF2
        personnagesFacile.put(joueur.getNom(),perso);
    }

    //Les méthodes suivatnes servent uniquement pour les tests________________________________________


    /*package*/ Map<String, AbstractPersonnage> getPersonnagesFacile() {
        return personnagesFacile;
    }


    /*package*/  void setPersonnagesFacile(Map<String, AbstractPersonnage> personnages) {
        this.personnagesFacile = personnages;
    }
}
