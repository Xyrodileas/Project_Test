package quarto;

import java.util.List;
import java.util.Stack;

public class Grid {

    private Piece[][] tabPion;
    private Stack<Position> hist;
    public static final int TAILLE = 4;
    private PionBox box;

    public Grid(PionBox box) {
        this.box = box;
        tabPion = new Piece[TAILLE][TAILLE];
        hist = new Stack<Position>();
    }

    public Piece[][] getTabPion() { //TODO
        return tabPion;
    }

    public List<Piece> getPionsDisponibles() { //DONE
        return box.getPionsDisponibles();
    }

    public void ajoutPion(Position pos, Piece pionAJouer) throws PionMemePlaceException {   //TODO
        int x = pos.getX();
        int y = pos.getY();
        if (tabPion[x][y] != null) {
            throw new PionMemePlaceException();
        }

        this.tabPion[x][y] = pionAJouer;
        Position p = new Position(x, y);
        hist.push(p);
    }

    public void undo() {
        Position p = hist.pop();
        tabPion[p.getX()][p.getY()] = null;
    }

    public boolean estGagnee() {
        Line rangee = new Line();
        // Lignes
        for (int i = 0; i < TAILLE; ++i) {
            rangee.clear();
            for (int j = 0; j < TAILLE; ++j) {
                if (tabPion[i][j] != null) {
                    rangee.add(tabPion[i][j]);
                }
            }
            if (rangee.isWon()) {
                return true;
            }
        }
        // Colonnes
        for (int i = 0; i < TAILLE; ++i) {
            rangee.clear();
            for (int j = 0; j < TAILLE; ++j) {
                if (tabPion[j][i] != null) {
                    rangee.add(tabPion[j][i]);
                }
            }
            if (rangee.isWon()) {
                return true;
            }
        }
        // diag gauche
        rangee.clear();
        for (int i = 0; i < TAILLE; i++) {
            if (tabPion[i][i] != null) {
                rangee.add(tabPion[i][i]);
            }
            if (rangee.isWon()) {
                return true;
            }
        }
        // diag droite
        rangee.clear();
        for (int i = 0; i < TAILLE; i++) {
            if (tabPion[i][TAILLE - i - 1] != null) {
                rangee.add(tabPion[i][TAILLE - i - 1]);
            }
            if (rangee.isWon()) {
                return true;
            }
        }
        return false;
    }

    public boolean isPat() {
        return (box.isEmpty() && !estGagnee());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < TAILLE; ++i) {
            for (int j = 0; j < TAILLE; ++j) {
                if (tabPion[i][j] == null) {
                    sb.append("0 ");
                } else {
                    sb.append("1 ");
                }
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    public void rendIndisponible(Piece piece) {
        box.remove(piece);
    }

    public Line extractLine(int index) {
        Line line = new Line();
        for (int i = 0; i < TAILLE; i++) {
            if (tabPion[index][i] != null) {
                line.add(tabPion[index][i]);
            }
        }
        return line;
    }

    public Line extractColumn(int index) {
        Line line = new Line();
        for (int i = 0; i < TAILLE; i++) {
            if (tabPion[i][index] != null) {
                line.add(tabPion[i][index]);
            }
        }
        return line;
    }

    public Line extractSecondDiagonal() {
        Line line = new Line();
        for (int i = 0; i < TAILLE; i++) {
            if (tabPion[i][TAILLE - 1 - i] != null) {
                line.add(tabPion[i][TAILLE - 1 - i]);
            }
        }
        return line;
    }

    public Line extractFirstDiagonal() {
        Line line = new Line();
        for (int i = 0; i < TAILLE; i++) {
            if (tabPion[i][i] != null) {
                line.add(tabPion[i][i]);
            }
        }
        return line;
    }

    public void display() {
        for (int i = 0; i < TAILLE; i++) {
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < TAILLE; j++) {
                if (tabPion[i][j] == null) {
                    builder.append("                                     | ");
                } else {
                    builder.append(tabPion[i][j]).append(" | ");
                }
            }
            System.out.println(builder.toString());
            System.out.print("------------------------------------------------------------------------------------");
            System.out.println("------------------------------------------------------------------------------------");
        }
    }

    public boolean isFreePosition(Position pos) { //DONE
        return (tabPion[pos.getX()][pos.getY()] == null);
    }
}
