package game.conect4.views;

import game.conect4.models.Game;

public class GameView extends WithGameView {

    private StartView startView;
    private PlayView playView;
    private ResumeView resumeView;

    public GameView(Game game) {
        super(game);
        this.startView = new StartView(this.game);
        this.playView = new PlayView(this.game);
        this.resumeView = new ResumeView(this.game);
    }

    public void start() {
        this.startView.interact();
    }

    public void play() {
        this.playView.interact();
    }

    public boolean resume() {
        return this.resumeView.interact();
    }

}
