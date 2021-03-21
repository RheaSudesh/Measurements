public interface Unit {
    public double dimensionInSIunits(double dimension);


    public enum UnitOfTemperature {

        Celsius("celsius", 273.15),
        Fahrenheit("fahrenheit",-32),
        Kelvin("kelvin",0);

        private final String name;
        private final double conversionFactorForSIUnit;

        UnitOfTemperature(String name,double conversionFactorForSIUnit) {
            this.name = name;
            this.conversionFactorForSIUnit = conversionFactorForSIUnit;
        }

        public double getconversionFactorForSIUnit() {
            return conversionFactorForSIUnit;
        }

        public double dimensionInKelvin(double temperatureValue) {
            if (name.equalsIgnoreCase("fahrenheit"))
                return (temperatureValue - 32) * 5 / 9 + 273.15;
            else
                return temperatureValue + this.getconversionFactorForSIUnit();
        }

    }


}
