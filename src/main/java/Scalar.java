public abstract class Scalar <T extends Scalar> extends Measurement {

    public Scalar(double dimension, Unit unit) {
        super(dimension, unit);
    }

    public abstract T createMeasurement(double dimension);

    public T add(T measurement) {
        double sum = this.unit.dimensionInSIunits(dimension) + measurement.unit.dimensionInSIunits(measurement.dimension);
        return (T) createMeasurement(sum);
    }

    public T subtract(T measurement) {
        double difference = this.unit.dimensionInSIunits(dimension) - measurement.unit.dimensionInSIunits(measurement.dimension);

        try {
            return (T) createMeasurement(difference);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Cannot Subtract larger dimension from smaller dimension");
        }
    }
}
