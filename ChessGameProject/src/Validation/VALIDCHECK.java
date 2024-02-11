package Validation;

import component.*;

public class VALIDCHECK {
    private ValidSource VS;
    private ValidDestination VD;
    private CanMakeMove CMM;
    private Kingsafe KS;

    public VALIDCHECK(){
        VS = new ValidSource();
        VD = new ValidDestination();
        CMM = new CanMakeMove();
        KS = new Kingsafe();
         VS.setNextValidation(VD);
         VD.setNextValidation(CMM);
         CMM.setNextValidation(KS);
    }
    public boolean CheckValidation(Board board , SAVEMOVE move, Player player){
        return VS.CheckValidation(board , move, player);
    }
}
