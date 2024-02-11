import Validation.*;
import component.*;

import java.util.Scanner;

public class CHESSGAME {
    private static CHESSGAME chessgame;
    private Board board = new Board();
    private CheckWin win = new CheckWin();
    private SAVEMOVE savemove  = new SAVEMOVE();
    private ValidInput vinput = new ValidInput();
    private VALIDCHECK check  = new VALIDCHECK();
    private Kingsafe kingsafe = new Kingsafe();
    private String source;
    private String destination;
    Scanner input = new Scanner(System.in);
    private int numberofmove = 50;
    private CHESSGAME(){

    }
    public void startGame(){
        System.out.print("PLAYER1 can you enter your name: ");
        String firstPlayer = input.nextLine();
        System.out.print("PLAYER2 can you enter your name: ");
        String secondPlayer = input.nextLine();
        System.out.println();
        Player player1 = new Player(COLOR.White,firstPlayer);
        Player player2 = new Player(COLOR.Black,secondPlayer);
        boolean whoplayer = true;
        board.setBoard();
        System.out.println("----------------------------------------------Note-------------------------------------------------");
        System.out.println("\u001B[31m"+"MOVES LIKE THIS : ENTER YOUR PIECE SOURCE LIKE a2 ENTER YOUR PIECE DESTINATION LIKE a4"+"\u001B[0m");
        System.out.println("----------------------------------------------Note-------------------------------------------------");
        System.out.println();
        while (numberofmove>0){
            board.Print();
            System.out.println();
            if(whoplayer){
                System.out.println("Please "+player1.getName()+" Enter your MOVE :");
                System.out.print("Enter your piece source : ");
                source = input.nextLine();
                System.out.print("Enter your Piece destination: ");
                destination = input.nextLine();
                System.out.println();
                System.out.println();
                if(vinput.CheckValidation(source) && vinput.CheckValidation(destination))
                check(source,destination,player1,player2);
                else{
                    while(true){
                         if(vinput.CheckValidation(source) && vinput.CheckValidation(destination)) {
                             check(source,destination,player1,player2);
                             break;
                         }
                         else{
                             System.out.println("=====WRONG INPUT=====");
                             System.out.println("Please "+player1.getName()+" Enter your MOVE :");
                             System.out.print("Enter your piece source : ");
                             source = input.nextLine();
                             System.out.print("Enter your Piece destination: ");
                             destination = input.nextLine();
                             System.out.println();
                         }
                    }
                }

            }
            else{
                System.out.println("Please "+player2.getName()+" Enter your MOVE :");
                System.out.print("Enter your piece source : ");
                source = input.nextLine();
                System.out.print("Enter your Piece destination: ");
                destination = input.nextLine();
                System.out.println();
                System.out.println();
                check(source,destination,player2,player1);

            }
            numberofmove--;
            whoplayer = !whoplayer;
        }


    }
    public static CHESSGAME getInstance(){
        if(chessgame==null){
            chessgame = new CHESSGAME();
        }
        return chessgame;
    }
    public void check(String source,String destination,Player player,Player isWin){
                int y1 =  source.charAt(0)-'a';
                int x1 = source.charAt(1)-'1';
                savemove.setSource(new Position(x1,y1));
                int y2 = destination.charAt(0)-'a';
                int x2 = destination.charAt(1)-'1';
                savemove.setDestination(new Position(x2,y2));
                while(true){
                   if(check.CheckValidation(board,savemove,player)){
                       Piece piece = board.getPiece(x1,y1);
                       board.setPiece(x1,y1,null);
                       board.setPiece(x2,y2,piece);
                       String str = board.getPrintBoard(x1,y1);
                       board.setPrintBoard(x2,y2,str);
                       board.setPrintBoard(x1,y1,"--");
                       break;
                   }
                   else{
                           if((kingsafe.CheckValidation(board,savemove,player))){
                               System.out.println();
                               System.out.println("InvalidMove");
                               System.out.println();
                               System.out.println("Please "+player.getName()+" Enter your MOVE :");
                               System.out.print("Enter your piece source : ");
                               source = input.nextLine();
                               System.out.print("Enter your Piece destination: ");
                               destination = input.nextLine();
                               if(vinput.CheckValidation(source) && vinput.CheckValidation(destination)){
                                   y1 =  source.charAt(0)-'a';
                                   x1 = source.charAt(1)-'1';
                                   savemove.setSource(new Position(x1,y1));
                                   y2 = destination.charAt(0)-'a';
                                   x2 = destination.charAt(1)-'1';
                                   savemove.setDestination(new Position(x2,y2));
                               }
                               else{
                                   while(true){
                                       if(vinput.CheckValidation(source) && vinput.CheckValidation(destination)) {
                                            y1 =  source.charAt(0)-'a';
                                            x1 = source.charAt(1)-'1';
                                           savemove.setSource(new Position(x1,y1));
                                            y2 = destination.charAt(0)-'a';
                                            x2 = destination.charAt(1)-'1';
                                           savemove.setDestination(new Position(x2,y2));
                                           break;
                                       }
                                       else{
                                           System.out.println("=====WRONG INPUT=====");
                                           System.out.println("Please "+player.getName()+" Enter your MOVE :");
                                           System.out.print("Enter your piece source : ");
                                           source = input.nextLine();
                                           System.out.print("Enter your Piece destination: ");
                                           destination = input.nextLine();
                                           System.out.println();
                                       }
                                   }
                               }

                           }
                           else{
                               if(win.isWin(board,savemove,player)){
                                   System.out.println("------------CHECKMATE----------");
                                   System.out.println(player.getName()+" you are loser");
                                   System.out.println(isWin.getName()+" you are Winner");
                                   numberofmove = 0;
                                   break;
                               }
                               else{
                                 while(true){
                                     if(kingsafe.CheckValidation(board,savemove,player)){
                                         Piece piece = board.getPiece(x1,y1);
                                         board.setPiece(x1,y1,null);
                                         board.setPiece(x2,y2,piece);
                                         String str = board.getPrintBoard(x1,y1);
                                         board.setPrintBoard(x2,y2,str);
                                         board.setPrintBoard(x1,y1,"--");
                                     }
                                     else{
                                         System.out.println();
                                         System.out.println("Your King in danger please make him in safe");
                                         System.out.println();
                                         System.out.println("Please "+player.getName()+" Enter your MOVE :");
                                         System.out.print("Enter your piece source : ");
                                         source = input.nextLine();
                                         System.out.print("Enter your Piece destination: ");
                                         destination = input.nextLine();
                                     }
                                 }
                               }
                           }
                   }

                }

    }

}
