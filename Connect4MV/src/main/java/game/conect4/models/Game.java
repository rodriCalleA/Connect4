package game.conect4.models;

import game.conect4.types.Color;
import game.conect4.types.Coordinate;
import game.conect4.types.Error;

public class Game {

    private Board board;
    private Turn turn;

    public Game() {
        this.board = new Board();
        this.turn = new Turn(this.board);
    }

    public void reset() {
        this.board.reset();
        this.turn.reset();
    }

    public void next() {
        this.turn.next();
    }

    public Color getActiveColor() {
        return this.turn.getActiveColor();
    }

    public boolean isConnect4() {
        return this.board.isConnect4(this.turn.getActiveColor());
    }

    public boolean end() {
        return this.board.end(this.turn.getActiveColor());
    }

    public Color getColor(Coordinate coordinate) {
        return this.board.getColor(coordinate);
    }

    public boolean areAllTokensOnBoard() {
        return this.turn.areAllTokensOnBoard();
    }

    public void putToken(int column) {
        this.turn.putToken(column);
    }

    public Error getPutTokenError(int column) {
        return this.turn.getPutTokenError(column);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Game other = (Game) obj;
        if (board == null) {
            if (other.board != null)
                return false;
        } else if (!board.equals(other.board))
            return false;
        if (turn == null) {
            return other.turn == null;
        } else return turn.equals(other.turn);
    }

}
