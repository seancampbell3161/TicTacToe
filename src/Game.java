import java.util.Scanner;

public class Game {

    public boolean isOver;
    public boolean isWon;
    public boolean isDraw;
    public String playAgain = "y";

    Scanner scan = new Scanner(System.in);

    public void run() {

        while(playAgain == "y") {

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
                int numOfTurns = 1;
                System.out.println("Enter a number for player 1 to play: ");
                board.makeMove(player1, scan.nextInt());
                numOfTurns++;
                checkIfWon(board.gameBoard, player1);

                if(numOfTurns == board.gameBoard.length) {
                    isDraw = true;
                }

                if(isWon) {
                    System.out.println("***************");
                    System.out.println("Player 1 won!");
                    System.out.println("***************");
                    break;
                } else if (isDraw) {
                    System.out.println("It is a draw!");
                    break;
                }

                System.out.println("Enter a number for player 2 to play: ");
                board.makeMove(player2, scan.nextInt());
                numOfTurns++;
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

}
