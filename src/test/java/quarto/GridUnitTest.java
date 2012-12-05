/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package quarto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.Box;
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
        Piece p1 = new Piece(Couleur.CLAIRE,Forme.CARREE,Taille.BASSE,Coeur.CREUSE);
        pionsDisponibles.add(p1);
        Grid g1 = new Grid(box);
        
        
        Piece[][] p2;
        p2 = g1.getTabPion();
    }
    
    @Test
    public void getPionsDisponiblesTest() {
        List<Piece> pionsDisponibles = new ArrayList<Piece>();
        Piece p1 = new Piece(Couleur.CLAIRE,Forme.CARREE,Taille.BASSE,Coeur.CREUSE);
        pionsDisponibles.add(p1);
        PionBox box = new PionBox(pionsDisponibles);
        
        Grid g1 = new Grid(box);
        
        Assert.assertTrue(g1.getPionsDisponibles().contains(p1));
        
    }
    
    @Test(expected=PionMemePlaceException.class)
    public void ajoutPionTest() throws PionMemePlaceException{
        Piece p1 = new Piece(Couleur.CLAIRE,Forme.CARREE,Taille.BASSE,Coeur.CREUSE);
        Piece p2 = new Piece(Couleur.FONCEE, Forme.CARREE, Taille.BASSE, Coeur.CREUSE);
        PionBox box = new PionBox(Arrays.asList(p1,p2));
        Grid g1 = new Grid(box);
        Position posp1 = new Position(0,0);
        Position posp2 = new Position(0,0); 
        g1.ajoutPion(posp1, p1);
        g1.ajoutPion(posp2, p2);
        
  
        // incomplet!! Il faut pouvoir tester la valeur de hist
        //Possède Une opération inutiles
        // Oublie de l'utilisation de IsFree, rendIndisponible
    }

    @Test
    public void undoTest() throws PionMemePlaceException{
        Piece p1 = new Piece(Couleur.CLAIRE,Forme.CARREE,Taille.BASSE,Coeur.CREUSE);
        Piece p2 = new Piece(Couleur.FONCEE, Forme.CARREE, Taille.BASSE, Coeur.CREUSE);
        PionBox box = new PionBox(Arrays.asList(p1,p2));
        Grid g1 = new Grid(box);
        Position posp1 = new Position(0,0);
        Position posp2 = new Position(0,1); 
        g1.ajoutPion(posp1, p1);
        
        g1.ajoutPion(posp2, p2);
        g1.undo();
        

    }   
}
