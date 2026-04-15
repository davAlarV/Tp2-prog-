package jeu.normal;

import jeu.Joueur;
import jeu.AbstractPersonnage;

import java.util.*;

public class Jeu {
    private List<Joueur> joueurs;
    private Map<String, Collection<AbstractPersonnage>> personnages; // la clé est le nom du joueur

    public Jeu() {
        //TODO J1
        joueurs = new ArrayList<>();
        personnages = new HashMap<>();
    }


    public void joue() {
        //TODO J3
        int tour = 0;
        Collections.sort(joueurs);
        while (encoreUnVivant()) {
            System.out.println("\n" + "On joue le tour " + tour );
            for (Joueur joueur : joueurs) {
                System.out.println("On joue les personnages du joueur" + joueur.getNom());
                joueJoueur(joueur.getNom());
            }
            retireVaincu();
            tour++;
        }
    }


    /*package*/ void joueJoueur(String nomJoueur) {
        //TODO J3
        Collection<AbstractPersonnage> persos = personnages.get(nomJoueur);
        if (persos != null) {
            for (AbstractPersonnage perso : persos) {
                perso.joue();
            }
        }

    }


    /*package*/ void retireVaincu() {
        //TODO J4
        Iterator<Map.Entry<String, Collection<AbstractPersonnage>>> it =
                personnages.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry<String, Collection<AbstractPersonnage>> entry = it.next();
            String nomJoueur = entry.getKey();
            Collection<AbstractPersonnage> persos = entry.getValue();

            Iterator<AbstractPersonnage> itPerso = persos.iterator();
            while (itPerso.hasNext()) {
                AbstractPersonnage perso = itPerso.next();
                if (perso.getPointDeVie() <= 0) {
                    System.out.println("Le personnage " + perso.getNom()
                            + " appartenant au joueur " + nomJoueur + " a été retiré");
                    itPerso.remove();
                }
            }
            if (persos.isEmpty()) {
                it.remove();
                joueurs.removeIf(j -> j.getNom().equals(nomJoueur));
                System.out.println("Le joueur " + nomJoueur + " n'a plus de personnages");
            }
        }
    }

    //Ne pas changer cette méthde
    /*package*/ boolean encoreUnVivant() {
        return joueurs.size() != 0;
    }


    public void ajouteJoueur(Joueur joueur) {
        //TODO J2
        assert joueur != null : "Joueur null";
        joueurs.add(joueur);
    }

    public void ajoutePersonnage(AbstractPersonnage perso, Joueur joueur) {
        //TODO J2
        assert perso != null : "Personnage null";
        assert joueur != null : "Joueur null";
        assert joueurs.contains(joueur) : "Joueur pas dans la liste";

        personnages.putIfAbsent(joueur.getNom(), new HashSet<>());
        personnages.get(joueur.getNom()).add(perso);
    }


    //Les méthodes suivatnes servent uniquement pour les tests________________________________________

    /*package*/ Map<String, Collection<AbstractPersonnage>> getPersonnages() {
        return personnages;
    }


    /*package*/  void setPersonnages(Map<String, Collection<AbstractPersonnage>> personnages) {
        this.personnages = personnages;
    }

}
