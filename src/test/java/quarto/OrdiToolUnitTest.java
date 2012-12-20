package quarto;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: Alexis
 * Date: 20/12/12
 * Time: 13:44
 * To change this template use File | Settings | File Templates.
 */
public class OrdiToolUnitTest {

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

        // Forcer le random à retourner une valeur connu (p1?)
        Assert.assertTrue(ord1.getPieceToPlay() == p1);
    }
    @Test
    public void positionsLibresTest() throws PionMemePlaceException{

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
        PionBox box1 = new PionBox(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16));

        Grid gr1 = new Grid(box1);
        gr1 = new Grid(box1);
        Position pos1 = new Position(0,0);
        gr1.ajoutPion(pos1, p1);
        pos1 = new Position(0,1);
        gr1.ajoutPion(pos1, p2);
        pos1 = new Position(0,2);
        gr1.ajoutPion(pos1, p3);
        pos1 = new Position(0,3);
        gr1.ajoutPion(pos1, p4);
        pos1 = new Position(1,0);
        gr1.ajoutPion(pos1, p5);
        pos1 = new Position(1,1);
        gr1.ajoutPion(pos1, p6);
        pos1 = new Position(1,2);
        gr1.ajoutPion(pos1, p7);
        pos1 = new Position(1,3);
        gr1.ajoutPion(pos1, p8);
        pos1 = new Position(2,0);
        gr1.ajoutPion(pos1, p9);
        pos1 = new Position(2,1);
        gr1.ajoutPion(pos1, p10);
        pos1 = new Position(2,2);
        gr1.ajoutPion(pos1, p11);
        pos1 = new Position(2,3);
        gr1.ajoutPion(pos1, p12);
        pos1 = new Position(3,0);
        gr1.ajoutPion(pos1, p13);
        pos1 = new Position(3,1);
        gr1.ajoutPion(pos1, p14);
        pos1 = new Position(3,2);
        gr1.ajoutPion(pos1, p15);

        pos1 = new Position(3,3);
        System.out.println(gr1);
        Assert.assertTrue(OrdiTool.positionsLibres(gr1)==pos1);



    }
}
