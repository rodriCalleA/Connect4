package game.conect4.views;

import game.conect4.models.Game;
import game.utils.views.YesNoDialog;

class ResumeView extends WithGameView {

    ResumeView(Game game) {
        super(game);
    }

    boolean interact() {
        YesNoDialog isResumed = new YesNoDialog();
        isResumed.read(Message.RESUME.toString());
        if (isResumed.isAffirmative()) {
            this.game.reset();
        }
        return isResumed.isAffirmative();
    }

}
