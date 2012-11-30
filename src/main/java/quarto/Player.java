package quarto;

public interface Player {

	public Piece getPieceToPlay();
	
	public Position getPositionToPlay(Piece p);
	
	public boolean declareQuarto();

    public void win();
}
