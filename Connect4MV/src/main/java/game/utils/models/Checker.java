package game.utils.models;

import game.conect4.types.Color;
import game.conect4.types.Coordinate;

public class Checker {

    private final Color[][] colors;

    public Checker(Color[][] colors) {
        this.colors = colors;
    }

    public boolean checkAllDirections(Color color, Coordinate lastCoordinate) {
        return checkHorizontal(color, lastCoordinate.getRow())
                || checkVertical(color, lastCoordinate.getColumn())
                || checkDiagonalRight(color, lastCoordinate)
                || checkDiagonalLeft(color, lastCoordinate);
    }

    private boolean checkHorizontal(Color color, int row) {
        for (int j = 0; j < Coordinate.VERTICAL_DIMENSION; j++) {
            if (j + 3 < Coordinate.VERTICAL_DIMENSION &&
                    colors[row][j] == color &&
                    colors[row][j + 1] == color &&
                    colors[row][j + 2] == color &&
                    colors[row][j + 3] == color) {
                return true;
            }
        }
        return false;
    }

    private boolean checkVertical(Color color, int column) {
        for (int i = 0; i < Coordinate.HORIZONTAL_DIMENSION; i++) {
            if (i + 3 < Coordinate.HORIZONTAL_DIMENSION &&
                    colors[i][column] == color &&
                    colors[i + 1][column] == color &&
                    colors[i + 2][column] == color &&
                    colors[i + 3][column] == color) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonalRight(Color color, Coordinate lastCoordinate) {

        int i = lastCoordinate.getRow();
        int j = lastCoordinate.getColumn();

        while (i < Coordinate.HORIZONTAL_DIMENSION_1 && j > 0) {
            i++;
            j--;
        }

        while (i - 3 >= 0 && j + 3 < Coordinate.VERTICAL_DIMENSION) {
            if (colors[i][j] == color &&
                    colors[i - 1][j + 1] == color &&
                    colors[i - 2][j + 2] == color &&
                    colors[i - 3][j + 3] == color) {
                return true;
            }
            i--;
            j++;
        }
        return false;
    }

    private boolean checkDiagonalLeft(Color color, Coordinate lastCoordinate) {

        int i = lastCoordinate.getRow();
        int j = lastCoordinate.getColumn();

        while (i > 0 && j > 0) {
            i--;
            j--;
        }

        while (i + 3 < Coordinate.HORIZONTAL_DIMENSION && j + 3 < Coordinate.VERTICAL_DIMENSION) {
            if (colors[i][j] == color &&
                    colors[i + 1][j + 1] == color &&
                    colors[i + 2][j + 2] == color &&
                    colors[i + 3][j + 3] == color) {
                return true;
            }
            i++;
            j++;
        }
        return false;
    }

}