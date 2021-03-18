import javax.naming.LimitExceededException;
import java.util.Objects;

public class MeasurementsOfTemperature {

    private final double dimension;
    private final Unit.UnitOfTemperature unit;
    public MeasurementsOfTemperature(double dimension, Unit.UnitOfTemperature unit) throws LimitExceededException {
        this.dimension=dimension;
        this.unit=unit;
        if( this.unit.dimensionInKelvin(dimension)<1000 || this.unit.dimensionInKelvin(dimension)>10000 )
            throw new LimitExceededException("Kelvin Value should be in the range of 1000 to 10000");
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof MeasurementsOfTemperature)) return false;
        MeasurementsOfTemperature measurement = (MeasurementsOfTemperature) object;
        return this.unit.dimensionInKelvin(dimension) == measurement.unit.dimensionInKelvin(measurement.dimension);
    }

}
