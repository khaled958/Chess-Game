package component;

import MOVETYPE.KingMove;
import MOVETYPE.TypeMove;

import java.awt.*;

public class King extends Piece{
    public King(COLOR color) {
        super(color);
    }

    @Override
    public boolean canMove(Board board,int x1, int y1, int x2, int y2) {
        TypeMove move = new KingMove();
        return move.isValidMove(board,x1,y1,x2,y2);
    }
}
