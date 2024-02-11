package component;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private Piece [][]board;
    private String [][]CHESSBOARD;
    private Position whiteking;
    private Position blackKing;
    public ArrayList<Position> boardPos;

    String reset = "\u001B[0m";
    String b = "\u001B[30m";
    public Board(){
        board = new Piece[8][8];
        CHESSBOARD = new String[8][8];

        boardPos = new ArrayList<>();
        whiteking = new Position(0,4);
        blackKing = new Position(7,4);
       for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                 boardPos.add(new Position(i,j));
            }
       }
    }

    public void setBoard(){
      setPawn();
      setKing();
      setKnight();
      setRook();
      setQueen();
      setBishop();
      setNull();
    }
    public void setPawn(){
        for (int j = 0; j < 8; j++) {
            board[1][j] = new Pawn(COLOR.White);
            CHESSBOARD[1][j] = "WP";
        }
        for (int j = 0; j < 8; j++) {
            board[6][j] = new Pawn(COLOR.Black);
            CHESSBOARD[6][j] = b+"BP"+reset;
        }
    }
    public void setKnight(){
        board[0][1] = new Knight(COLOR.White);
        CHESSBOARD[0][1] = "WK";
        board[0][6] = new Knight(COLOR.White);
        CHESSBOARD[0][6] = "WK";
        board[7][1] = new Knight(COLOR.Black);
        CHESSBOARD[7][1] = b+"BK"+reset;
        board[7][6] = new Knight(COLOR.Black);
        CHESSBOARD[7][6] = b+"BK"+reset;
    }
    public void setRook(){
        board[0][0] = new Rook(COLOR.White);
        CHESSBOARD[0][0] = "WR";
        board[0][7] = new Rook(COLOR.White);
        CHESSBOARD[0][7] = "WR";
        board[7][7] = new Rook(COLOR.Black);
        CHESSBOARD[7][7] = b+"BR"+reset;
        board[7][0] = new Rook(COLOR.Black);
        CHESSBOARD[7][0] = b+"BR"+reset;
    }
    public void setBishop(){
        board[0][2] = new Bishop(COLOR.White);
        CHESSBOARD[0][2] = "WB";
        board[0][5] = new Bishop(COLOR.White);
        CHESSBOARD[0][5] = "WB";
        board[7][2] = new Bishop(COLOR.Black);
        CHESSBOARD[7][2] = b+"BB"+reset;
        board[7][5] = new Bishop(COLOR.Black);
        CHESSBOARD[7][5] = b+"BB"+reset;
    }
    public void setQueen(){
        board[0][3] = new Queen(COLOR.White);
        CHESSBOARD[0][3] = "WQ";
        board[7][3] = new Queen(COLOR.Black);
        CHESSBOARD[7][3] = b+"BQ"+reset;
    }
    public void setKing(){
        board[0][4] = new King(COLOR.White);
        CHESSBOARD[0][4] = "WKG";
        board[7][4] = new King(COLOR.Black);
       CHESSBOARD[7][4] = b+"BKG"+reset;
    }

    public void setNull(){
        for(int i=2;i<6;i++){
            for(int j=0;j<8;j++){
                 board[i][j] = null;
                 CHESSBOARD[i][j] ="--";
            }
        }
    }

    public Piece getPiece(int x,int y){
         return board[x][y];
    }
    public void setPiece(int x,int y,Piece piece){
        board[x][y] = piece;
    }
    public void Print(){

        System.out.println("   -------CHESSBOARD-------");
        System.out.println("    a  b  c  d   e  f  g  h");
        for(int i=7;i>=0;i--){
            System.out.print(i+1+" | ");
            for(int j=0;j<8;j++){
                System.out.print(CHESSBOARD[i][j]+" ");
            }
            if(i==0 || i==7)
            System.out.println("| "+(i+1));
            else{
                System.out.println(" | "+(i+1));
            }
        }
        System.out.println("    a  b  c  d   e  f  g  h");
        System.out.println("   -------CHESSBOARD-------");
    }
    public Position getWhitekingPos(){
         return whiteking;
    }
    public Position getBlackkingPos(){
        return blackKing;
    }
     public void setWhiteking(int x,int y){
        whiteking = new Position(x,y);
     }
     public void setBlackKing(int x,int y){
         blackKing = new Position(x,y);
     }
     public void setPrintBoard(int x,int y,String str){
         CHESSBOARD[x][y] = str;
     }
     public String getPrintBoard(int x,int y){
         return CHESSBOARD[x][y];
     }
}
