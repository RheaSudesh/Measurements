class Length extends Scalar<Length> {
    public enum UnitOfLength implements Unit {
        Centimeter(0.01),
        Meter(1),
        Kilometer(1000);

        private final double multiplicationFactor;

        UnitOfLength(double conversionFactorForSIUnit) {
            this.multiplicationFactor = conversionFactorForSIUnit;
        }

        @Override
        public double dimensionInSIunits(double dimension) {
            return dimension * this.multiplicationFactor;
        }

        @Override
        public Object getSIUnit() {
            return UnitOfLength.Meter;
        }

    }

    public Length(double dimension, UnitOfLength unit) throws IllegalArgumentException {
        super(dimension, unit);
    }

    @Override
    public Length createMeasurement(double dimension) {
        return new Length(dimension, Length.UnitOfLength.Meter);
    }
}