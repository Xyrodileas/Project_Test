package quarto;

/**
 * Created with IntelliJ IDEA.
 * User: Alexis
 * Date: 05/12/12
 * Time: 10:35
 * To change this template use File | Settings | File Templates.
 */
import org.junit.Assert;
import org.junit.Test;
import java.util.Scanner;
import java.util.Arrays;

public class HumanUnitTest {

    @Test
    public void testgetPieceToPlay() {
        //Création des pièces pour la liste PionBox
        Piece p1 = new Piece(Couleur.CLAIRE, Forme.CARREE, Taille.BASSE, Coeur.CREUSE);
        Piece p2 = new Piece(Couleur.FONCEE, Forme.CARREE, Taille.BASSE, Coeur.CREUSE);
        Piece p3 = new Piece(Couleur.CLAIRE, Forme.RONDE, Taille.BASSE, Coeur.CREUSE);
        Piece p4 = new Piece(Couleur.CLAIRE, Forme.CARREE, Taille.BASSE, Coeur.PLEINE);
        Piece p5 = new Piece(Couleur.CLAIRE, Forme.CARREE, Taille.HAUTE, Coeur.CREUSE);
        PionBox box1 = new PionBox(Arrays.asList(p1, p2, p3, p4, p5, p1));
        Grid grid1 = new Grid(box1);
        Scanner sc1 = new Scanner("2 4 3");
        Human h1 = new Human("NomTest", grid1, sc1);

        //Test si la pièce retournée est bien p3
        Assert.assertTrue(h1.getPieceToPlay() == p3);
                                         // Problème ici, devrait retourner False
        Assert.assertTrue(h1.getPieceToPlay() == p5);
                                         // Pareil ici
        Assert.assertFalse(h1.getPieceToPlay() == p1);

    }
    @Test
    public void testgetPositionToPlay(){       //Le test semble bon
        Piece p1 = new Piece(Couleur.CLAIRE, Forme.CARREE, Taille.BASSE, Coeur.CREUSE);
        Piece p2 = new Piece(Couleur.FONCEE, Forme.CARREE, Taille.BASSE, Coeur.CREUSE);
        Piece p3 = new Piece(Couleur.CLAIRE, Forme.RONDE, Taille.BASSE, Coeur.CREUSE);
        Piece p4 = new Piece(Couleur.CLAIRE, Forme.CARREE, Taille.BASSE, Coeur.PLEINE);
        Piece p5 = new Piece(Couleur.CLAIRE, Forme.CARREE, Taille.HAUTE, Coeur.CREUSE);
        PionBox box1 = new PionBox(Arrays.asList(p1, p2, p3, p4, p5, p1));
        Grid grid1 = new Grid(box1);
        Scanner sc1 = new Scanner("2 4");
        Human h1 = new Human("NomTest", grid1, sc1);
        Position pos1 = new Position(3, 4);
        pos1.equals(h1.getPositionToPlay(p1));
    }
}
