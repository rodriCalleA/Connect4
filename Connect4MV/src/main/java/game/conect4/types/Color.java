package game.conect4.types;

public enum Color {


    X,
    O,
    NULL;

    private final String X_STRING = "\u001B[31m" + "⬤" + "\u001B[0m";
    private final String O_STRING = "\u001B[33m" + "⬤" + "\u001B[0m";
    private final String NONE_STRING = "  ";


    public static Color get(int ordinal) {
        assert ordinal >= 0 && ordinal < Color.NULL.ordinal();

        return Color.values()[ordinal];
    }

    public boolean isNotNull() {
        return this != Color.NULL;
    }

    public String getStringToken() {
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
