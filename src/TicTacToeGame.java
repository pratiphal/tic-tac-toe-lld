import model.board.Board;
import model.piece.PieceO;
import model.piece.PieceType;
import model.piece.PieceX;
import model.player.Player;
import util.Pair;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeGame {
    private Deque<Player> playerList;
    private Board gameBoard;

    public TicTacToeGame() {
        initializeGame();
    }

    public void initializeGame() {
        System.out.println("init. game...\n");

        playerList = new LinkedList<>();
        PieceX pieceX = new PieceX();
        Player player1 = new Player("Player1", pieceX);

        PieceO pieceO = new PieceO();
        Player player2 = new Player("Player2", pieceO);

        playerList.add(player1);
        playerList.add(player2);

        gameBoard = new Board(3);

        System.out.println("init. results " + playerList + "\n");
    }

    public String startGame() {
        boolean noWinner = true;
        int turnCount = 0;

        while (noWinner) {

            // take out the player whose turn is and also put the player in the list back
            Player playerTurn = playerList.removeFirst();
            turnCount += 1;
            if (turnCount > gameBoard.board.length * gameBoard.board.length) {
                if (gameBoard.getFreeCells().isEmpty()) {
                    break;
                }
            }

            gameBoard.printBoard();
            List<Pair<Integer, Integer>> freeSpaces = gameBoard.getFreeCells();
            if (freeSpaces.isEmpty()) {
                noWinner = false;
            }

            System.out.print("Player: " + playerTurn.getName() + " Enter row, col: ");
            Scanner scanner = new Scanner(System.in);
            String s = scanner.nextLine();
            String[] values = s.split(",");
            int inputRow = Integer.valueOf(values[0]);
            int inputCol = Integer.valueOf(values[1]);

            boolean pieceAddedSuccessfully = gameBoard.addPiece(inputRow, inputCol, playerTurn.getPlayingPiece().getPieceType());

            if (!pieceAddedSuccessfully) {
                System.out.println("\nIncorrect position, try again");
                turnCount -= 1;
                playerList.addFirst(playerTurn);
                continue;
            }

            playerList.add(playerTurn);

            if (isThereWinner(inputRow, inputCol, playerTurn.getPlayingPiece().getPieceType())) {
                return playerTurn.getName();
            }
        }
        return "Tie";
    }

    public boolean isThereWinner(int row, int col, PieceType pieceType) {

        int n = gameBoard.board.length;
        boolean rowMatch = true;
        boolean columnMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;

        //need to check in row
        for (int j = 0; j < n; j++) {

            if (gameBoard.board[row][j] == null || gameBoard.board[row][j] != pieceType) {
                rowMatch = false;
            }
        }

        for (int i = 0; i < n; i++) {

            if (gameBoard.board[i][col] == null || gameBoard.board[i][col] != pieceType) {
                columnMatch = false;
            }
        }

        for (int i = 0, j = 0; i < n && j < n; i++, j++) {

            if (gameBoard.board[i][j] == null || gameBoard.board[i][j] != pieceType) {
                diagonalMatch = false;
            }
        }

        for (int i = 0, j = n - 1; i < n && j >= 0; i++, j--) {

            if (gameBoard.board[i][j] == null || gameBoard.board[i][j] != pieceType) {
                antiDiagonalMatch = false;
            }
        }

        return rowMatch || columnMatch || diagonalMatch || antiDiagonalMatch;
    }

    public void printFinalResult() {
        System.out.println("\nFinal Result:");
        gameBoard.printBoard();
    }
}