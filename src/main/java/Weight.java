public class Weight extends Scalar {
    public enum UnitOfWeight implements Unit {
        Gram(0.001),
        Kilogram(1);

        private final double multiplicationFactor;

        UnitOfWeight(double conversionFactorForSIUnit){
            this.multiplicationFactor = conversionFactorForSIUnit;
        }

        @Override
        public double dimensionInSIunits(double dimension) {
            return dimension * multiplicationFactor;
        }

    }

    public Weight(double dimension, UnitOfWeight unit) throws IllegalArgumentException {
        super(dimension, unit);
    }

    @Override
    public Scalar createMeasurement(double dimension) {
        return new Weight(dimension, Weight.UnitOfWeight.Kilogram);
    }
}
