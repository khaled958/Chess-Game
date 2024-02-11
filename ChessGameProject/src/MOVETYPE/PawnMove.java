package MOVETYPE;

import component.Board;
import component.COLOR;
import component.SAVEMOVE;

public class PawnMove implements TypeMove {
    @Override
    public boolean isValidMove(Board board,int x1,int y1,int x2,int y2){
        int diffx = Math.abs(x2-x1);
        int diffy = Math.abs(y2-y1);
        boolean isValid = false;
        if(IS_FIRST_MOVE(x1)){
           if(IS_EQUAL_LINE(y1,y2) && (diffx==1 || diffx==2) && isNULL(board,x2,y2))
               isValid = true;
       }
        else{
             if(IS_EQUAL_LINE(y1,y2) && diffx==1 && isNULL(board,x2,y2)){
                     isValid = true;
             }
             else{
                  if(diffx==1 && diffy==1)
                      isValid = true;
             }
        }
        return isValid;
    }
    public boolean IS_FIRST_MOVE(int x1){
         return x1 == 1 || x1 == 6;
    }
    public boolean IS_EQUAL_LINE(int y1,int y2){
         return y1==y2;
    }

    public boolean isNULL(Board board,int x,int y){
        return board.getPiece(x,y)==null;
    }
}
