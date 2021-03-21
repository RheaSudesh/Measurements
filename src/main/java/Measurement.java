
public abstract class Measurement<T extends Measurement> {
    public double dimension;
    final Unit unit;

    public Measurement(double dimension, Unit unit) {
        if (unit.dimensionInSIunits(dimension) < 0)
            throw new IllegalArgumentException();
        this.dimension = dimension;
        this.unit = unit;
    }

    public abstract T createMeasurement(double dimension);

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        T measurement = (T) object;

        return this.unit.dimensionInSIunits(dimension) == measurement.unit.dimensionInSIunits(measurement.dimension);
    }

    public T add(T measurement) {
        double sum = this.unit.dimensionInSIunits(dimension) + measurement.unit.dimensionInSIunits(measurement.dimension);
        return createMeasurement(sum);
    }

    public T subtract(T measurement) {
        double difference = this.unit.dimensionInSIunits(dimension) - measurement.unit.dimensionInSIunits(measurement.dimension);

        try {
            return createMeasurement(difference);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Cannot Subtract larger dimension from smaller dimension");
        }

    }


}
