package connect4;

import utils.Console;

enum Color {

    X,
    O,
    NULL;

    private final String X_STRING = "\u001B[31m" + "⬤" + "\u001B[0m";
    private final String O_STRING = "\u001B[33m" + "⬤" + "\u001B[0m";
    private final String NONE_STRING = "  ";


    static Color get(int ordinal) {
        assert ordinal >= 0 && ordinal < Color.NULL.ordinal();

        return Color.values()[ordinal];
    }

    void write() {
        String string = this.name();

        if ("X".equals(string)) {
            Console.getInstance().write(X_STRING);

        } else if ("O".equals(string)) {
            Console.getInstance().write(O_STRING);

        } else {
            Console.getInstance().write(NONE_STRING);
        }

    }

    boolean isNotNull() {
        return this != Color.NULL;
    }

    String getStringToken() {
        switch (this.name()) {
            case "X":
                return X_STRING;
            case "O":
                return O_STRING;
            default:
                return NONE_STRING;
        }
    }

}
