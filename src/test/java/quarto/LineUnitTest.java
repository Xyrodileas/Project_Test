/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package quarto;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author maijin
 */
public class LineUnitTest {

    @Test
    public void testisWon() {

        Line ligne1 = new Line();
        Piece p1 = new Piece(Couleur.CLAIRE, Forme.CARREE, Taille.BASSE, Coeur.CREUSE);
        Piece p2 = new Piece(Couleur.FONCEE, Forme.CARREE, Taille.BASSE, Coeur.CREUSE);
        Piece p3 = new Piece(Couleur.CLAIRE, Forme.RONDE, Taille.BASSE, Coeur.CREUSE);
        Piece p4 = new Piece(Couleur.CLAIRE, Forme.CARREE, Taille.BASSE, Coeur.PLEINE);
        Piece p5 = new Piece(Couleur.CLAIRE, Forme.CARREE, Taille.HAUTE, Coeur.CREUSE);
        ligne1.add(p1);
        ligne1.clear();
        Assert.assertFalse(ligne1.isWon());
        ligne1.add(p1); //Test Couleur
        ligne1.add(p3);
        ligne1.add(p4);
        ligne1.add(p5);
        Assert.assertTrue(ligne1.isWon());
        ligne1.clear();
        ligne1.add(p1); //Test Forme
        ligne1.add(p2);
        ligne1.add(p4);
        ligne1.add(p5);
        Assert.assertTrue(ligne1.isWon());
        ligne1.clear();
        ligne1.add(p1); //Test Taille
        ligne1.add(p2);
        ligne1.add(p3);
        ligne1.add(p4);
        Assert.assertTrue(ligne1.isWon());
        ligne1.clear();
        ligne1.add(p1); //Test Coeur
        ligne1.add(p2);
        ligne1.add(p3);
        ligne1.add(p5);
        Assert.assertTrue(ligne1.isWon());

    }
}
