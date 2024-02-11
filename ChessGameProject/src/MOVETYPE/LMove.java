package MOVETYPE;

import component.Board;
import component.COLOR;


public class LMove implements TypeMove {
    @Override
    public boolean isValidMove(Board board,int x1, int y1, int x2, int y2){
        int diffx =Math.abs(x2-x1),diffy = Math.abs(y2-y1);
        return (diffx==1 && diffy==2) || (diffx==2 && diffy==1);
    }
}
