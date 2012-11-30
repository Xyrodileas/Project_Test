package quarto;

public class Piece {

    public final Couleur couleur;
    public final Forme forme;
    public final Taille taille;
    public final Coeur coeur;


    public Piece(Couleur couleur, Forme forme, Taille taille, Coeur coeur) {
        this.couleur = couleur;
        this.forme = forme;
        this.taille = taille;
        this.coeur = coeur;
    }

    @Override
    public String toString() {
        return "Piece{"+couleur +
                ", " + forme +
                ", " + taille +
                ", " + coeur +
                '}';
    }

}
