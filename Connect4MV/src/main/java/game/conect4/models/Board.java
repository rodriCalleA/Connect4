package game.conect4.models;

import game.conect4.types.Color;
import game.conect4.types.Coordinate;
import game.utils.models.Checker;

class Board {

    private final Color[][] colors;
    private final Checker checker;

    private Coordinate lastCoordinate;


    Board() {
        this.colors = new Color[Coordinate.HORIZONTAL_DIMENSION][Coordinate.VERTICAL_DIMENSION];
        this.checker = new Checker(this.colors);
        this.reset();
    }

    void reset() {
        for (int i = 0; i < Coordinate.HORIZONTAL_DIMENSION; i++) {
            for (int j = 0; j < Coordinate.VERTICAL_DIMENSION; j++) {
                this.colors[i][j] = Color.NULL;
            }
        }
    }

    void putToken(int column, Color color) {

        for (int row = Coordinate.HORIZONTAL_DIMENSION_1; row >= 0; row--) {
            if (this.colors[row][column] == Color.NULL) {
                this.colors[row][column] = color;
                this.lastCoordinate = new Coordinate(row, column);
                return;
            }
        }

    }

    Color getColor(Coordinate coordinate) {
        assert !coordinate.isNull();

        return this.colors[coordinate.getRow()][coordinate.getColumn()];
    }

    boolean isBoardFull() {
        for (int i = 0; i < Coordinate.HORIZONTAL_DIMENSION; i++) {
            if (!isColumnFull(i)) {
                return false;
            }
        }
        return true;
    }


    boolean isColumnFull(int column) {
        return this.colors[0][column] != Color.NULL;
    }

    boolean isConnect4(Color color) {
        assert color.isNotNull();

        return this.checker.checkAllDirections(color, this.lastCoordinate);
    }

    boolean end(Color color) {
        return this.isConnect4(color) || this.isBoardFull();
    }

}
