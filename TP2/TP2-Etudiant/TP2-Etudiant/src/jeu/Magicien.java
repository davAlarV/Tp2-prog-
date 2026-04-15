package jeu;

public class Magicien extends AbstractPersonnage {
    public static final int MAX_POINTS_VIE_PERDU = 6;
    private int pointsRecuperes;

    public Magicien(int pointsRecuperes, String nom) {
        super(20, nom);
        assert pointsRecuperes < 10 : "pointsRecuperes trop grand";
        this.pointsRecuperes = pointsRecuperes;
    }

    @Override
    public void joue() {
        int pointDeViePerdu = (int) (Math.random() * MAX_POINTS_VIE_PERDU);

        setPointDeVie(getPointDeVie() - pointDeViePerdu);

        // 🔥 REGLA IMPORTANTE DEL TP
        if (getPointDeVie() == 1 || getPointDeVie() == 2) {
            setPointDeVie(getPointDeVie() + pointsRecuperes);
        }
    }

    @Override
    public String toString() {
        return "Magicien{nom= " + nom + ", pointDeVie= " + pointDeVie + ", pointsRecuperes= " + pointsRecuperes + "}";
    }

}
