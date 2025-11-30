import java.util.*;

public class TicTacToe {
    public static Scanner in;

    public static String turn;
    
    public static void checkTurn() {
        if (turn.equals("X")) {
            turn = "O";
        } else {
            turn = "X";
        }
    }

    public static void main(String[] args) {
        in = new Scanner(System.in);
        String playAgain = "n";
        
        do {
            Board.board = new String[3][3];
            turn = "X";
            String winner = null;
            populateEmptyBoard();
            System.out.println("Welcome to Multi-Player Tic-Tac-Toe!!!");
            System.out.println("--------------------------------------");
            Board.printBoard();
            System.out.println();
            System.out.println(turn + "'s turn; Enter a space number to place " + turn + " in:");
            while (winner == null) {
                int numInput;
                
                try {
                    numInput = in.nextInt();
                    
                    if (!(numInput > 0 && numInput <= 9)) {
                        System.out.println("Error: Re-enter slot number:");
                        continue;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("InputMismatchException: Re-enter slot number:");
                    in.nextLine();
                    continue;
                }
                
                System.out.println();
                System.out.println(turn + "'s turn; Enter a space number to place " + turn + " in:");
                
                if (numInput == 1 && Board.board[0][0].equals("1")) {
                    Board.board[0][0] = turn;
                } else if (numInput == 2 && Board.board[0][1].equals("2")) {
                    Board.board[0][1] = turn;
                } else if (numInput == 3 && Board.board[0][2].equals("3")) {
                    Board.board[0][2] = turn;
                } else if (numInput == 4 && Board.board[1][0].equals("4")) {
                    Board.board[1][0] = turn;
                } else if (numInput == 5 && Board.board[1][1].equals("5")) {
                    Board.board[1][1] = turn;
                } else if (numInput == 6 && Board.board[1][2].equals("6")) {
                    Board.board[1][2] = turn;
                } else if (numInput == 7 && Board.board[2][0].equals("7")) {
                    Board.board[2][0] = turn;
                } else if (numInput == 8 && Board.board[2][1].equals("8")) {
                    Board.board[2][1] = turn;
                } else if (numInput == 9 && Board.board[2][2].equals("9")) {
                    Board.board[2][2] = turn;
                } else {
                    System.out.println("Slot already taken; re-enter slot number:");
                    continue;
                }
                checkTurn();
                Board.printBoard();
                System.out.println();
                winner = checkWinner();
                
            }
            
            System.out.println();
            
            if (winner.equalsIgnoreCase("draw")) {
                System.out.println("It's a draw! Thanks for playing.");
            } else {
                System.out.println("Congratulations! " + winner + "'s have won! Thanks for playing.");
            }
            
            System.out.println();
            System.out.println("Do you want to play again? (y/n)");
            playAgain = in.next();
        } while (playAgain.equalsIgnoreCase("y"));
    }

    

    public static String checkWinner() {
        for (int i = 0; i < 8; i++) {
            String line = null;
            
            switch (i) {
                case 0:
                    line = Board.board[0][0] + Board.board[0][1] + Board.board[0][2];
                    break;
                case 1:
                    line = Board.board[1][0] + Board.board[1][1] + Board.board[1][2];
                    break;
                case 2:
                    line = Board.board[2][0] + Board.board[2][1] + Board.board[2][2];
                    break;
                case 3:
                    line = Board.board[0][0] + Board.board[1][0] + Board.board[2][0];
                    break;
                case 4:
                    line = Board.board[0][1] + Board.board[1][1] + Board.board[2][1];
                    break;
                case 5:
                    line = Board.board[0][2] + Board.board[1][2] + Board.board[2][2];
                    break;
                case 6:
                    line = Board.board[0][0] + Board.board[1][1] + Board.board[2][2];
                    break;
                case 7:
                    line = Board.board[0][2] + Board.board[1][1] + Board.board[2][0];
                    break;
            }
            
            if (line.equals("XXX")) {
                return "X";
            } else if (line.equals("OOO")) {
                return "O";
            }
        }
        
        for (int i = 0; i < 9; i++) {
            if (Arrays.asList(Board.board[0]).contains(String.valueOf(i + 1))) {
                break;
            } else if (Arrays.asList(Board.board[1]).contains(String.valueOf(i + 1))) {
                break;
            } else if (Arrays.asList(Board.board[2]).contains(String.valueOf(i + 1))) {
                break;
            } else if (i == 8) {
                return "draw";
            }
        }
        
        System.out.println();
        System.out.println(turn + "'s turn; Enter a space number to place " + turn + " in:");
        return null;
    }

    public static void populateEmptyBoard() {
        int num = 1;
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Board.board[i][j] = String.valueOf(num);
                num++;
            }
        }
    }
}
