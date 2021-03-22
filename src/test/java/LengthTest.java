import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LengthTest {

    @Test
    public void testEqualsIsTrueFor1CentimeterEquals1Centimeter() throws IllegalArgumentException {
        double dimension = 1;
        Length firstMeasurement = new Length(dimension, Length.UnitOfLength.Centimeter);
        Length secondMeasurement = new Length(dimension, Length.UnitOfLength.Centimeter);

        assertEquals(firstMeasurement, secondMeasurement);
    }

    @Test
    public void testEqualsIsFalseFor2CentimeterEquals1Centimeter() throws IllegalArgumentException {
        double firstDimension = 2;
        double secondDimension = 1;
        Length firstMeasurement = new Length(firstDimension, Length.UnitOfLength.Centimeter);
        Length secondMeasurement = new Length(secondDimension, Length.UnitOfLength.Centimeter);

        assertEquals(firstMeasurement, secondMeasurement);
    }

    @Test
    public void testThrowsExceptionForNegativeValuedDimension() {
        double dimension = -1;

        assertThrows(IllegalArgumentException.class, () -> new Length(dimension, Length.UnitOfLength.Centimeter));
    }

    @Test
    public void testThrowsExceptionForZeroValuedDimension() {
        double dimension = 0;

        assertThrows(IllegalArgumentException.class, () -> new Length(dimension, Length.UnitOfLength.Centimeter));
    }

    @Test
    public void testEqualsIsTrueFor1MeterEquals100Centimeter() throws IllegalArgumentException {
        double dimensionInCentimeter = 100;
        double dimensionInMeter = 1;
        Length measurementInCentimeter = new Length(dimensionInCentimeter, Length.UnitOfLength.Centimeter);
        Length measurementInMeter = new Length(dimensionInMeter, Length.UnitOfLength.Meter);

        assertEquals(measurementInCentimeter, measurementInMeter);
    }

    @Test
    public void testEqualsIsTrueFor100CentimeterEquals1Meter() throws IllegalArgumentException {
        double dimensionInCentimeter = 100;
        double dimensionInMeter = 1;
        Length measurementInCentimeter = new Length(dimensionInCentimeter, Length.UnitOfLength.Centimeter);
        Length measurementInMeter = new Length(dimensionInMeter, Length.UnitOfLength.Meter);

        assertEquals(measurementInCentimeter, measurementInMeter);
    }

    @Test
    public void testEqualsIsTrueFor100CentimeterEqualsOneThousandthKilometer() throws IllegalArgumentException {
        double dimensionInCentimeter = 100;
        double dimensionInKilometer = 0.001;
        Length measurementInCentimeter = new Length(dimensionInCentimeter, Length.UnitOfLength.Centimeter);
        Length measurementInKilometer = new Length(dimensionInKilometer, Length.UnitOfLength.Kilometer);

        assertEquals(measurementInCentimeter, measurementInKilometer);
    }

    @Test
    public void testEqualsIsTrueForOneThousandthKilometerEquals100Centimeter() throws IllegalArgumentException {
        double dimensionInCentimeter = 100;
        double dimensionInKilometer = 0.001;
        Length measurementInCentimeter = new Length(dimensionInCentimeter, Length.UnitOfLength.Centimeter);
        Length measurementInKilometer = new Length(dimensionInKilometer, Length.UnitOfLength.Kilometer);

        assertEquals(measurementInCentimeter, measurementInKilometer);
    }

    @Test
    public void testAddIs2MeterFor1MeterAnd100Centimeter() throws IllegalArgumentException {
        double dimensionInCentimeter = 100;
        double dimensionInMeter = 1;
        Length measurementInCentimeter = new Length(dimensionInCentimeter, Length.UnitOfLength.Centimeter);
        Length measurementInMeter = new Length(dimensionInMeter, Length.UnitOfLength.Meter);
        Length expected = new Length(2, Length.UnitOfLength.Meter);

        Length actual = measurementInMeter.add(measurementInCentimeter);

        assertEquals(expected, actual);
    }

    @Test
    public void testAddIs100200CentimeterFor200CentimeterAnd1Kilometer() throws IllegalArgumentException {
        double dimensionInCentimeter = 200;
        double dimensionInKilometer = 1;
        Length measurementInCentimeter = new Length(dimensionInCentimeter, Length.UnitOfLength.Centimeter);
        Length measurementInKilometer = new Length(dimensionInKilometer, Length.UnitOfLength.Kilometer);
        Length expected = new Length(100200, Length.UnitOfLength.Centimeter);

        Length actual = measurementInKilometer.add(measurementInCentimeter);

        assertEquals(expected, actual);
    }

    @Test
    public void testAddIs2KilometerFor100000CentimeterAnd1000Meter() throws IllegalArgumentException {
        double dimensionInCentimeter = 100000;
        double dimensionInMeter = 1000;
        Length measurementInCentimeter = new Length(dimensionInCentimeter, Length.UnitOfLength.Centimeter);
        Length measurementInMeter = new Length(dimensionInMeter, Length.UnitOfLength.Meter);
        Length expected = new Length(2, Length.UnitOfLength.Kilometer);

        Length actual = measurementInMeter.add(measurementInCentimeter);

        assertEquals(expected, actual);
    }

    @Test
    public void testSubtractIsHalfMeterForRemoving50CentimeterFrom1Meter() throws IllegalArgumentException {
        double dimensionInCentimeter = 50;
        double dimensionInMeter = 1;
        Length measurementInCentimeter = new Length(dimensionInCentimeter, Length.UnitOfLength.Centimeter);
        Length measurementInMeter = new Length(dimensionInMeter, Length.UnitOfLength.Meter);
        Length expected = new Length(0.5, Length.UnitOfLength.Meter);

        Length actual = measurementInMeter.subtract(measurementInCentimeter);

        assertEquals(expected, actual);
    }

    @Test
    public void testSubtractIs1900CentimeterForRemoving1MeterFrom2000Centimeter() throws IllegalArgumentException {
        double dimensionInCentimeter = 2000;
        double dimensionInMeter = 1;
        Length measurementInCentimeter = new Length(dimensionInCentimeter, Length.UnitOfLength.Centimeter);
        Length measurementInMeter = new Length(dimensionInMeter, Length.UnitOfLength.Meter);
        Length expected = new Length(1900, Length.UnitOfLength.Centimeter);

        Length actual = measurementInCentimeter.subtract(measurementInMeter);

        assertEquals(expected, actual);
    }

    @Test
    public void testSubtractThrowsExceptionForRemoving1MeterFrom50Centimeter() throws IllegalArgumentException {
        double dimensionInCentimeter = 50;
        double dimensionInMeter = 1;
        Length measurementInCentimeter = new Length(dimensionInCentimeter, Length.UnitOfLength.Centimeter);
        Length measurementInMeter = new Length(dimensionInMeter, Length.UnitOfLength.Meter);

        assertThrows(IllegalArgumentException.class, () -> measurementInCentimeter.subtract(measurementInMeter));
    }

    @Test
    public void testSubtractThrowsExceptionForRemoving1MeterFrom1Meter() throws IllegalArgumentException {
        double dimensionInMeter = 1;
        Length measurementInMeter = new Length(dimensionInMeter, Length.UnitOfLength.Meter);

        assertThrows(IllegalArgumentException.class, () -> measurementInMeter.subtract(measurementInMeter));
    }

}