/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package quarto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author maijin
 */
public class GridUnitTest {

    @Test
    public void getTabPionTest() {
        List<Piece> pionsDisponibles = new ArrayList<Piece>();
        PionBox box = new PionBox(pionsDisponibles);
        Piece p1 = new Piece(Couleur.CLAIRE, Forme.CARREE, Taille.BASSE, Coeur.CREUSE);
        pionsDisponibles.add(p1);
        Grid g1 = new Grid(box);


        Piece[][] p2;
        p2 = g1.getTabPion();
    }

    @Test
    public void getPionsDisponiblesTest() {
        List<Piece> pionsDisponibles = new ArrayList<Piece>();
        Piece p1 = new Piece(Couleur.CLAIRE, Forme.CARREE, Taille.BASSE, Coeur.CREUSE);
        pionsDisponibles.add(p1);
        PionBox box = new PionBox(pionsDisponibles);

        Grid g1 = new Grid(box);

        Assert.assertTrue(g1.getPionsDisponibles().contains(p1));

    }

    @Test(expected = PionMemePlaceException.class)
    public void ajoutPionTest() throws PionMemePlaceException {
        Piece p1 = new Piece(Couleur.CLAIRE, Forme.CARREE, Taille.BASSE, Coeur.CREUSE);
        Piece p2 = new Piece(Couleur.FONCEE, Forme.CARREE, Taille.BASSE, Coeur.CREUSE);
        PionBox box = new PionBox(Arrays.asList(p1, p2));
        Grid g1 = new Grid(box);
        Position posp1 = new Position(0, 0);
        Position posp2 = new Position(0, 0);
        g1.ajoutPion(posp1, p1);
        g1.ajoutPion(posp2, p2);


        // incomplet!! Il faut pouvoir tester la valeur de hist
        //Possède Une opération inutiles
        // Oublie de l'utilisation de IsFree, rendIndisponible
        // Attention aux nombres négatifs !
    }

    @Test
    public void undoTest() throws PionMemePlaceException {
        Piece p1 = new Piece(Couleur.CLAIRE, Forme.CARREE, Taille.BASSE, Coeur.CREUSE);
        Piece p2 = new Piece(Couleur.FONCEE, Forme.CARREE, Taille.BASSE, Coeur.CREUSE);
        PionBox box = new PionBox(Arrays.asList(p1, p2));
        Grid g1 = new Grid(box);
        Position posp1 = new Position(0, 0);
        Position posp2 = new Position(0, 1);
        g1.ajoutPion(posp1, p1);

        g1.ajoutPion(posp2, p2);
        g1.undo();


    }

    @Test
    public void isFreePositionTest() throws PionMemePlaceException {
        Piece p1 = new Piece(Couleur.CLAIRE, Forme.CARREE, Taille.BASSE, Coeur.CREUSE);
        Piece p2 = new Piece(Couleur.FONCEE, Forme.CARREE, Taille.BASSE, Coeur.CREUSE);
        PionBox box = new PionBox(Arrays.asList(p1, p2));
        Grid g1 = new Grid(box);
        Position posp1 = new Position(0, 0);
        Assert.assertTrue(g1.isFreePosition(posp1));
        g1.ajoutPion(posp1, p1);
        Assert.assertFalse(g1.isFreePosition(posp1));
    }

    @Test
    public void estGagneeLigneTest() throws PionMemePlaceException {

        Piece p1 = new Piece(Couleur.CLAIRE, Forme.CARREE, Taille.BASSE, Coeur.CREUSE);
        Piece p2 = new Piece(Couleur.FONCEE, Forme.CARREE, Taille.BASSE, Coeur.CREUSE);
        Piece p3 = new Piece(Couleur.FONCEE, Forme.CARREE, Taille.BASSE, Coeur.CREUSE);
        Piece p4 = new Piece(Couleur.FONCEE, Forme.CARREE, Taille.BASSE, Coeur.CREUSE);

        PionBox box = new PionBox(Arrays.asList(p1, p2, p3, p4));
        Grid g1 = new Grid(box);
        Position posp1 = new Position(0, 0);
        Position posp2 = new Position(0, 1);
        Position posp3 = new Position(0, 2);
        Position posp4 = new Position(0, 3);
        Assert.assertFalse(g1.estGagnee());
        g1.ajoutPion(posp1, p1);
        g1.ajoutPion(posp2, p2);
        g1.ajoutPion(posp3, p3);
        g1.ajoutPion(posp4, p4);
        Assert.assertTrue(g1.estGagnee());


    }

