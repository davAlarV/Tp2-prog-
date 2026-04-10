package jeu.normal;

import jeu.Joueur;
import jeu.AbstractPersonnage;

import java.util.*;

public class Jeu {
    private List<Joueur> joueurs;
    private Map<String, Collection<AbstractPersonnage>> personnages; // la clé est le nom du joueur

    public Jeu() {
        //TODO J1
    }


    public void joue() {
        //TODO J3
    }


    /*package*/ void joueJoueur(String nomJoueur) {
        //TODO J3
    }


    /*package*/ void retireVaincu() {
        //TODO J4
    }

    //Ne pas changer cette méthde
    /*package*/ boolean encoreUnVivant() {
        return joueurs.size() != 0;
    }


    public void ajouteJoueur(Joueur joueur) {
        //TODO J2

    }

    public void ajoutePersonnage(AbstractPersonnage perso, Joueur joueur) {
        //TODO J2
    }


    //Les méthodes suivatnes servent uniquement pour les tests________________________________________

    /*package*/ Map<String, Collection<AbstractPersonnage>> getPersonnages() {
        return personnages;
    }


    /*package*/  void setPersonnages(Map<String, Collection<AbstractPersonnage>> personnages) {
        this.personnages = personnages;
    }

}
