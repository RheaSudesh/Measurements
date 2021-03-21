public class MeasurementsOfWeight extends MeasurementScalar {

    public MeasurementsOfWeight(double dimension, UnitOfWeight unit) throws IllegalArgumentException {
        super(dimension, unit);
    }

    @Override
    public MeasurementScalar createMeasurement(double dimension) {
        return new MeasurementsOfWeight(dimension, UnitOfWeight.Kilogram);
    }
}
