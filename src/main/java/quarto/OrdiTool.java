package quarto;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static quarto.Ordi.*;

public class OrdiTool {


    public OrdiTool() {

    }

    List<Piece> filtrePionsGagnants(List<Piece> pionsDisponibles) {
        List<Piece> pionsGagnants = new ArrayList<Piece>();
        for (Piece pion : pionsDisponibles) {
            if (existPositionGagnante(Ordi.grille, pion)) {
                pionsGagnants.add(pion);
            }
        }
        return pionsGagnants;
    }


    static boolean existPositionGagnante(Grid grille, Piece pion) {   // TODO
        for (int i = 0; i < 4; i++) {
            Line rangee = grille.extractLine(i);
            rangee.add(pion);
            if (rangee.isWon()) {
                return true;
            }
        }
        for (int i = 0; i < 4; i++) {
            Line rangee = grille.extractColumn(i);
            rangee.add(pion);
            if (rangee.isWon()) {
                return true;
            }
        }
        Line rangee = grille.extractFirstDiagonal();
        rangee.add(pion);
        if (rangee.isWon()) {
            return true;
        }
        rangee = grille.extractSecondDiagonal();
        rangee.add(pion);
        return rangee.isWon();
    }

    static List<Position> positionsLibres(Grid grille) {
        List<Position> positions = new ArrayList<Position>();
        for (int i = 0; i < Grid.TAILLE; ++i) {
            for (int j = 0; j < Grid.TAILLE; ++j) {
                Position pos = new Position(i, j);
                if (grille.isFreePosition(pos)) {
                    positions.add(pos);
                }
            }
        }
        return positions;
    }


    public static Position getPositionToPlay(Piece p) {
        List<Position> positionsJouables = positionsLibres(Ordi.grille);
        boolean foundPosition = false;
        for (Position positionJouable : positionsJouables) {
            try {
                Ordi.grille.ajoutPion(positionJouable, p);
            } catch (PionMemePlaceException e) {
                throw new RuntimeException("it can't be");
            }
            if (grille.estGagnee()) {
                foundPosition = true;
            }
            Ordi.grille.undo();
            if (foundPosition) {
                return positionJouable;
            }
        }
        Random random = new Random();
        return positionsJouables.get(0);
    }


    public Piece getPieceToPlay() {
        List<Piece> pionsDisponibles = Ordi.grille.getPionsDisponibles();
        pionsDisponibles.removeAll(filtrePionsGagnants(pionsDisponibles));
        if (pionsDisponibles.isEmpty()) {
            pionsDisponibles = Ordi.grille.getPionsDisponibles();
        }
        Random random = new Random();
        Piece piece = pionsDisponibles.get(0);
        Ordi.grille.rendIndisponible(piece);
        return piece;
    }


}