package quarto;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Human implements Player {

    private Scanner sc;
    public String name;
    protected Grid grille;

    public Human(String name, Grid grille, Scanner sc) {
        this.name = name;
        this.grille = grille;
        this.sc = sc;

    }

    @Override
    public Piece getPieceToPlay() {

        System.out.println("Liste des pions disponibles :");
        List<Piece> pions = grille.getPionsDisponibles();
        for (int i = 0; i < pions.size(); ++i) {
            System.out.println(i + " : " + pions.get(i));
        }
        System.out.print("Indice du pion a donner ? ");
        // TODO
        // Surement une modification à faire, on essais de faire "nextInt()" sans vérifier s'il y a un int avec "hasInt()"
        int indice = sc.nextInt();

        Piece piece = pions.get(indice);
        grille.rendIndisponible(piece);
        return piece;
    }

    @Override
    public Position getPositionToPlay(Piece p) {
        System.out.println("L'IA vous donne le pion : " + p);
        int x = 0;
        int y = 0;
        System.out.println("Entrer les coordonnees où jouer :");
        boolean pasBon = true;
        while (pasBon) {
            try {
                x = sc.nextInt();
                y = sc.nextInt();
                pasBon = false;
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.err.println("Veuillez entrer des entiers.");
                x = 9;
                y = 9;
            }
        }
        return new Position(x, y);
    }

    @Override
    public boolean declareQuarto() { //TODO
        System.out.println("Quarto (true/false) ?");
        return sc.nextBoolean();                       // Ajouter une vérification s'il y a bien une Boolean
    }

    @Override
    public void win() {
        System.out.print("Congratulation, You win !!!");
    }
}
