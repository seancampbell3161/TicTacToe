public class Board {


    public String[][] gameBoard = new String[3][3];
    private int placeholder = 1;

    public void initBoard() {
        for(int i = 0; i < gameBoard.length; i++) {
            for(int j = 0; j < gameBoard[i].length; j++) {
                gameBoard[i][j] = Integer.toString(placeholder++);
            }
        }
    }

    public void printBoard() {
        System.out.println("\t\t" + gameBoard[0][0] + " | " + gameBoard[0][1] + " | " + gameBoard[0][2]);
        System.out.println("\t\t---------");
        System.out.println("\t\t" + gameBoard[1][0] + " | " + gameBoard[1][1] + " | " + gameBoard[1][2]);
        System.out.println("\t\t---------");
        System.out.println("\t\t" + gameBoard[2][0] + " | " + gameBoard[2][1] + " | " + gameBoard[2][2]);
        System.out.println();
    }

    public void makeMove(Player player, int spaceChosen) {

        switch(spaceChosen - 1) {

            case 0:
                gameBoard[0][0] = player.playerToken;
                System.out.println();
                printBoard();
                System.out.println();
                break;

            case 1:
                gameBoard[0][1] = player.playerToken;
                System.out.println();
                printBoard();
                System.out.println();
                break;

            case 2:
                gameBoard[0][2] = player.playerToken;
                System.out.println();
                printBoard();
                System.out.println();
                break;

            case 3:
                gameBoard[1][0] = player.playerToken;
                System.out.println();
                printBoard();
                System.out.println();
                break;

            case 4:
                gameBoard[1][1] = player.playerToken;
                System.out.println();
                printBoard();
                System.out.println();
                break;

            case 5:
                gameBoard[1][2] = player.playerToken;
                System.out.println();
                printBoard();
                System.out.println();
                break;

            case 6:
                gameBoard[2][0] = player.playerToken;
                System.out.println();
                printBoard();
                System.out.println();
                break;

            case 7:
                gameBoard[2][1] = player.playerToken;
                System.out.println();
                printBoard();
                System.out.println();
                break;

            case 8:
                gameBoard[2][2] = player.playerToken;
                System.out.println();
                printBoard();
                System.out.println();
                break;
        }
    }
}
