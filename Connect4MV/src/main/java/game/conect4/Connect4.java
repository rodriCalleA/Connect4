package game.conect4;

import game.conect4.models.Game;
import game.conect4.views.GameView;

class Connect4 {

    private Game game;
    private GameView gameView;

    Connect4() {
        this.game = new Game();
        this.gameView = new GameView(this.game);
    }

    private void play() {
        do {
            this.gameView.start();
            this.gameView.play();
        } while (this.gameView.resume());
    }

    public static void main(String[] args) {
        new Connect4().play();
    }

}
