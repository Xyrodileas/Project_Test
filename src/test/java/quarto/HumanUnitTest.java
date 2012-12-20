package quarto;

/**
 * Created with IntelliJ IDEA.
 * User: Alexis
 * Date: 05/12/12
 * Time: 10:35
 * To change this template use File | Settings | File Templates.
 */
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Arrays;

public class HumanUnitTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));

    }
    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }
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
    public void testgetPositionToPlay() throws InputMismatchException {       //Le test semble bon
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
        cleanUpStreams();
        setUpStreams();
        sc1 = new Scanner("2 2.1");
        h1 = new Human("NomTest", grid1, sc1);
        System.out.println("test");
        try {
            Position p12 = h1.getPositionToPlay(p1);

        } catch (InputMismatchException e) {
            Assert.fail("Failed to assert :No exception thrown ");
            Assert.assertEquals("Veuillez entrer des entiers.\r\n", errContent.toString());

        }


    }

    @Test
    public void declareQuarto(){
        Piece p5 = new Piece(Couleur.CLAIRE, Forme.CARREE, Taille.HAUTE, Coeur.CREUSE);
        PionBox box1 = new PionBox(Arrays.asList(p5));
        Grid grid1 = new Grid(box1);
        Scanner sc1 = new Scanner("True");
        Human h1 = new Human("NomTest", grid1, sc1);
        Scanner sc2 = new Scanner("False");
        Human h2 = new Human("NomTest", grid1, sc2);
        Scanner sc3 = new Scanner("Err");
        Human h3 = new Human("NomTest", grid1, sc3);
        h1.declareQuarto();
        h2.declareQuarto();
        h3.declareQuarto();

    }

    @Test
    public void winTest(){

        Piece p5 = new Piece(Couleur.CLAIRE, Forme.CARREE, Taille.HAUTE, Coeur.CREUSE);
        PionBox box1 = new PionBox(Arrays.asList(p5));
        Grid grid1 = new Grid(box1);
        Scanner sc1 = new Scanner("True");
        Human h1 = new Human("NomTest", grid1, sc1);
        h1.win();
        Assert.assertEquals("Congratulation, You win !!!\r\n", outContent.toString());
    }
}
