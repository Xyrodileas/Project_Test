package quarto;

import java.util.ArrayList;
import java.util.List;

public class PionBox {

    private List<Piece> pionsDisponibles;

    public PionBox(List<Piece> pionsDisponibles) {
        this.pionsDisponibles = new ArrayList<Piece>(pionsDisponibles);
    }

    public static List<Piece> piecesFactory() {
        List<Piece> lesPieces = new ArrayList<Piece>();
        for (Couleur couleur : Couleur.values()) {
            for (Forme forme : Forme.values()) {
                for (Taille taille : Taille.values()) {
                    for (Coeur coeur : Coeur.values()) {
                        lesPieces.add(new Piece(couleur, forme, taille, coeur));
                    }
                }
            }
        }
        return lesPieces;
    }

    public List<Piece> getPionsDisponibles() {
        return new ArrayList<Piece>(pionsDisponibles);
    }

    public boolean isEmpty() {
        return pionsDisponibles.isEmpty();
    }

    public void remove(Piece piece) {
        pionsDisponibles.remove(piece);
    }
}
