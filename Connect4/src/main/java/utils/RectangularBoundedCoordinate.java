package utils;

import java.util.Objects;

public abstract class RectangularBoundedCoordinate {

    private Coordinate adaptee;

    public boolean isNull() {
        return this.adaptee.isNull();
    }

    protected RectangularBoundedCoordinate(int row, int column) {
        this.adaptee = new ConcreteCoordinate(row, column);

        assert this.isValid();
    }

    private boolean isValid() {
        assert !this.adaptee.isNull();

        ConcreteCoordinate concreteCoordinate = (ConcreteCoordinate) this.adaptee;
        return this.getLimits("Horizontal").isIncluded(concreteCoordinate.getRow())
                && this.getLimits("Vertical").isIncluded(concreteCoordinate.getColumn());
    }

    protected ClosedInterval getLimits(String type) {
        if (Objects.equals(type, "Horizontal")) {
            return new ClosedInterval(0, this.getDimensionHorizontal() - 1);
        } else {
            if ("Vertical".equals(type)) {
                return new ClosedInterval(0, this.getDimensionVertical() - 1);
            } else {
                return new ClosedInterval(0, this.getDimension() - 1);
            }
        }
    }

    protected abstract int getDimensionHorizontal();

    protected abstract int getDimensionVertical();

    protected abstract int getDimension();

    public int getRow() {
        assert !this.adaptee.isNull();

        return ((ConcreteCoordinate) this.adaptee).getRow();
    }

    public int getColumn() {
        assert !this.adaptee.isNull();

        return ((ConcreteCoordinate) this.adaptee).getColumn();
    }

}
