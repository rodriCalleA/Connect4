package game.conect4.views;

import game.conect4.models.Game;
import game.conect4.types.Coordinate;
import game.utils.views.Console;

class BoardView {

    void write(Game game) {
        Message.HORIZONTAL_LINE.writeln();
        for (int i = 0; i < Coordinate.HORIZONTAL_DIMENSION; i++) {
            Message.VERTICAL_LINE.write();
            for (int j = 0; j < Coordinate.VERTICAL_DIMENSION; j++) {
                new ColorView().write(game.getColor(new Coordinate(i, j)));
                Message.VERTICAL_LINE.write();
            }
            Console.getInstance().writeln();
        }
        Message.HORIZONTAL_LINE.writeln();
    }

}
