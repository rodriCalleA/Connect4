package game.conect4.views;

import game.conect4.types.Error;
import game.utils.views.Console;

class ErrorView {

    static final String[] MESSAGES = {
            "The column is full",
            "The coordinates are wrong",
            "NULL"
    };

    void writeln(Error error) {
        if (!error.isNull()) {
            Console.getInstance().writeln(ErrorView.MESSAGES[error.ordinal()]);
        }
    }

}
