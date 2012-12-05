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
public class PieceUnitTest {

    @Test
    public void gettersTest() {
        Piece p1 = new Piece(Couleur.CLAIRE, Forme.CARREE, Taille.HAUTE, Coeur.PLEINE);
        Assert.assertEquals("Piece{CLAIRE, CARREE, HAUTE, PLEINE}", p1.toString());
    }
}
