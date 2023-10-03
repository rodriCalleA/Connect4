package game.utils.models;

public abstract class RectangularBoundedCoordinate {

    private Coordinate adaptee;

    public boolean isNull() {
        return this.adaptee.isNull();
    }

    public RectangularBoundedCoordinate(int row, int column) {
        this.adaptee = new ConcreteCoordinate(row, column);

        assert this.isValid();
    }

    public boolean isValid() {
        assert !this.adaptee.isNull();

        ConcreteCoordinate concreteCoordinate = (ConcreteCoordinate) this.adaptee;
        return this.getLimits().isIncluded(concreteCoordinate.getRow())
                && this.getLimits().isIncluded(concreteCoordinate.getColumn());
    }

    public ClosedInterval getLimits() {
        return new ClosedInterval(0, this.getDimension() - 1);
    }

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
