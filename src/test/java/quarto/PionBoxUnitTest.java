package quarto;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PionBoxUnitTest {

    @Test
    public void testRemove() {
        Piece p1 = new Piece(Couleur.CLAIRE, Forme.CARREE, Taille.BASSE, Coeur.CREUSE);
        Piece p2 = new Piece(Couleur.FONCEE, Forme.CARREE, Taille.BASSE, Coeur.CREUSE);
        PionBox box = new PionBox(Arrays.asList(p1, p2));
        box.remove(p1);
        Assert.assertTrue(box.getPionsDisponibles().contains(p2));
        Assert.assertEquals(1, box.getPionsDisponibles().size());

    }

    public boolean comparePiece(Piece p1, Piece p2){
        if(p1.couleur==p2.couleur && p1.forme == p2.forme && p1.taille == p2.taille && p1.coeur == p2.coeur)
            return true;
        else
            return false;

    }

    @Test
    public void testpiecesFactory(){
        Piece p1 = new Piece(Couleur.CLAIRE, Forme.CARREE, Taille.HAUTE, Coeur.PLEINE);
        Piece p2 = new Piece(Couleur.CLAIRE, Forme.CARREE, Taille.HAUTE, Coeur.CREUSE);
        Piece p3 = new Piece(Couleur.CLAIRE, Forme.CARREE, Taille.BASSE, Coeur.PLEINE);
        Piece p4 = new Piece(Couleur.CLAIRE, Forme.CARREE, Taille.BASSE, Coeur.CREUSE);
        Piece p5 = new Piece(Couleur.CLAIRE, Forme.RONDE, Taille.HAUTE, Coeur.PLEINE);
        Piece p6 = new Piece(Couleur.CLAIRE, Forme.RONDE, Taille.HAUTE, Coeur.CREUSE);
        Piece p7 = new Piece(Couleur.CLAIRE, Forme.RONDE, Taille.BASSE, Coeur.PLEINE);
        Piece p8 = new Piece(Couleur.CLAIRE, Forme.RONDE, Taille.BASSE, Coeur.CREUSE);
        Piece p9 = new Piece(Couleur.FONCEE, Forme.CARREE, Taille.HAUTE, Coeur.PLEINE);
        Piece p10 = new Piece(Couleur.FONCEE, Forme.CARREE, Taille.HAUTE, Coeur.CREUSE);
        Piece p11 = new Piece(Couleur.FONCEE, Forme.CARREE, Taille.BASSE, Coeur.PLEINE);
        Piece p12 = new Piece(Couleur.FONCEE, Forme.CARREE, Taille.BASSE, Coeur.CREUSE);
        Piece p13 = new Piece(Couleur.FONCEE, Forme.RONDE, Taille.HAUTE, Coeur.PLEINE);
        Piece p14 = new Piece(Couleur.FONCEE, Forme.RONDE, Taille.HAUTE, Coeur.CREUSE);
        Piece p15 = new Piece(Couleur.FONCEE, Forme.RONDE, Taille.BASSE, Coeur.PLEINE);
        Piece p16 = new Piece(Couleur.FONCEE, Forme.RONDE, Taille.BASSE, Coeur.CREUSE);
        List<Piece> list1 = new ArrayList<Piece>();
        PionBox box1 = new PionBox(list1);
        list1 = box1.piecesFactory();
        List<Piece> list2 = new ArrayList<Piece>();
        list2.add(p1);
        list2.add(p2);
        list2.add(p3);
        list2.add(p4);
        list2.add(p5);
        list2.add(p6);
        list2.add(p7);
        list2.add(p8);
        list2.add(p9);
        list2.add(p10);
        list2.add(p11);
        list2.add(p12);
        list2.add(p13);
        list2.add(p14);
        list2.add(p15);
        list2.add(p16);
        int x;
        boolean jr = true;
        for(x=0; x<=15;x++){
            if(!(comparePiece(list1.get(x),list2.get(x))))
                jr = false;
        }
        Assert.assertTrue(jr);
    }

    @Test
    public void testIsEmpty() {
        PionBox box = new PionBox(Collections.EMPTY_LIST);
        Assert.assertTrue(box.isEmpty());
    }
}
