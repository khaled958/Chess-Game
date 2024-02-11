package Validation;

import component.*;

public class CanMakeMove implements ValidationProcess{

    ValidationProcess vp;
    @Override
    public void setNextValidation(ValidationProcess validationProcess) {
        vp = validationProcess;
    }

    @Override
    public boolean CheckValidation(Board board , SAVEMOVE move, Player player) {
        boolean isValid = false;
        int x1 = move.getSource().getX();
        int y1 = move.getSource().getY();
        int x2 = move.getDestination().getX();
        int y2 = move.getDestination().getY();
        Piece piece = board.getPiece(x1,y1);
        if(piece.canMove(board,x1,y1,x2,y2)){
             isValid = true;
        }
        return isValid && vp.CheckValidation(board,move,player);

    }
}
