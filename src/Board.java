public class Board {

    public String[][] gameBoard = new String[3][3];

    public void printBoard() {
        System.out.println(gameBoard[0][0] + " | " + gameBoard[0][1] + " | " + gameBoard[0][2]);
        System.out.println("---------");
        System.out.println(gameBoard[1][0] + " | " + gameBoard[1][1] + " | " + gameBoard[1][2]);
        System.out.println("---------");
        System.out.println(gameBoard[2][0] + " | " + gameBoard[2][1] + " | " + gameBoard[2][2]);
    }

    public void makeMove(Player player, int spaceChosen) {

        switch(spaceChosen -1 ) {

            case 0:
                gameBoard[0][0] = player.playerToken;
                printBoard();
                break;

            case 1:
                gameBoard[0][1] = player.playerToken;
                printBoard();
                break;

            case 2:
                gameBoard[0][2] = player.playerToken;
                printBoard();
                break;

            case 3:
                gameBoard[1][0] = player.playerToken;
                printBoard();
                break;

            case 4:
                gameBoard[1][1] = player.playerToken;
                printBoard();
                break;

            case 5:
                gameBoard[1][2] = player.playerToken;
                printBoard();
                break;

            case 6:
                gameBoard[2][0] = player.playerToken;
                printBoard();
                break;

            case 7:
                gameBoard[2][1] = player.playerToken;
                printBoard();
                break;

            case 8:
                gameBoard[2][2] = player.playerToken;
                printBoard();
                break;
        }
    }



}
