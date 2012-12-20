package quarto;

import java.util.List;

public class Ordi implements Player {

    public String name;
    protected static Grid grille;
    private final OrdiTool ordiTool = new OrdiTool();



    public Ordi(String name, Grid grille) {
        this.name = name;
        this.grille = grille;
    }

    @Override
    public Piece getPieceToPlay() {
        return ordiTool.getPieceToPlay();
    }

    private boolean existPositionGagnante(Grid grille, Piece pion) {   // TODO
        return OrdiTool.existPositionGagnante(grille, pion);
    }

    @Override
    public Position getPositionToPlay(Piece p) {
        return OrdiTool.getPositionToPlay(p);
    }

    private List<Position> positionsLibres(Grid grille) {
        return OrdiTool.positionsLibres(grille);
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
