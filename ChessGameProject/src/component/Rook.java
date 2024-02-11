package component;

import MOVETYPE.LineMove;
import MOVETYPE.RowMove;
import MOVETYPE.TypeMove;

import java.awt.*;

public class Rook extends Piece{

    public Rook(COLOR color) {
        super(color);
    }

    @Override
    public boolean canMove(Board board,int x1, int y1, int x2, int y2) {
        TypeMove move1 = new RowMove();
        TypeMove move2 = new LineMove();
        return move1.isValidMove(board,x1,y1,x2,y2) || move2.isValidMove(board,x1,y1,x2,y2);
    }
}
