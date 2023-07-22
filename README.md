# Tic Tac Toe Low Level Design

## Class

1. Piece
2. Player
3. Board

## Enum

PieceType

## My Modifications over Shrayansh's design

In Shrayansh's lecture, the player is needed to input a row, col pair-value and then since no empty cell it breaks out of the loop and returns "Tie".

This is simplified by using `turnCount` which will regularly be incremented and when it reaches `turnCount > n*n` which means all cells are filled and we could also check if there is any empty cell via `gameBoard.getFreeCells().isEmpty()` then it breaks out of the loop and returns "Tie".

> Hence simplifying input taking from user even after all cells are filled.

## Instructions to Run the Project

```bash
cd Downloads
java -jar /Users/username/Downloads/tictactoe-lld/out/artifacts/tictactoe_lld_jar/tictactoe-lld.jar
```