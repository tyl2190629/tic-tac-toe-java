public abstract class Board {
	// this is the multi-dimensional array to hold the board's move choices; must be static
    public static String[][] board;
    
	// prints the game board; must be static
    public static void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}