package quarto;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
            if (ordiTool.existPositionGagnante(grille, pion)) {
                pionsGagnants.add(pion);
            }
        }
        return pionsGagnants;
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
