package Validation;

import component.Board;
import component.COLOR;
import component.Piece;
import component.Player;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidInput{




    public boolean CheckValidation(String input){
        String regex = "^[a-h][1-8]$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
}
