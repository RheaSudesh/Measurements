public class Unit {

    public enum UnitOfLength {

        Centimeter("centimeter"), Meter("meter"), Kilometer("kilometer");

        private final String name;
        UnitOfLength(String name) {
            this.name = name;
        }

        public double dimensionInMeter(double dimensionValue) {
            if (name.equalsIgnoreCase("centimeter"))
                return dimensionValue / 100;
            else if (name.equalsIgnoreCase("kilometer"))
                return dimensionValue * 1000;
            else
                return dimensionValue;
        }
    }

    public enum UnitOfWeight {

        Gram("gram"), Kilogram("kilogram");

        private final String name;
        UnitOfWeight(String name) {
            this.name = name;
        }

        public double dimensionInKilogram(double massValue) {
            if (name.equalsIgnoreCase("gram"))
                return massValue / 1000;
            else return massValue;
        }
    }

    public enum UnitOfTemperature {

        Celsius("celsius"), Fahrenheit("fahrenheit"), Kelvin("kelvin");

        private final String name;
        UnitOfTemperature(String name) {
            this.name = name;
        }

        public double dimensionInKelvin(double temperatureValue) {
            if (name.equalsIgnoreCase("celsius"))
                return temperatureValue + 273.15;
            else if (name.equalsIgnoreCase("fahrenheit"))
                return (temperatureValue - 32)* 5/9 + 273.15 ;
            else
                return temperatureValue;
        }

    }


}
