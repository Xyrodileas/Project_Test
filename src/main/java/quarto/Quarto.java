package quarto;

import java.util.List;
import java.util.Random;

public class Quarto {

    private List<Player> players;
    private Grid grid;

    public Quarto(List<Player> players, Grid grid) {
        this.players = players;
        this.grid = grid;
    }

    public void play() {
        Player currentPlayer = players.get(new Random().nextInt(2));
        Player otherPlayer = players.get(players.indexOf(currentPlayer) == 0 ? 1 : 0);

        while (!grid.isPat()) {
            Piece pionAJouer = currentPlayer.getPieceToPlay();

            Position pos;
            boolean pionPlace = false;
            do {
                try {
                    pos = otherPlayer.getPositionToPlay(pionAJouer);
                    grid.ajoutPion(pos, pionAJouer);
                    pionPlace = true;
                } catch (PionMemePlaceException e1) {
                    System.err.println("La position est déjà occupée...");
                }
            } while (!pionPlace);
            grid.display();
            if (otherPlayer.declareQuarto()) {
                if (grid.estGagnee()) {
                    otherPlayer.win();
                } else {
                    System.out.println("Vous avez perdu, la partie n'est pas gagnante");
                }
                return;
            }
            Player temp = currentPlayer;
            currentPlayer = otherPlayer;
            otherPlayer = temp;
        }
        System.out.println("Math nul !");
    }
}
