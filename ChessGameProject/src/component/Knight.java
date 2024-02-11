package component;

import MOVETYPE.LMove;
import MOVETYPE.LineMove;
import MOVETYPE.TypeMove;

import java.awt.*;

public class Knight extends Piece{
    public Knight(COLOR color) {
        super(color);
    }

    @Override
    public boolean canMove(Board board,int x1, int y1, int x2, int y2) {
        TypeMove move = new LMove();
        return move.isValidMove(board,x1,y1,x2,y2);
    }
}
