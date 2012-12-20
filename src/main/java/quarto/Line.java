package quarto;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private List<Piece> pieces;

    public Line() {
        pieces = new ArrayList<Piece>();
    }

    public void clear() {
        pieces.clear();
    }

    public void add(Piece piece) {
        pieces.add(piece);
    }

    public boolean isWon() {
        if (pieces.size() < 4) return false;
        return (colorWin(pieces) || formWin(pieces) || heartWin(pieces) || sizeWin(pieces) );
    }

    private boolean colorWin(List<Piece> pieces) {
        boolean fonce = true;
        boolean clair = true;
        for (Piece piece : pieces) {
            fonce = fonce && (piece.couleur == Couleur.FONCEE);
            clair = clair && (piece.couleur == Couleur.CLAIRE);
        }
        return fonce || clair;
    }

    private boolean formWin(List<Piece> pieces) {
        boolean rond = true;
        boolean carre = true;
        for (Piece piece : pieces) {
            rond = rond && (piece.forme == Forme.RONDE);
            carre = carre && (piece.forme  == Forme.CARREE);
        }
        return rond || carre;
    }
    private boolean heartWin(List<Piece> pieces) {
        boolean plein = true;
        boolean creux = true;
        for (Piece piece : pieces) {
            plein = plein && (piece.coeur == Coeur.PLEINE);
            creux = creux && (piece.coeur == Coeur.CREUSE);
        }
        return plein || creux;
    }

    private boolean sizeWin(List<Piece> pieces) {
        boolean court = true;
        boolean longue = true;
        for (Piece piece : pieces) {
            court = court && (piece.taille == Taille.BASSE);
            longue = longue && (piece.taille == Taille.HAUTE);
        }
        return court || longue;
    }





}
