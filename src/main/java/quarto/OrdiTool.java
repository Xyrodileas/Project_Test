package quarto;

import java.util.ArrayList;
import java.util.List;

public class OrdiTool {
    public OrdiTool() {
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
}