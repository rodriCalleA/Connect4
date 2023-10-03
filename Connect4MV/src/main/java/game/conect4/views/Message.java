package game.conect4.views;

import game.conect4.types.Coordinate;
import game.utils.views.Console;


public enum Message {
    TITLE("  ____                      _        _  _   \n" +
            " / ___|___  _ __   ___  ___| |_ __ _| || |  \n" +
            "| |   / _ \\| '_ \\ / _ \\/ __| __/ _` | || |_ \n" +
            "| |__| (_) | | | |  __/ (__| || (_| |__   _|\n" +
            " \\____\\___/|_| |_|\\___|\\___|\\__\\__,_|  |_"),
    HORIZONTAL_LINE("--------------------------------------"),
    VERTICAL_LINE(" | "),
    ENTER_COLUMN_TO_PUT("#player Enter a column to put a token (1-"+ Coordinate.VERTICAL_DIMENSION +"): " ),
    TIE("TIE"),
    PLAYER_WIN("#player player: You win!!! :-)"),
    RESUME("Do you want to continue");

    private String message;

    Message(String message) {
        this.message = message;
    }

    void write() {
        Console.getInstance().write(this.message);
    }

    void writeln() {
        Console.getInstance().writeln(this.message);
    }

    void writelnWithPlayerColor(String player) {
        Console.getInstance().writeln(getPlayerColorInToString(player));
    }

    String getPlayerColorInToString(String player) {
        return this.message.replace("#player", "" + player);
    }

    @Override
    public String toString() {
        return message;
    }
    
}
