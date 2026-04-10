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
        while (encoreUnVivant()){
            List<String> noms = new ArrayList<>(personnagesFacile.keySet());
            for (String nom : noms) {
                joueJoueurFacile(nom);
            }
            retireVaincuFacile();
        }
    }

    /*package*/ void joueJoueurFacile(String nom) {
        //TODO JF3
    }

    /*package*/ void retireVaincuFacile() {
        //TODO JF4
        Iterator<Map.Entry<String, AbstractPersonnage>> it =
                personnagesFacile.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, AbstractPersonnage> entry = it.next();
            if (entry.getValue().getPointDeVie() <= 0){
                joueurs.removeIf(j -> j.getNom().equals(entry.getKey()) );
                it.remove();
            }
        }
    }

    //Ne pas changer cette méthde
    /*package*/ boolean encoreUnVivant() {
        return personnagesFacile.size() != 0;
    }


    public void ajouteJoueur(Joueur joueur) {
        //TODO JF2
    }


    public void ajoutePersonnageFacile(AbstractPersonnage perso, Joueur joueur) {
        //TODO JF2
    }


    //Les méthodes suivatnes servent uniquement pour les tests________________________________________


    /*package*/ Map<String, AbstractPersonnage> getPersonnagesFacile() {
        return personnagesFacile;
    }


    /*package*/  void setPersonnagesFacile(Map<String, AbstractPersonnage> personnages) {
        this.personnagesFacile = personnages;
    }
}
