public class MeasurementsOfWeight  {

    double dimension;
    Unit.UnitOfWeight unit;
    public MeasurementsOfWeight(double dimension, Unit.UnitOfWeight unit) throws InvalidMeasurementException {
            if (dimension <= 0)
                throw new InvalidMeasurementException();
            this.dimension = dimension;
            this.unit = unit;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof MeasurementsOfWeight)) return false;
        MeasurementsOfWeight measurement = (MeasurementsOfWeight) object;

        return this.unit.dimensionInKilogram(dimension) == measurement.unit.dimensionInKilogram(measurement.dimension);
    }

    public MeasurementsOfWeight add(MeasurementsOfWeight measurement) throws InvalidMeasurementException {
        double sum = this.unit.dimensionInKilogram(dimension) + measurement.unit.dimensionInKilogram(measurement.dimension);

        return new MeasurementsOfWeight(sum, Unit.UnitOfWeight.Kilogram);
    }


    public MeasurementsOfWeight subtract(MeasurementsOfWeight measurement) throws InvalidMeasurementException {
        double difference = this.unit.dimensionInKilogram(dimension) - measurement.unit.dimensionInKilogram(measurement.dimension);

        try {
            return new MeasurementsOfWeight(difference, Unit.UnitOfWeight.Kilogram);
        } catch (InvalidMeasurementException e) {
            throw new IllegalArgumentException("Cannot Subtract larger dimension from smaller dimension");
        }
    }
}
