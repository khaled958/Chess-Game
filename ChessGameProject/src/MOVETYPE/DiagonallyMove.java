package MOVETYPE;

import component.Board;
import component.COLOR;

import static java.lang.Math.abs;

public class DiagonallyMove implements TypeMove {
    @Override
    public boolean isValidMove(Board board,int x1, int y1, int x2, int y2){
        return checklifeDiagonal(board,x1,y1,x2,y2) || checkRightDiagonal(board,x1,y1,x2,y2);
    }
    public boolean checklifeDiagonal(Board board,int x1, int y1, int x2, int y2){
       boolean isValid = false;
       int COPYx1 = x1,COPYy1 = y1;
       while (isINSIDE(COPYx1+1,COPYy1-1)){
           COPYx1+=1;
           COPYy1-=1;
           if(isNOTNULL(board,COPYx1,COPYy1) && IS_SAME_COLOR(board,COPYx1,COPYy1,x1,y1)){
                isValid = false;
                break;
           }
           if(Valid_bath(COPYx1,COPYy1,x2,y2)){
                isValid = true;
                break;
           }
       }
       return isValid;
    }
    public boolean checkRightDiagonal(Board board,int x1, int y1, int x2, int y2){
        boolean isValid = false;
        int COPYx1 = x1,COPYy1 = y1;
        while (isINSIDE(COPYx1+1,COPYy1+1)){
            COPYx1+=1;
            COPYy1+=1;
            if(isNOTNULL(board,COPYx1,COPYy1) && IS_SAME_COLOR(board,COPYx1,COPYy1,x1,y1)){
                isValid = false;
                break;
            }
            if(Valid_bath(COPYx1,COPYy1,x2,y2)){
                isValid = true;
                break;
            }
        }
        return isValid;
    }
    public boolean isINSIDE(int x1,int y1){
         return x1>=0 && x1<=7 && y1>=0 && y1<=7;
    }
    public boolean isNOTNULL(Board board,int x,int y){
         return board.getPiece(x,y)!=null;
    }
    public boolean IS_SAME_COLOR(Board board,int x1,int y1,int x2,int y2){
        return board.getPiece(x1,y1).getColor() == board.getPiece(x2,y2).getColor();
    }
    public boolean Valid_bath(int x1,int y1,int x2,int y2){
        return (x1==x2 && y1==y2);
    }
}
