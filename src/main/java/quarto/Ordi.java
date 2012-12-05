package quarto;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ordi implements Player {

    public String name;
    protected Grid grille;

    public Ordi(String name, Grid grille) {
        this.name = name;
        this.grille = grille;
    }

    @Override
    public Piece getPieceToPlay() {
        List<Piece> pionsDisponibles = grille.getPionsDisponibles();
        pionsDisponibles.removeAll(filtrePionsGagnants(pionsDisponibles));
        if (pionsDisponibles.isEmpty()) {
            pionsDisponibles = grille.getPionsDisponibles();
        }
        Random random = new Random();
        Piece piece = pionsDisponibles.get(random.nextInt(pionsDisponibles.size()));
        grille.rendIndisponible(piece);
        return piece;
    }

    private List<Piece> filtrePionsGagnants(List<Piece> pionsDisponibles) {
        List<Piece> pionsGagnants = new ArrayList<Piece>();
        for (Piece pion : pionsDisponibles) {
            if (existPositionGagnante(grille, pion)) {
                pionsGagnants.add(pion);
            }
        }
        return pionsGagnants;
    }

    private boolean existPositionGagnante(Grid grille, Piece pion) {
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

    @Override
    public Position getPositionToPlay(Piece p) {
        List<Position> positionsJouables = positionsLibres(grille);
        boolean foundPosition = false;
        for (Position positionJouable : positionsJouables) {
            try {
                grille.ajoutPion(positionJouable, p);
            } catch (PionMemePlaceException e) {
                throw new RuntimeException("it can't be");
            }
            if (grille.estGagnee()) {
                foundPosition = true;
            }
            grille.undo();
            if (foundPosition) {
                return positionJouable;
            }
        }
        Random random = new Random();
        return positionsJouables.get(random.nextInt(positionsJouables.size()));
    }

    private List<Position> positionsLibres(Grid grille) {
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

    @Override
    public boolean declareQuarto() {
        return grille.estGagnee();
    }

    @Override
    public void win() {
        System.out.println("QUARTO");
    }
}
