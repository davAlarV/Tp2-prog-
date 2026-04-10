package jeu;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractPersonnage {
    private final static int MAX_POINTS_VIE = 20;
    private final static int LONGUEUR_HISTORIQUE = 30;
    protected int pointDeVie;
    protected String nom;
    private List<Integer> historiquePointDeVie;

    public AbstractPersonnage(int pointDeVie, String nom) {
        assert pointDeVie < MAX_POINTS_VIE : "Points de vie trop grand";
        assert nom != null : "Nom null";
        this.nom = nom;
        this.pointDeVie = pointDeVie;
        historiquePointDeVie = new ArrayList<>(LONGUEUR_HISTORIQUE);
    }

    public abstract void joue();

    public void dessineHistorique() {
        // Création du tableau 2D
        int[][] dessin = new int[MAX_POINTS_VIE][];
        for (int i = 0; i < MAX_POINTS_VIE; i++) {
            dessin[i] = new int[LONGUEUR_HISTORIQUE];
        }

        // On rempli le tableau 2D avec l'historique
        int i = 0;
        for (Integer entier : historiquePointDeVie) {
            dessin[MAX_POINTS_VIE - entier][i++] = entier;
        }

        // On fait afficher
        dessineBonus(dessin);
        dessine(dessin);
    }

    private void dessine(int[][] dessin) {
        System.out.println("Voici l'historique de " + nom);

        System.out.println("__________________________");
        //TODO AP1
        for (int ligne = 0; ligne < dessin.length; ligne++) {
            for (int col = 0; col < dessin[ligne].length; col++) {
                if (dessin[ligne][col] != 0) {
                    dessineNombre(dessin[ligne][col]);
                } else {
                    System.out.print("    ");
                }
            }
            System.out.println();
        }
        System.out.println("__________________________");

    }

    private void dessineBonus(int[][] dessin) {

        int[] maxPositions = new int[dessin[0].length];
        System.out.println("Voici l'historique de " + nom);

        System.out.println("__________________________");
        //TODO AP1b
        for (int col = 0; col < dessin[0].length; col++) {
            int max = 0;
            for (int ligne = 0; ligne < dessin.length; ligne++) {
                if (dessin[ligne][col] > max) {
                    max = dessin[ligne][col];
                }
            }
            maxPositions[col] = max;
        }

        for (int col = 0; col < maxPositions.length; col++) {
            if (maxPositions[col] != 0) {
                dessineNombre(maxPositions[col]);
            } else {
                System.out.print("    ");
            }
        }
        System.out.println();

        System.out.println("__________________________");

    }

    private void dessineNombre(int i1) {
        String remplisseur = i1 / 10 == 0 ? " " : "";
        System.out.print(" " + i1 + remplisseur);
    }

    public int getPointDeVie() {
        return pointDeVie;
    }

    public void setPointDeVie(int pointDeVie) {
        //On garde l'ancienne valeur dans l'historique en respectant la dimension maximale de l'historique
        if (historiquePointDeVie.size() >= LONGUEUR_HISTORIQUE) {
            historiquePointDeVie.remove(0);
        }
        historiquePointDeVie.add(this.pointDeVie);

        //On informe le joueur de la modification
        System.out.println(nom + " a maintenent " + pointDeVie + " points de vie.");

        this.pointDeVie = pointDeVie;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    /*pacakge*/ List<Integer> getHistoriquePointDeVie() {
        return historiquePointDeVie;
    }

    /*pacakge*/ void setHistoriquePointDeVie(List<Integer> historiquePointDeVie) {
        this.historiquePointDeVie = historiquePointDeVie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractPersonnage that = (AbstractPersonnage) o;

        return nom.equals(that.nom);
    }

    @Override
    public int hashCode() {
        return nom.hashCode();
    }


}
