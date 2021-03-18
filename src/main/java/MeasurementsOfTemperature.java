import java.util.Objects;

public class MeasurementsOfTemperature {

    private final double dimension;
    private final Unit.UnitOfTemperature unit;
    public MeasurementsOfTemperature(double dimension, Unit.UnitOfTemperature unit) {
        this.dimension=dimension;
        this.unit=unit;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof MeasurementsOfTemperature)) return false;
        MeasurementsOfTemperature measurement = (MeasurementsOfTemperature) object;
        return this.unit.dimensionInKelvin(dimension) == measurement.unit.dimensionInKelvin(measurement.dimension);
    }

}
