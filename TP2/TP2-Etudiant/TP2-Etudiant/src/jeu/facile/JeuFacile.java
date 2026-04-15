/**
 * TP2 - Programmation
 * Noms: David Alarcon
 *       Harold Dominguez
 *
 */

package jeu.facile;

import jeu.Joueur;
import jeu.AbstractPersonnage;

import java.util.*;

public class JeuFacile {
    private List<Joueur> joueurs;
    private Map<String, AbstractPersonnage> personnagesFacile; // la clé est le nom du joueur

    public JeuFacile() {
        //TODO JF1
        joueurs = new ArrayList<>();
        personnagesFacile = new HashMap<>();
    }

    public void joue() {
        //TODO JF3
        int tour = 0;
        Collections.sort(joueurs);
        while (encoreUnVivant()) {

            System.out.println("On joue le tour " + tour);

            for (Joueur joueur : joueurs) {
                System.out.println("On joue les personnages du joueur " + joueur.getNom());
                joueJoueurFacile(joueur.getNom());
            }

            retireVaincuFacile();
            tour++;
        }
    }

    /*package*/ void joueJoueurFacile(String nom) {
        //TODO JF3
        AbstractPersonnage perso = personnagesFacile.get(nom);
        if (perso != null) {
            perso.joue();
        }
    }

    /*package*/ void retireVaincuFacile() {
        //TODO JF4
        Iterator<Map.Entry<String, AbstractPersonnage>> it =
                personnagesFacile.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry<String, AbstractPersonnage> entry = it.next();

            AbstractPersonnage perso = entry.getValue();
            String nomJoueur = entry.getKey();

            if (perso.getPointDeVie() <= 0) {

                System.out.println("Le personnage " + perso.getNom()
                        + " appartenant au joueur " + nomJoueur + " a été retiré");

                it.remove();

                joueurs.removeIf(j -> j.getNom().equals(nomJoueur));

                System.out.println("Le joueur " + nomJoueur + " n'a plus de personnages");
            }
        }
    }

    //Ne pas changer cette méthde
    /*package*/ boolean encoreUnVivant() {
        return personnagesFacile.size() != 0;
    }


    public void ajouteJoueur(Joueur joueur) {
        //TODO JF2
        if (joueur != null) {
            joueurs.add(joueur);
        }
    }


    public void ajoutePersonnageFacile(AbstractPersonnage perso, Joueur joueur) {
        //TODO JF2
        assert perso != null : "Personnage null";
        assert joueur != null : "Joueur null";
        assert joueurs.contains(joueur) : "Joueur pas dans la liste";
        personnagesFacile.put(joueur.getNom(), perso);
    }

    //Les méthodes suivatnes servent uniquement pour les tests________________________________________


    /*package*/ Map<String, AbstractPersonnage> getPersonnagesFacile() {
        return personnagesFacile;
    }


    /*package*/  void setPersonnagesFacile(Map<String, AbstractPersonnage> personnages) {
        this.personnagesFacile = personnages;
    }
}
