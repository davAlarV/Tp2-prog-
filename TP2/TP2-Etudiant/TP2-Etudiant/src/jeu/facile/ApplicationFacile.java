package jeu.facile;

import jeu.Joueur;
import jeu.Pion;

public class ApplicationFacile {
    public static void main(String[] args) {
        JeuFacile jeu = new JeuFacile();

        //On règle le jeu
        Joueur premierJoueur = new Joueur("Simon");
        Joueur secondJoueur = new Joueur("Pierre");

        jeu.ajouteJoueur(premierJoueur);
        jeu.ajouteJoueur(secondJoueur);

        Pion pion = new Pion(1,"pion1");
        //Magicien magicien = new Magicien(???);

        jeu.ajoutePersonnageFacile(pion,premierJoueur);
        //jeu.ajoutePersonnageFacile(magicien,secondJoueur);

        // On lance l'exécution
        jeu.joue();

        //On affiche les stats de chaque joueurs
        pion.dessineHistorique();
        //magicien.dessineHistorique();


    }
}
