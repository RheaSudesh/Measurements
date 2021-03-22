import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class TemperatureTest {

    @Test
    public void testIf0CelsiusIsEqualTo32Fahrenheit() {
        double celsiusOfValue0 = 0;
        double fahrenheitOfValue32 = 32;
        Temperature measurementInCelsius = new Temperature(celsiusOfValue0, Temperature.UnitOfTemperature.Celsius);
        Temperature measurementInFahrenheit = new Temperature(fahrenheitOfValue32, Temperature.UnitOfTemperature.Fahrenheit);

        assertEquals(measurementInCelsius, measurementInFahrenheit);
    }

    @Test
    public void testIf32FahrenheitIsEqualTo0Celsius() {
        double celsiusOfValue0 = 273.15;
        double fahrenheitOfValue32 = 32;
        Temperature measurementInCelsius = new Temperature(celsiusOfValue0, Temperature.UnitOfTemperature.Celsius);
        Temperature measurementInFahrenheit = new Temperature(fahrenheitOfValue32, Temperature.UnitOfTemperature.Fahrenheit);

        assertEquals(measurementInCelsius, measurementInFahrenheit);
    }

    @Test
    public void testThrowsExceptionIfValueOfKelvinExceedsRange() {
        double kelvinInvalidValue = -15;

        assertThrows(IllegalArgumentException.class, () -> new Temperature(kelvinInvalidValue, Temperature.UnitOfTemperature.Kelvin));
    }

    @Test
    public void testThrowsExceptionIfValueOfCelsiusExceedsRange() {
        double celciusInvalidValue = -274.15;

        assertThrows(IllegalArgumentException.class, () -> new Temperature(celciusInvalidValue, Temperature.UnitOfTemperature.Celsius));
    }

    @Test
    public void testThrowsExceptionIfValueOfFahrenheitExceedsRange() {
        double fahrenheitInvalidValue = -460.67;

        assertThrows(IllegalArgumentException.class, () -> new Temperature(fahrenheitInvalidValue, Temperature.UnitOfTemperature.Fahrenheit));
    }

    @Test
    public void testIf32FahrenheitIsNotEqualTo1Celsius(){
        double celsiusOfValue1 = 1;
        double fahrenheitOfValue32 = 32;
        Temperature measurementInCelsius = new Temperature(celsiusOfValue1, Temperature.UnitOfTemperature.Celsius);
        Temperature measurementInFahrenheit = new Temperature(fahrenheitOfValue32, Temperature.UnitOfTemperature.Fahrenheit);

        assertNotEquals(measurementInCelsius, measurementInFahrenheit);
    }

    @Test
    public void testIf0KelvinIsEqualToMinus273Celsius()  {
        double celsiusOfValueMinus273 = -273.15;
        double kelvinOfValue0 = 0;
        Temperature measurementInCelsius = new Temperature(celsiusOfValueMinus273, Temperature.UnitOfTemperature.Celsius);
        Temperature measurementInKelvin = new Temperature(kelvinOfValue0, Temperature.UnitOfTemperature.Kelvin);

        assertEquals(measurementInCelsius, measurementInKelvin);
    }

    @Test
    public void testIfMinus273CelsiusEqualTo0kelvin() {
        double celsiusOfValueMinus273 = -273.15;
        double kelvinOfValue0 = 0;
        Temperature measurementInCelsius = new Temperature(celsiusOfValueMinus273, Temperature.UnitOfTemperature.Celsius);
        Temperature measurementInKelvin = new Temperature(kelvinOfValue0, Temperature.UnitOfTemperature.Kelvin);

        assertEquals(measurementInCelsius, measurementInKelvin);
    }

}