    @Test
    public void estGagneeColonneTest() throws PionMemePlaceException {

        Piece p1 = new Piece(Couleur.CLAIRE, Forme.CARREE, Taille.BASSE, Coeur.CREUSE);
        Piece p2 = new Piece(Couleur.FONCEE, Forme.CARREE, Taille.BASSE, Coeur.CREUSE);
        Piece p3 = new Piece(Couleur.FONCEE, Forme.CARREE, Taille.BASSE, Coeur.CREUSE);
        Piece p4 = new Piece(Couleur.FONCEE, Forme.CARREE, Taille.BASSE, Coeur.CREUSE);

        PionBox box = new PionBox(Arrays.asList(p1, p2, p3, p4));
        Grid g1 = new Grid(box);
        Position posp1 = new Position(0, 0);
        Position posp2 = new Position(1, 0);
        Position posp3 = new Position(2, 0);
        Position posp4 = new Position(3, 0);
        g1.ajoutPion(posp1, p1);
        g1.ajoutPion(posp2, p2);
        g1.ajoutPion(posp3, p3);
        g1.ajoutPion(posp4, p4);
        Assert.assertTrue(g1.estGagnee());
    }

    @Test
    public void estGagneeDiagGaucheTest() throws PionMemePlaceException {

        Piece p1 = new Piece(Couleur.CLAIRE, Forme.CARREE, Taille.BASSE, Coeur.CREUSE);
        Piece p2 = new Piece(Couleur.FONCEE, Forme.CARREE, Taille.BASSE, Coeur.CREUSE);
        Piece p3 = new Piece(Couleur.FONCEE, Forme.CARREE, Taille.BASSE, Coeur.CREUSE);
        Piece p4 = new Piece(Couleur.FONCEE, Forme.CARREE, Taille.BASSE, Coeur.CREUSE);

        PionBox box = new PionBox(Arrays.asList(p1, p2, p3, p4));
        Grid g1 = new Grid(box);
        Position posp1 = new Position(0, 0);
        Position posp2 = new Position(1, 1);
        Position posp3 = new Position(2, 2);
        Position posp4 = new Position(3, 3);
        g1.ajoutPion(posp1, p1);
        g1.ajoutPion(posp2, p2);
        g1.ajoutPion(posp3, p3);
        g1.ajoutPion(posp4, p4);
        Assert.assertTrue(g1.estGagnee());
    }

    @Test
    public void estGagneeDiagDroiteTest() throws PionMemePlaceException {

        Piece p1 = new Piece(Couleur.CLAIRE, Forme.CARREE, Taille.BASSE, Coeur.CREUSE);
        Piece p2 = new Piece(Couleur.FONCEE, Forme.CARREE, Taille.BASSE, Coeur.CREUSE);
        Piece p3 = new Piece(Couleur.FONCEE, Forme.CARREE, Taille.BASSE, Coeur.CREUSE);
        Piece p4 = new Piece(Couleur.FONCEE, Forme.CARREE, Taille.BASSE, Coeur.CREUSE);

        PionBox box = new PionBox(Arrays.asList(p1, p2, p3, p4));
        Grid g1 = new Grid(box);
        Position posp1 = new Position(0, 3);
        Position posp2 = new Position(1, 2);
        Position posp3 = new Position(2, 1);
        Position posp4 = new Position(3, 0);
        g1.ajoutPion(posp1, p1);
        g1.ajoutPion(posp2, p2);
        g1.ajoutPion(posp3, p3);
        g1.ajoutPion(posp4, p4);
        Assert.assertTrue(g1.estGagnee());

    }

    @Test
    public void toStringTest() throws PionMemePlaceException {
        Piece p1 = new Piece(Couleur.CLAIRE, Forme.CARREE, Taille.BASSE, Coeur.CREUSE);
        Piece p2 = new Piece(Couleur.FONCEE, Forme.CARREE, Taille.BASSE, Coeur.CREUSE);
        PionBox box = new PionBox(Arrays.asList(p1, p2));
        Grid g1 = new Grid(box);
        Position posp1 = new Position(0, 0);
        Position posp2 = new Position(0, 1);
        g1.ajoutPion(posp1, p1);

        g1.ajoutPion(posp2, p2);


        Assert.assertEquals("1 1 0 0 \n"
                + "0 0 0 0 \n"
                + "0 0 0 0 \n"
                + "0 0 0 0 \n", g1.toString());
    }

    @Test
    public void rendIndisponibleTest() {
        Piece p1 = new Piece(Couleur.CLAIRE, Forme.CARREE, Taille.BASSE, Coeur.CREUSE);

        PionBox box = new PionBox(Arrays.asList(p1));
        Grid g1 = new Grid(box);
        g1.rendIndisponible(p1);
        Assert.assertTrue(box.isEmpty());

    }

    @Test
    public void extractLineTest() {
    }

    @Test
    public void extractColumnTest() {
    }

    @Test
    public void extractSecondDiagonalTest() {
    }

    @Test
    public void extractFirstDiagonalTest() {
    }

    @Test
    public void isPatTest() {
        Piece p1 = new Piece(Couleur.CLAIRE, Forme.CARREE, Taille.BASSE, Coeur.CREUSE);
        PionBox box = new PionBox(Arrays.asList(p1));
        Grid g1 = new Grid(box);
        g1.rendIndisponible(p1);

        Assert.assertTrue(g1.isPat());
    }
}
