public abstract class Measurement<T extends Measurement> {
    final double dimension;
    final Unit unit;

    public interface Unit {

        double dimensionInSIunits(double dimension);
        Object getSIUnit();
    }

    public Measurement(double dimension, Unit unit) {
        double dimensionInSIunits = unit.dimensionInSIunits(dimension);
        if (dimensionInSIunits <= 0 && !(unit instanceof Temperature.UnitOfTemperature) || dimensionInSIunits < 0 && unit instanceof Temperature.UnitOfTemperature)
            throw new IllegalArgumentException();

        this.dimension = dimension;
        this.unit = unit;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Measurement)) return false;
        Measurement<T> measurement = (Measurement<T>) object;

        boolean areDimensionsSame = unit.dimensionInSIunits(dimension) == measurement.unit.dimensionInSIunits(measurement.dimension);
        boolean areMetricsSame = unit.getSIUnit() == measurement.unit.getSIUnit();

        return areDimensionsSame && areMetricsSame;
    }

}
