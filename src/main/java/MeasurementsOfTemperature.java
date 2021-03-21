import javax.naming.LimitExceededException;
import java.util.Objects;

public class MeasurementsOfTemperature {

    private final double dimension;
    private final Unit.UnitOfTemperature unit;
    public MeasurementsOfTemperature(double dimension, Unit.UnitOfTemperature unit) throws LimitExceededException {
        this.dimension=dimension;
        this.unit=unit;
        if( this.unit.dimensionInKelvin(dimension)<0)
            throw new LimitExceededException("Kelvin Value does not support negative values");
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof MeasurementsOfTemperature)) return false;
        MeasurementsOfTemperature measurement = (MeasurementsOfTemperature) object;
        System.out.println("this"+this.unit.dimensionInKelvin(dimension)+"  meas"+measurement.unit.dimensionInKelvin(measurement.dimension));
        return this.unit.dimensionInKelvin(dimension) == measurement.unit.dimensionInKelvin(measurement.dimension);
    }

}
