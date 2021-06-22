import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Game {

    public boolean isOver;
    public boolean isWon;
    public boolean isDraw;
    public boolean playAgain = true;
    Scanner scan = new Scanner(System.in);


    public void run() {

        while(playAgain) {

            int numOfTurns = 1;
            int maximumTurns = 9;
            Set<Integer> pastMoves = new HashSet<>();
            System.out.println("Welcome to Tic Tac Toe!");

            System.out.print("Enter a character for player 1: ");
            Player player1 = new Player();
            player1.playerToken = scan.next();

            System.out.print("Now enter a character for player 2: ");
            Player player2 = new Player();
            player2.playerToken = scan.next();
            scan.nextLine();

            Board board = new Board();
            board.initBoard();
            System.out.println();
            board.printBoard();


            while(!isWon || !isDraw) {

                boolean validPlayer1Move = false;
                while(!validPlayer1Move) {

                    boolean isNumber = false;

                    while(!isNumber) {
                        try {
                            System.out.println("Enter a number for player 1 to play: ");
                            int player1Move = Integer.valueOf(scan.nextLine());
                            if(player1Move < 1 || player1Move > 9) {
                                throw new Exception();
                            }
                            isNumber = true;
                            if(isOccupied(pastMoves, player1Move)) {
                                board.makeMove(player1, player1Move);
                                validPlayer1Move = true;
                            } else {
                                System.out.println("That spot is taken! Choose another.");
                                System.out.println();
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Not a valid number, please try again.");
                        } catch (Exception e) {
                            System.out.println("Number must be between 1 - 9.");
                        }
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

                boolean validPlayer2Move = false;
                while(!validPlayer2Move) {

                    boolean isNumber = false;

                    while(!isNumber) {
                        try {
                            System.out.println("Enter a number for player 2 to play: ");
                            int player2Move = Integer.valueOf(scan.nextLine());
                            if(player2Move < 1 || player2Move > 9) {
                                throw new Exception();
                            }
                            isNumber = true;
                            if(isOccupied(pastMoves, player2Move)) {
                                board.makeMove(player2, player2Move);
                                validPlayer2Move = true;
                            } else {
                                System.out.println("That spot is taken! Choose another.");
                                System.out.println();
                            }
                        } catch(NumberFormatException e) {
                            System.out.println("Not a valid number, please try again.");
                        } catch(Exception e) {
                            System.out.println("Number must be between 1 - 9.");
                        }
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
            String ui = scan.nextLine().toLowerCase();
            if(ui != "y") playAgain = false;
        }

    }

    public void checkIfWon(String[][] gameBoard, Player player) {
        //rows
        if(gameBoard[0][0] == player.playerToken && gameBoard[0][1] == player.playerToken && gameBoard[0][2] ==
                player.playerToken) {
            isWon = true;
        } else if (gameBoard[1][0] == player.playerToken && gameBoard[1][1] == player.playerToken && gameBoard[1][2] ==
                player.playerToken) {
            isWon = true;
        } else if (gameBoard[2][0] == player.playerToken && gameBoard[2][1] == player.playerToken && gameBoard[2][2] ==
                player.playerToken) {
            isWon = true;
        }

        // columns
        else if (gameBoard[0][0] == player.playerToken &&gameBoard[1][0] == player.playerToken && gameBoard[2][0] ==
                player.playerToken) {
            isWon = true;
        } else if (gameBoard[0][1] == player.playerToken &&gameBoard[1][1] == player.playerToken && gameBoard[2][1] ==
                player.playerToken) {
            isWon = true;
        } else if (gameBoard[0][2] == player.playerToken &&gameBoard[1][2] == player.playerToken && gameBoard[2][2] ==
                player.playerToken) {
            isWon = true;
        }

        // diagonals
        else if (gameBoard[0][0] == player.playerToken && gameBoard[1][1] == player.playerToken && gameBoard[2][2] ==
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
