package MOVETYPE;

import component.Board;
import component.COLOR;

public interface TypeMove {

    public boolean isValidMove(Board board,int x1, int y1, int x2, int y2);
}
