/*
package quarto;

import java.util.List;
import java.util.Random;

public class OrdiTool2 {
    private final Ordi ordi;

    public OrdiTool2(Ordi ordi) {
        this.ordi = ordi;
    }

    @Override
    public Position getPositionToPlay(Piece p) {
        List<Position> positionsJouables = ordi.getOrdiTool().positionsLibres(ordi.getGrille());
        boolean foundPosition = false;
        for (Position positionJouable : positionsJouables) {
            try {
                ordi.getGrille().ajoutPion(positionJouable, p);
            } catch (PionMemePlaceException e) {
                throw new RuntimeException("it can't be");
            }
            if (ordi.getGrille().estGagnee()) {
                foundPosition = true;
            }
            ordi.getGrille().undo();
            if (foundPosition) {
                return positionJouable;
            }
        }
        Random random = new Random();
        return positionsJouables.get(random.nextInt(positionsJouables.size()));
    }
}*/
