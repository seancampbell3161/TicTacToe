import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Game {

    public boolean isOver;
    public boolean isWon;
    public boolean isDraw;
    public String playAgain = "y";

    Scanner scan = new Scanner(System.in);

    public void run() {

        while(playAgain == "y") {

            int numOfTurns = 1;
            int maximumTurns = 9;
            boolean isValidMove = true;
            Set<Integer> pastMoves = new HashSet<>();
            System.out.println("Welcome to Tic Tac Toe!");

            System.out.print("Enter a character for player 1: ");
            Player player1 = new Player();
            player1.playerToken = scan.next();

            System.out.print("Now enter a character for player 2: ");
            Player player2 = new Player();
            player2.playerToken = scan.next();

            Board board = new Board();
            board.initBoard();
            System.out.println();
            board.printBoard();


            while(!isWon || !isDraw) {

                boolean b1 = false;
                while(!b1) {
                    System.out.println("Enter a number for player 1 to play: ");
                    int player1Move = scan.nextInt();
                    if(isOccupied(pastMoves, player1Move)) {
                        board.makeMove(player1, player1Move);
                        b1 = true;
                    } else {
                        System.out.println("That spot is taken! Choose another.");
                        System.out.println();
                    }
                }

                numOfTurns++;
                if(numOfTurns > maximumTurns) {
                    isDraw = true;
                }

                checkIfWon(board.gameBoard, player1);
                if(isWon) {
                    System.out.println("***************");
                    System.out.println("Player 1 won!");
                    System.out.println("***************");
                    break;
                } else if (isDraw) {
                    System.out.println("It is a draw!");
                    break;
                }

                boolean b2 = false;
                while(!b2) {
                    System.out.println("Enter a number for player 2 to play: ");
                    int player2Move = scan.nextInt();
                    if(isOccupied(pastMoves, player2Move)) {
                        board.makeMove(player2, player2Move);
                        b2 = true;
                    } else {
                        System.out.println("That spot is taken! Choose another.");
                        System.out.println();
                    }
                }

                numOfTurns++;
                if(numOfTurns > maximumTurns) {
                    isDraw = true;
                }

                checkIfWon(board.gameBoard, player2);
                if(isWon) {
                    System.out.println("***************");
                    System.out.println("Player 2 won!");
                    System.out.println("***************");
                    break;
                } else if (isDraw) {
                    System.out.println("***************");
                    System.out.println("It is a draw!");
                    System.out.println("***************");
                    break;
                }
            }
            scan.nextLine();
            System.out.println();
            System.out.println("Play again? y = yes");
            playAgain = scan.next();
        }

    }

    public void checkIfWon(String[][] gameBoard, Player player) {
        if(gameBoard[0][0] == player.playerToken && gameBoard[0][1] == player.playerToken && gameBoard[0][2] ==
                player.playerToken) {
            isWon = true;
        } else if (gameBoard[1][0] == player.playerToken && gameBoard[1][1] == player.playerToken && gameBoard[1][2] ==
                player.playerToken) {
            isWon = true;
        } else if (gameBoard[2][0] == player.playerToken && gameBoard[2][1] == player.playerToken && gameBoard[2][2] ==
                player.playerToken) {
            isWon = true;
        } else if (gameBoard[0][0] == player.playerToken && gameBoard[1][1] == player.playerToken && gameBoard[2][2] ==
                player.playerToken) {
            isWon = true;
        } else if (gameBoard[0][2] == player.playerToken && gameBoard[1][1] == player.playerToken && gameBoard[2][0] ==
                player.playerToken) {
            isWon = true;
        }
    }

    public boolean isOccupied(Set<Integer> pastMoves, int choice) {
        if(!pastMoves.add(choice)) {
            return false;
        }
        return true;
    }

}
