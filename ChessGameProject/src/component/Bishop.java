package component;

import MOVETYPE.DiagonallyMove;
import MOVETYPE.TypeMove;

import java.awt.*;

public class Bishop extends Piece{
    public Bishop(COLOR color) {
        super(color);
    }

    @Override
    public boolean canMove(Board board,int x1, int y1, int x2, int y2) {
        TypeMove move = new DiagonallyMove();
        return move.isValidMove(board,x1,y1,x2,y2);
    }
}
