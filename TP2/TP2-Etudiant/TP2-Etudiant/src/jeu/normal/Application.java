package jeu.normal;

import jeu.Joueur;
import jeu.Pion;
import jeu.Magicien;

public class Application {
    public static void main(String[] args) {
        Jeu jeu = new Jeu();

        //On règle le jeu
        Joueur premierJoueur = new Joueur("Simon");
        Joueur secondJoueur = new Joueur("Pierre");

        jeu.ajouteJoueur(premierJoueur);
        jeu.ajouteJoueur(secondJoueur);

        Pion premierPion = new Pion(1, "pion1");
        Magicien premierMagicien = new Magicien("magicien1", 20, 3);

        Pion secondPion = new Pion(1, "pion2");
        Magicien secondMagicien = new Magicien("magicien2", 20, 3);

        jeu.ajoutePersonnage(premierPion, premierJoueur);
        jeu.ajoutePersonnage(premierMagicien,premierJoueur);
        jeu.ajoutePersonnage(secondPion, secondJoueur);
        jeu.ajoutePersonnage(secondMagicien,secondJoueur);

        // On lance l'exécution
        jeu.joue();

        //On affiche les stats de chaque joueurs
        premierPion.dessineHistorique();
        premierMagicien.dessineHistorique();
        secondPion.dessineHistorique();
        secondMagicien.dessineHistorique();

    }
}
