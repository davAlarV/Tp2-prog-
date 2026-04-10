package jeu;

public class Pion extends AbstractPersonnage {
    public static final int MAX_ENDURENCE = 3;
    public static final int MAX_POINT_DE_VIE_PERDU = 5;
    private int endurance;

    public Pion(int endurance, String nom) {
        super(12, nom);

        assert endurance < MAX_ENDURENCE : "Endurance trop grande";
        this.endurance = endurance;
    }

    @Override
    public void joue() {
        //On détermine le nombre de points de vie à retirer
        int pointDeViePerdu = (int) (Math.random() * MAX_POINT_DE_VIE_PERDU + endurance);

        //Le pion ne peut pas regagner des points de vie (si endurance > jet aléatoire)
        if (pointDeViePerdu < 0) pointDeViePerdu = 0;

        setPointDeVie(getPointDeVie() - pointDeViePerdu);
    }
}
