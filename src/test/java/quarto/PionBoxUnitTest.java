package quarto;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

public class PionBoxUnitTest {


    @Test
    public void testRemove(){
        Piece p1 = new Piece(Couleur.CLAIRE,Forme.CARREE,Taille.BASSE,Coeur.CREUSE);
        Piece p2 = new Piece(Couleur.FONCEE, Forme.CARREE, Taille.BASSE, Coeur.CREUSE);
        PionBox box = new PionBox(Arrays.asList(p1,p2));
        box.remove(p1);
        Assert.assertTrue(box.getPionsDisponibles().contains(p2));
        Assert.assertEquals(1, box.getPionsDisponibles().size());

    }

    @Test
    public void testIsEmpty(){
        PionBox box = new PionBox(Collections.EMPTY_LIST);
        Assert.assertTrue(box.isEmpty());
    }
}
