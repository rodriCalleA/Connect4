package game.conect4.types;

import game.utils.models.RectangularBoundedCoordinate;

public class Coordinate extends RectangularBoundedCoordinate {


    public static final int VERTICAL_DIMENSION = 7;
    public static final int HORIZONTAL_DIMENSION = 6;

    public static final int VERTICAL_DIMENSION_1 = VERTICAL_DIMENSION-1;
    public static final int HORIZONTAL_DIMENSION_1 = HORIZONTAL_DIMENSION-1;

    public static final int NUMBER_OF_TOKENS = VERTICAL_DIMENSION * HORIZONTAL_DIMENSION;

    public Coordinate(int row, int column) {
        super(row, column);
    }

    @Override
    protected int getDimension() {
        return Coordinate.NUMBER_OF_TOKENS;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Coordinate other = (Coordinate) obj;
        if (!other.isNull()) {
            if (this.getRow() != other.getRow())
                return false;
            return this.getColumn() == other.getColumn();
        }
        return true;
    }

}
