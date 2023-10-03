package game.conect4.models;

import game.conect4.types.Color;
import game.conect4.types.Coordinate;
import game.conect4.types.Error;

class Player {

    private Color color;
    private Board board;
    private int putTokens;

    Player(Color color, Board board) {
        assert color.isNotNull();
        assert board != null;

        this.color = color;
        this.board = board;
        this.putTokens = 0;
    }

    boolean areAllTokensOnBoard() {
        return this.putTokens == Coordinate.NUMBER_OF_TOKENS;
    }

    void putToken(int column) {
        assert this.putTokens < Coordinate.HORIZONTAL_DIMENSION;

        this.board.putToken(column, this.color);
        this.putTokens++;
    }

    Error getPutTokenError(int column) {
        Error error = Error.NULL;
        if (column > Coordinate.VERTICAL_DIMENSION_1 || column < 0){
            error = Error.WRONG_COORDINATES;
        }
        if (error.isNull() && this.board.isColumnFull(column)) {
            error = Error.IS_FULL;
        }
        return error;
    }

    Color getColor() {
        return this.color;
    }
    
}
