package component;

import MOVETYPE.DiagonallyMove;
import MOVETYPE.LineMove;
import MOVETYPE.RowMove;
import MOVETYPE.TypeMove;

import java.awt.*;

public class Queen extends Piece{

    public Queen(COLOR color){
         super(color);
    }

    @Override
    public boolean canMove(Board board,int x1, int y1, int x2, int y2) {
        TypeMove move1 = new DiagonallyMove();
        TypeMove move2 = new LineMove();
        TypeMove move3 = new RowMove();
        return move1.isValidMove(board,x1,y1,x2,y2) || move2.isValidMove(board,x1,y1,x2,y2) || move3.isValidMove(board,x1,y1,x2,y2);

    }
}
