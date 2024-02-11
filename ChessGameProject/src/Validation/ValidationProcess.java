package Validation;

import component.*;

public interface ValidationProcess {
   void setNextValidation(ValidationProcess validationProcess);
   boolean CheckValidation(Board board , SAVEMOVE move, Player player);

}
