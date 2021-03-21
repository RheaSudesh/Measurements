
class MeasurementOfLength extends MeasurementScalar {

    public MeasurementOfLength(double dimension, UnitOfLength unit) throws IllegalArgumentException {
        super(dimension, unit);
    }

    @Override
    public MeasurementOfLength createMeasurement(double dimension) {
        return new MeasurementOfLength(dimension, UnitOfLength.Meter);
    }
}