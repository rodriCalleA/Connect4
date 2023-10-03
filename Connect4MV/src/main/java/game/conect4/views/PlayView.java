package game.conect4.views;

import game.conect4.models.Game;

class PlayView extends WithGameView {

    PlayView(Game game) {
        super(game);
    }

    void interact() {
        do {
            new PlayerView(this.game).interact();
            this.game.next();
            new BoardView().write(this.game);
        } while (!this.game.end());

        if(this.game.isConnect4()){
            Message.PLAYER_WIN.writelnWithPlayerColor(this.game.getActiveColor().getStringToken());
        } else {
            Message.TIE.writeln();
        }
    }

}
