package game.conect4.views;

import game.conect4.types.Color;
import game.utils.views.Console;

class ColorView {

    private final String X_STRING = "\u001B[31m" + "⬤" + "\u001B[0m";
    private final String O_STRING = "\u001B[33m" + "⬤" + "\u001B[0m";
    private final String NONE_STRING = "  ";

    void write(Color color) {
        String string = color.name();
        if ("X".equals(string)) {
            Console.getInstance().write(X_STRING);

        } else if ("O".equals(string)) {
            Console.getInstance().write(O_STRING);

        } else {
            Console.getInstance().write(NONE_STRING);
        }
    }
    
}
