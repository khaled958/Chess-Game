package Validation;

import component.*;

public class ValidDestination implements ValidationProcess{

    ValidationProcess vp;

    @Override
    public void setNextValidation(ValidationProcess validationProcess) {
       vp = validationProcess;
    }

    @Override
    public boolean CheckValidation(Board board , SAVEMOVE move, Player player) {
        boolean isValid = false;
        int x = move.getDestination().getX();
        int y = move.getDestination().getY();
        if(board.getPiece(x,y)==null) isValid = true;
        if(board.getPiece(x,y)!=null){
            if(board.getPiece(x,y).getColor()!=player.getColor())
            isValid = true;
        }
        return isValid && vp.CheckValidation(board,move,player);

    }
}
