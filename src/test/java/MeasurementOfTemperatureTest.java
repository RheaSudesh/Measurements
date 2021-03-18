import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MeasurementOfTemperatureTest {

    @Test
    public void testIf0CelsiusIsEqualTo32Fahrenheit(){
        double celsiusOfValue0 = 0;
        double fahrenheitOfValue32 =32;
        MeasurementsOfTemperature measurementInCelsius = new MeasurementsOfTemperature(celsiusOfValue0, Unit.UnitOfTemperature.Celsius);
        MeasurementsOfTemperature measurementInFahrenheit = new MeasurementsOfTemperature(fahrenheitOfValue32, Unit.UnitOfTemperature.Fahrenheit);

        boolean actual = measurementInCelsius.equals(measurementInFahrenheit);

        assertTrue(actual);
    }

    @Test
    public void testIf32FahrenheitIsEqualTo0Celsius(){
        double celsiusOfValue0 = 0;
        double fahrenheitOfValue32 =32;
        MeasurementsOfTemperature measurementInCelsius = new MeasurementsOfTemperature(celsiusOfValue0, Unit.UnitOfTemperature.Celsius);
        MeasurementsOfTemperature measurementInFahrenheit = new MeasurementsOfTemperature(fahrenheitOfValue32, Unit.UnitOfTemperature.Fahrenheit);

        boolean actual = measurementInFahrenheit.equals(measurementInCelsius);

        assertTrue(actual);
    }

    @Test
    public void testIf0KelvinIsEqualToMinus273Celsius(){
        double celsiusOfValueMinus273 = -273.15;
        double kelvinOfValue0 =0;
        MeasurementsOfTemperature measurementInCelsius = new MeasurementsOfTemperature(celsiusOfValueMinus273, Unit.UnitOfTemperature.Celsius);
        MeasurementsOfTemperature measurementInKelvin = new MeasurementsOfTemperature(kelvinOfValue0, Unit.UnitOfTemperature.Kelvin);

        boolean actual = measurementInKelvin.equals(measurementInCelsius);

        assertTrue(actual);
    }

    @Test
    public void testIfMinus273CelsiusEqualTo0kelvin(){
        double celsiusOfValueMinus273 = -273.15;
        double kelvinOfValue0 =0;
        MeasurementsOfTemperature measurementInCelsius = new MeasurementsOfTemperature(celsiusOfValueMinus273, Unit.UnitOfTemperature.Celsius);
        MeasurementsOfTemperature measurementInKelvin = new MeasurementsOfTemperature(kelvinOfValue0, Unit.UnitOfTemperature.Kelvin);

        boolean actual = measurementInCelsius.equals(measurementInKelvin);

        assertTrue(actual);
    }

}
