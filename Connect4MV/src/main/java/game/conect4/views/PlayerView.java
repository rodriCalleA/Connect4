package game.conect4.views;

import game.conect4.models.Game;
import game.conect4.types.Error;
import game.utils.views.Console;

class PlayerView {

    private Game game;

    PlayerView(Game game) {
        this.game = game;
    }

    void interact() {
        if (!this.game.areAllTokensOnBoard()) {
            this.putToken();
        }
    }

    private void putToken() {
        int column;
        Console console = Console.getInstance();
        Error error;

        do {
            column = console.readInt(
                    Message.ENTER_COLUMN_TO_PUT.getPlayerColorInToString(
                            this.game.getActiveColor().getStringToken())) - 1;
            error = this.getPutTokenError(column);
        } while (!error.isNull());

        this.game.putToken(column);
    }

    private Error getPutTokenError(int column) {

        Error error = this.game.getPutTokenError(column);
        new ErrorView().writeln(error);
        return error;
    }
    
}
