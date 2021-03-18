public class Unit {
    public enum UnitOfLength {

        Centimeter("centimeter"),
        Meter("meter"),
        Kilometer("kilometer");

        private final String name;

        private UnitOfLength(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
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

        Gram("gram"),
        Kilogram("kilogram");

        private final String name;

        UnitOfWeight(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public double dimensionInKilogram(double massValue) {
            System.out.println("gram"+ massValue);
            if (name.equalsIgnoreCase("gram"))
                return massValue / 1000;
            else return massValue;
        }
    }


}
