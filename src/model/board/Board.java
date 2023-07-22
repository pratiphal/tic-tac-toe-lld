package model.board;

import model.piece.PieceType;
import util.Pair;

import java.util.ArrayList;
import java.util.List;

public class Board {
    public PieceType[][] board;
    private int size;

    public Board(int size) {
        this.size = size;
        board = new PieceType[size][size];
    }

    public void printBoard() {

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] != null) {
                    System.out.print(board[i][j].toString() + "   ");
                } else {
                    System.out.print("    ");
                }
                System.out.print(" | ");
            }
            System.out.println();
        }
    }

    public List<Pair<Integer, Integer>> getFreeCells() {
        List<Pair<Integer, Integer>> freeCells = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == null) {
                    Pair<Integer, Integer> rowColumn = new Pair<>(i, j);
                    freeCells.add(rowColumn);
                }
            }
        }

        return freeCells;
    }

    public boolean addPiece(int row, int col, PieceType pieceType) {
        if (row <= size - 1 && row >= 0 && col <= size - 1 && col >= 0) {
            if (board[row][col] != null) {
                return false;
            }
            board[row][col] = pieceType;
            return true;
        }
        return false;
    }
}