public class MeasurementsOfWeight extends Measurement {

    public MeasurementsOfWeight(double dimension, UnitOfWeight unit) throws IllegalArgumentException {
        super(dimension, unit);
    }

    @Override
    public Measurement createMeasurement(double dimension) {
        return new MeasurementsOfWeight(dimension, UnitOfWeight.Kilogram);
    }
}
