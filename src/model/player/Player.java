package model.player;

import model.piece.Piece;

public class Player {
    private String name;

    private Piece playingPiece;

    public Player(String name, Piece playingPiece) {
        this.name = name;
        this.playingPiece = playingPiece;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Piece getPlayingPiece() {
        return playingPiece;
    }

    public void setPlayingPiece(Piece playingPiece) {
        this.playingPiece = playingPiece;
    }
}