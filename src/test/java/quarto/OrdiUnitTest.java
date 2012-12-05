package quarto;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: gcolajan
 * Date: 30/11/12
 * Time: 10:43
 * To change this template use File | Settings | File Templates.
 */
public class OrdiUnitTest {

    @Test
    public void testPieceToPlay() {
        // À reprendre
        Piece p1 = new Piece(Couleur.CLAIRE,Forme.CARREE,Taille.BASSE,Coeur.CREUSE);
        Piece p2 = new Piece(Couleur.FONCEE, Forme.CARREE, Taille.BASSE, Coeur.CREUSE);

        PionBox box = new PionBox(Arrays.asList(p1, p2));
        Grid grille = new Grid(box);

        Ordi ordi = new Ordi("IA", grille);



    }
}
