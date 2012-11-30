package quarto;

import java.util.Arrays;
import java.util.Scanner;


public class Main {
	public static void main(String args[]) {
		Grid grid = new Grid(new PionBox(PionBox.piecesFactory()));
		Scanner scan = new Scanner(System.in);
		System.out.println("Veuillez entrer votre nom :");
        Quarto app=new Quarto(Arrays.asList(new Human(scan.nextLine(),grid,scan), new Ordi("hal", grid)), grid);
		app.play();
	}
}
