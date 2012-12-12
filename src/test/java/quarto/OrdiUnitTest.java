package quarto;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/* Author : Xyrodileas */
public class OrdiUnitTest {

    @Test
    public void getPieceToPlay(){
        Piece p1 = new Piece(Couleur.CLAIRE, Forme.CARREE, Taille.BASSE, Coeur.CREUSE);
        Piece p2 = new Piece(Couleur.FONCEE, Forme.CARREE, Taille.BASSE, Coeur.CREUSE);
        Piece p3 = new Piece(Couleur.CLAIRE, Forme.RONDE, Taille.BASSE, Coeur.CREUSE);
        Piece p4 = new Piece(Couleur.CLAIRE, Forme.CARREE, Taille.BASSE, Coeur.PLEINE);
        Piece p5 = new Piece(Couleur.CLAIRE, Forme.CARREE, Taille.HAUTE, Coeur.CREUSE);
        PionBox box1 = new PionBox(Arrays.asList(p1, p2, p3, p4, p5, p1));

        Grid gr1 = new Grid(box1);
        Ordi ord1 = new Ordi("Xyro", gr1);
        //TODO
        // Forcer le random à retourner une valeur connu (p1?)
        Assert.assertTrue(ord1.getPieceToPlay() == p1);
    }
    @Test
    public void existPositionGaganteTest(){
        Piece p1 = new Piece(Couleur.CLAIRE, Forme.CARREE, Taille.BASSE, Coeur.CREUSE);
        Piece p2 = new Piece(Couleur.FONCEE, Forme.CARREE, Taille.BASSE, Coeur.CREUSE);
        Piece p3 = new Piece(Couleur.CLAIRE, Forme.RONDE, Taille.BASSE, Coeur.CREUSE);
        Piece p4 = new Piece(Couleur.CLAIRE, Forme.CARREE, Taille.BASSE, Coeur.PLEINE);
        Piece p5 = new Piece(Couleur.CLAIRE, Forme.CARREE, Taille.HAUTE, Coeur.CREUSE);

        PionBox box1 = new PionBox(Arrays.asList(p1, p2, p3, p4, p5, p1));

        Grid gr1 = new Grid(box1);
        Position pos1 = new Position(1,1);
      //  gr1.ajoutPion(pos1, p1);     //TODO M'envoit une exeption pour je ne sais quelle raison


        Ordi ord1 = new Ordi("Xyro", gr1);

    }




}
