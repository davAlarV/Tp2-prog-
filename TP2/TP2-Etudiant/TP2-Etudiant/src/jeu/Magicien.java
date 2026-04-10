package jeu;

public class Magicien {
    public static final int MAX_POINTS_VIE_PERDU = 6;
    private int pointsRecuperes;

    public Magicien(int pointsRecuperes, String nom) {
        super(20, nom);
        this.pointsRecuperes = pointsRecuperes;
    }

    @Override
    public void joue() {
        int pointDeViePerdu = (int) (Math.random() * MAX_POINTS_VIE_PERDU) - pointsRecuperes;

        if (pointDeViePerdu < 0) pointDeViePerdu = 0;
        setPointDeVie(getPointDeVie() - pointDeViePerdu);
    }

    @Override
    public String toString() {
        return "Magicien{nom= " + nom + ", pointDeVie= " + pointDeVie + ", pointsRecuperes= " + pointsRecuperes + "}";
    }

}
