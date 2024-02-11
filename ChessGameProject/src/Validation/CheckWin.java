package Validation;

import component.*;

public class CheckWin{


    public boolean isWin(Board board , SAVEMOVE move, Player player){
        return !moveKing(board,move,player) && !movePiece(board,move,player);
    }
    public boolean moveKing(Board board,SAVEMOVE move,Player player){
        boolean can = false;
        int X[] = {0,0,-1,1,-1,-1,1,1};
        int Y[] = {-1,1,0,0,1,-1,1,-1};
        ValidationProcess vp = new Kingsafe();
        if(player.getColor()==COLOR.White){
            int x = board.getWhitekingPos().getX();
            int y = board.getWhitekingPos().getY();
            if(!(vp.CheckValidation(board , move, player))){
                for(int i=0;i<8;i++){
                    int x1 = x+X[i];
                    int y1 = y+Y[i];
                    if(x1>=0 && x1<=7 && y1>=0 && y1<=7) {
                        if ((vp.CheckValidation( board , move, player))) {
                            can = true;
                            break;
                        }
                    }
                }
            }
        }
        else{
            int x = board.getBlackkingPos().getX();
            int y = board.getBlackkingPos().getY();
            if(!(vp.CheckValidation(board , move, player))){
                for(int i=0;i<8;i++){
                    int x1 = x+X[i];
                    int y1 = y+Y[i];
                    if(x1>=0 && x1<=7 && y1>=0 && y1<=7) {
                        if ((vp.CheckValidation(board , move, player))) {
                            can = true;
                            break;
                        }
                    }
                }
            }
        }
        return can;
    }
    public boolean movePiece(Board board,SAVEMOVE savemove,Player player){
        int X[] = {0,0,-1,1,-1,-1,1,1};
        int Y[] = {-1,1,0,0,1,-1,1,-1};
        boolean can  = false;
        ValidationProcess vp = new Kingsafe();
        if(player.getColor() == COLOR.White){
            int x = board.getWhitekingPos().getX();
            int y = board.getWhitekingPos().getY();
            for(Position pos : board.boardPos){
                Piece piece = board.getPiece(pos.getX(), pos.getY());
                if(piece!=null){
                    for(int i=0;i<8;i++){
                        int x1 = x+X[i];
                        int y1 = y+Y[i];
                        if(x1>=0 && x1<=7 && y1>=0 && y1<=7){
                            if(piece.canMove(board,x,y,x1,y1) && vp.CheckValidation(board,savemove,player)){
                              can = true;
                              break;
                            }
                        }
                    }
                }
            }
        }
        else{
            int x = board.getBlackkingPos().getX();
            int y = board.getBlackkingPos().getY();
            for(Position pos : board.boardPos){
                Piece piece = board.getPiece(pos.getX(), pos.getY());
                if(piece!=null){
                    for(int i=0;i<8;i++){
                        int x1 = x+X[i];
                        int y1 = y+Y[i];
                        if(x1>=0 && x1<=7 && y1>=0 && y1<=7){
                            if(piece.canMove(board,x,y,x1,y1) && vp.CheckValidation(board,savemove,player)){
                                can = true;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return can;
    }
}
