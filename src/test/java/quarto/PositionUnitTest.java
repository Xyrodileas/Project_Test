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
public class PositionUnitTest {

    @Test
    public void gettersTest() {
        Position p1 = new Position(3, 2);
        Assert.assertEquals(3, p1.getX());
        Assert.assertEquals(2, p1.getY());
    }

    @Test
    public void equalsTest() {
        Position p1 = new Position(3, 2);
        Position p1eq = new Position(3, 2);
        Position p2 = new Position(3, 4);
        Position pnull = null;
        String s1 = new String();

        Assert.assertTrue(p1.equals(p1));
        Assert.assertFalse(p1.equals(pnull));
        Assert.assertFalse(p1.equals(s1));
        Assert.assertFalse(p1.equals(p2));
        Assert.assertTrue(p1.equals(p1eq));
    }

    @Test
    public void toStringTest() {
        Position p1 = new Position(3, 2);
        Assert.assertEquals("3 2", p1.toString());
    }
}
