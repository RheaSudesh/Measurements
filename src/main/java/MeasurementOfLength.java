
class MeasurementOfLength {

    private final double dimension;
    public final Unit.UnitOfLength unit;

    public MeasurementOfLength(double dimension, Unit.UnitOfLength unit) throws InvalidMeasurementException {
        if (dimension <= 0)
            throw new InvalidMeasurementException();
        this.dimension = dimension;
        this.unit = unit;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof MeasurementOfLength)) return false;
        MeasurementOfLength measurement = (MeasurementOfLength) object;

        return this.unit.dimensionInMeter(dimension) == measurement.unit.dimensionInMeter(measurement.dimension);
    }

    public MeasurementOfLength add(MeasurementOfLength measurement) throws InvalidMeasurementException {
        double sum = this.unit.dimensionInMeter(dimension) + measurement.unit.dimensionInMeter(measurement.dimension);

        return new MeasurementOfLength(sum, Unit.UnitOfLength.Meter);
    }


    public MeasurementOfLength subtract(MeasurementOfLength measurement) {
        double difference=this.unit.dimensionInMeter(dimension) - measurement.unit.dimensionInMeter(measurement.dimension);

        try {
            return new MeasurementOfLength(difference, Unit.UnitOfLength.Meter);
        } catch (InvalidMeasurementException e) {
            throw new IllegalArgumentException("Cannot Subtract larger dimension from smaller dimension");
        }

    }
}