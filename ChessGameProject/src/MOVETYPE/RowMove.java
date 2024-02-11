package MOVETYPE;

import component.Board;
import component.COLOR;

public class RowMove implements TypeMove {
    @Override
    public boolean isValidMove(Board board,int x1, int y1, int x2, int y2){
        boolean isValid = true;
        if(x1!=x2 && y1==y2){
            if(x1>x2){
                for(int i=x1-1;i>=x2;i--){
                    if(isNotNull(board,i,y1) && IS_SAME_COLOR(board,i,y1,x1,y1)){
                        isValid = false;
                        break;
                    }
                }
            }
            else{
                for(int i=x1+1;i<=x2;i++){
                    if(isNotNull(board,i,y1) && IS_SAME_COLOR(board,i,y1,x1,y1)){
                        isValid = false;
                        break;
                    }
                }
            }
        }
        else isValid = false;
        return isValid;
    }
    public boolean isNotNull(Board board,int x,int y){
        return board.getPiece(x,y)!=null;
    }
    public boolean IS_SAME_COLOR(Board board,int x1,int y1,int x2,int y2){
        return board.getPiece(x1,y1).getColor() == board.getPiece(x2,y2).getColor();
    }
}
