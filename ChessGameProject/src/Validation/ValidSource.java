package Validation;

import component.*;

public class ValidSource implements ValidationProcess{


    ValidationProcess vp;
    @Override
    public void setNextValidation(ValidationProcess validationProcess) {
          vp = validationProcess;
    }

    @Override
    public boolean CheckValidation(Board board , SAVEMOVE move, Player player){
        boolean isValid  = true;
        int x = move.getSource().getX();
        int y = move.getSource().getY();
        if(board.getPiece(x,y)==null){
            isValid = false;
        }
        if(board.getPiece(x,y)!=null){
            if(board.getPiece(x,y).getColor()!=player.getColor()){
                isValid = false;
            }
        }
        return isValid && vp.CheckValidation(board,move,player);
    }
}
