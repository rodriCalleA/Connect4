package game.conect4.views;

import game.conect4.models.Game;

abstract class WithGameView {

    protected Game game;

    WithGameView(Game game) {
        this.game = game;
    }
    
}
