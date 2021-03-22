
public class Temperature extends Measurement {
    public enum UnitOfTemperature implements Unit {
        Celsius(1, -273.15),
        Fahrenheit((double)5/9,- (32 * (double)5/9 ) + 273.15),
        Kelvin(1, 0);

        private final double multiplicationFactor;
        private final double additionFactor;

        UnitOfTemperature(double multiplicationFactor, double additionFactor) {
            this.multiplicationFactor = multiplicationFactor;
            this.additionFactor = additionFactor;
        }

        @Override
        public double dimensionInSIunits(double dimension) {
            return dimension * multiplicationFactor + additionFactor;
        }
    }

    public Temperature(double dimension, UnitOfTemperature unit) {
        super(dimension, unit);
    }

}
