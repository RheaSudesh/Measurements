
public class MeasurementsOfTemperature extends Measurement {

    public MeasurementsOfTemperature(double dimension, UnitOfTemperature unit) {
        super(dimension, unit);
    }

    @Override
    public MeasurementsOfTemperature createMeasurement(double dimension) {
        return new MeasurementsOfTemperature(dimension, UnitOfTemperature.Kelvin);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof MeasurementsOfTemperature)) return false;
        MeasurementsOfTemperature measurement = (MeasurementsOfTemperature) object;

        return this.unit.dimensionInSIunits(dimension) == measurement.unit.dimensionInSIunits(measurement.dimension);
    }

}
