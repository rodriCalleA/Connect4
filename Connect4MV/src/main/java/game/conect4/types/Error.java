package game.conect4.types;


public enum Error {

    IS_FULL,
    WRONG_COORDINATES,
    NULL;


    public boolean isNull() {
        return this == Error.NULL;
    }

}