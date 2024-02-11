package Validation;

import component.*;

public class Kingsafe implements ValidationProcess{

    ValidationProcess vp;
    @Override
    public void setNextValidation(ValidationProcess validationProcess) {
     vp  = validationProcess;
    }

    @Override
    public boolean CheckValidation(Board board , SAVEMOVE move, Player player){
        boolean check = true;
        if(player.getColor() == COLOR.White){
            int x = board.getWhitekingPos().getX();
            int y = board.getWhitekingPos().getY();
            for(Position pos : board.boardPos){
                Piece piece = board.getPiece(pos.getX(),pos.getY());
                if(piece!=null){
                    if(piece.getColor()==COLOR.Black && piece.canMove(board,pos.getX(), pos.getX(), x,y)){
                        check = false;
                    }
                }
            }
        }
        else{
            int x = board.getBlackkingPos().getX();
            int y = board.getBlackkingPos().getY();
            for(Position pos : board.boardPos){
                Piece piece = board.getPiece(pos.getX(),pos.getY());
                if(piece!=null){
                    if(piece.getColor()==COLOR.White && piece.canMove(board,pos.getX(), pos.getX(), x,y)){
                        check = false;
                    }
                }
            }
        }
       return check;
    }

}
