package component;


import MOVETYPE.PawnMove;
import MOVETYPE.TypeMove;

public class Pawn extends Piece{
    public Pawn(COLOR color) {
        super(color);
    }

    @Override
    public boolean canMove(Board board,int x1, int y1, int x2, int y2) {
        TypeMove pm = new PawnMove();
        return pm.isValidMove(board,x1,y1,x2,y2);
    }
}
