package MOVETYPE;

import component.Board;
import component.COLOR;

public class KingMove implements TypeMove {
    @Override
    public boolean isValidMove(Board board,int x1, int y1, int x2, int y2) {
        int diffx = x2-x1,diffy = y2-y1;
        boolean isValid = false;
        if(diffx>=1 && diffx<=-1){
            if(diffy>=1 && diffy<=-1){
                isValid =  true;
            }
        }
       return isValid;
    }
}
