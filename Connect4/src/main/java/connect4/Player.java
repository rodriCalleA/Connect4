package connect4;

import utils.Console;

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

    void play() {
        if (this.putTokens <= Coordinate.NUMBER_OF_TOKENS/2) {
            this.putToken();
        }
    }

    private void putToken() {
        int column;
        Console console = Console.getInstance();
        Error error;

        do {
            column = console.readInt(Message.ENTER_COLUMN_TO_PUT.getPlayerColorInToString(this.color.getStringToken())) - 1;
            error = this.getPutTokenError(column);
        } while (!error.isNull());

        this.board.putToken(column, this.color);
        this.putTokens++;
    }

    private Error getPutTokenError(int column) {

        Error error = Error.NULL;
        if (column > Coordinate.VERTICAL_DIMENSION_1 || column < 0){
            error = Error.WRONG_COORDINATES;
        }
        if (error.isNull() && this.board.isColumnFull(column)) {
            error = Error.IS_FULL;
        }
        error.writeln();
        return error;
    }

    void writeWinner() {
        Message.PLAYER_WIN.writelnWithPlayerColor(this.color.getStringToken());
    }

    Color getColor() {
        return this.color;
    }

}