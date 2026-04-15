package jeu;

public class Magicien extends AbstractPersonnage {
    public static final int MAX_POINTS_VIE_PERDU = 6;
    private int pointsRecuperes;

    public Magicien(String nom, int pointsVieInitial, int pointsRecuperes) {
        super(20, nom);
        assert pointsRecuperes < 10 : "pointsRecuperes trop grand";
        this.pointsRecuperes = pointsRecuperes;
    }

    @Override
    public void joue() {
        int pointDeViePerdu = (int) (Math.random() * MAX_POINTS_VIE_PERDU) + 1;

        int nouvelleVie = getPointDeVie() - pointDeViePerdu;

        if (nouvelleVie == 1 || nouvelleVie == 2) {
            nouvelleVie += pointsRecuperes;
        }

        setPointDeVie(nouvelleVie);
    }

    @Override
    public String toString() {
        return super.toString() + " (Magicien, pointsRecuperes=" + pointsRecuperes + ")";
    }

}
