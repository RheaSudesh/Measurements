
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MeasurementOfLengthTest {

    @Test
    public void testEqualsIsTrueFor1CentimeterEquals1Centimeter() throws InvalidMeasurementException {
        double dimension = 1;
        MeasurementOfLength firstMeasurement = new MeasurementOfLength(dimension, Unit.UnitOfLength.Centimeter);
        MeasurementOfLength secondMeasurement = new MeasurementOfLength(dimension, Unit.UnitOfLength.Centimeter);

        boolean actual = firstMeasurement.equals(secondMeasurement);

        assertTrue(actual);
    }

    @Test
    public void testEqualsIsFalseFor2CentimeterEquals1Centimeter() throws InvalidMeasurementException {
        double firstDimension = 2;
        double secondDimension = 1;
        MeasurementOfLength firstMeasurement = new MeasurementOfLength(firstDimension, Unit.UnitOfLength.Centimeter);
        MeasurementOfLength secondMeasurement = new MeasurementOfLength(secondDimension, Unit.UnitOfLength.Centimeter);

        boolean actual = firstMeasurement.equals(secondMeasurement);

        assertFalse(actual);
    }

    @Test
    public void testEqualsIsFalseForNonMeasurementInstance() throws InvalidMeasurementException {
        double dimension = 1;
        MeasurementOfLength firstMeasurement = new MeasurementOfLength(dimension, Unit.UnitOfLength.Centimeter);
        Integer secondMeasurement = 1;

        boolean actual = firstMeasurement.equals(secondMeasurement);

        assertFalse(actual);
    }

    @Test
    public void testEqualsIsTrueForSameMeasurementInstance() throws InvalidMeasurementException {
        double dimension = 1;
        MeasurementOfLength measurement = new MeasurementOfLength(dimension, Unit.UnitOfLength.Centimeter);

        boolean actual = measurement.equals(measurement);

        assertTrue(actual);
    }

    @Test
    public void testThrowsExceptionForNegativeValuedDimension() {
        double dimension = -1;

        assertThrows(InvalidMeasurementException.class, () -> new MeasurementOfLength(dimension, Unit.UnitOfLength.Centimeter));
    }

    @Test
    public void testThrowsExceptionForZeroValuedDimension() {
        double dimension = 0;

        assertThrows(InvalidMeasurementException.class, () -> new MeasurementOfLength(dimension, Unit.UnitOfLength.Centimeter));
    }

    @Test
    public void testEqualsIsTrueFor1MeterEquals100Centimeter() throws InvalidMeasurementException {
        double dimensionInCentimeter = 100;
        double dimensionInMeter = 1;
        MeasurementOfLength measurementInCentimeter = new MeasurementOfLength(dimensionInCentimeter, Unit.UnitOfLength.Centimeter);
        MeasurementOfLength measurementInMeter = new MeasurementOfLength(dimensionInMeter, Unit.UnitOfLength.Meter);

        boolean actual = measurementInCentimeter.equals(measurementInMeter);

        assertTrue(actual);
    }

    @Test
    public void testEqualsIsTrueFor100CentimeterEquals1Meter() throws InvalidMeasurementException {
        double dimensionInCentimeter = 100;
        double dimensionInMeter = 1;
        MeasurementOfLength measurementInCentimeter = new MeasurementOfLength(dimensionInCentimeter, Unit.UnitOfLength.Centimeter);
        MeasurementOfLength measurementInMeter = new MeasurementOfLength(dimensionInMeter, Unit.UnitOfLength.Meter);

        boolean actual = measurementInMeter.equals(measurementInCentimeter);

        assertTrue(actual);
    }

    @Test
    public void testEqualsIsTrueFor100CentimeterEqualsOneThousandthKilometer() throws InvalidMeasurementException {
        double dimensionInCentimeter = 100;
        double dimensionInKilometer = 0.001;
        MeasurementOfLength measurementInCentimeter = new MeasurementOfLength(dimensionInCentimeter, Unit.UnitOfLength.Centimeter);
        MeasurementOfLength measurementInKilometer = new MeasurementOfLength(dimensionInKilometer, Unit.UnitOfLength.Kilometer);

        boolean actual = measurementInCentimeter.equals(measurementInKilometer);

        assertTrue(actual);
    }

    @Test
    public void testEqualsIsTrueForOneThousandthKilometerEquals100Centimeter() throws InvalidMeasurementException {
        double dimensionInCentimeter = 100;
        double dimensionInKilometer = 0.001;
        MeasurementOfLength measurementInCentimeter = new MeasurementOfLength(dimensionInCentimeter, Unit.UnitOfLength.Centimeter);
        MeasurementOfLength measurementInKilometer = new MeasurementOfLength(dimensionInKilometer, Unit.UnitOfLength.Kilometer);

        boolean actual = measurementInKilometer.equals(measurementInCentimeter);

        assertTrue(actual);
    }

    @Test
    public void testAddIs2MeterFor1MeterAnd100Centimeter() throws InvalidMeasurementException {
        double dimensionInCentimeter = 100;
        double dimensionInMeter = 1;
        MeasurementOfLength measurementInCentimeter = new MeasurementOfLength(dimensionInCentimeter, Unit.UnitOfLength.Centimeter);
        MeasurementOfLength measurementInMeter = new MeasurementOfLength(dimensionInMeter, Unit.UnitOfLength.Meter);
        MeasurementOfLength expected = new MeasurementOfLength(2, Unit.UnitOfLength.Meter);

        MeasurementOfLength actual = measurementInMeter.add(measurementInCentimeter);
        assertEquals(expected, actual);
    }

    @Test
    public void testAddIs100200CentimeterFor200CentimeterAnd1Kilometer() throws InvalidMeasurementException {
        double dimensionInCentimeter = 200;
        double dimensionInKilometer = 1;
        MeasurementOfLength measurementInCentimeter = new MeasurementOfLength(dimensionInCentimeter, Unit.UnitOfLength.Centimeter);
        MeasurementOfLength measurementInKilometer = new MeasurementOfLength(dimensionInKilometer, Unit.UnitOfLength.Kilometer);
        MeasurementOfLength expected = new MeasurementOfLength(100200, Unit.UnitOfLength.Centimeter);

        MeasurementOfLength actual = measurementInKilometer.add(measurementInCentimeter);

        assertEquals(expected, actual);
    }

    @Test
    public void testAddIs2KilometerFor100000CentimeterAnd1000Meter() throws InvalidMeasurementException {
        double dimensionInCentimeter = 100000;
        double dimensionInMeter = 1000;
        MeasurementOfLength measurementInCentimeter = new MeasurementOfLength(dimensionInCentimeter, Unit.UnitOfLength.Centimeter);
        MeasurementOfLength measurementInMeter = new MeasurementOfLength(dimensionInMeter, Unit.UnitOfLength.Meter);
        MeasurementOfLength expected = new MeasurementOfLength(2, Unit.UnitOfLength.Kilometer);

        MeasurementOfLength actual = measurementInMeter.add(measurementInCentimeter);

        assertEquals(expected, actual);
    }

    @Test
    public void testSubtractIsHalfMeterForRemoving50CentimeterFrom1Meter() throws InvalidMeasurementException {
        double dimensionInCentimeter = 50;
        double dimensionInMeter = 1;
        MeasurementOfLength measurementInCentimeter = new MeasurementOfLength(dimensionInCentimeter, Unit.UnitOfLength.Centimeter);
        MeasurementOfLength measurementInMeter = new MeasurementOfLength(dimensionInMeter, Unit.UnitOfLength.Meter);
        MeasurementOfLength expected = new MeasurementOfLength(0.5, Unit.UnitOfLength.Meter);

        MeasurementOfLength actual = measurementInMeter.subtract(measurementInCentimeter);

        assertEquals(expected, actual);
    }

    @Test
    public void testSubtractIs1900CentimeterForRemoving1MeterFrom2000Centimeter() throws InvalidMeasurementException {
        double dimensionInCentimeter = 2000;
        double dimensionInMeter = 1;
        MeasurementOfLength measurementInCentimeter = new MeasurementOfLength(dimensionInCentimeter, Unit.UnitOfLength.Centimeter);
        MeasurementOfLength measurementInMeter = new MeasurementOfLength(dimensionInMeter, Unit.UnitOfLength.Meter);
        MeasurementOfLength expected = new MeasurementOfLength(1900, Unit.UnitOfLength.Centimeter);

        MeasurementOfLength actual = measurementInCentimeter.subtract(measurementInMeter);

        assertEquals(expected, actual);
    }

    @Test
    public void testSubtractThrowsExceptionForRemoving1MeterFrom50Centimeter() throws InvalidMeasurementException {
        double dimensionInCentimeter = 50;
        double dimensionInMeter = 1;
        MeasurementOfLength measurementInCentimeter = new MeasurementOfLength(dimensionInCentimeter, Unit.UnitOfLength.Centimeter);
        MeasurementOfLength measurementInMeter = new MeasurementOfLength(dimensionInMeter, Unit.UnitOfLength.Meter);

        assertThrows(IllegalArgumentException.class, () -> measurementInCentimeter.subtract(measurementInMeter));
    }

    @Test
    public void testSubtractThrowsExceptionForRemoving1MeterFrom1Meter() throws InvalidMeasurementException {
        double dimensionInMeter = 1;
        MeasurementOfLength measurementInMeter = new MeasurementOfLength(dimensionInMeter, Unit.UnitOfLength.Meter);

        assertThrows(IllegalArgumentException.class, () -> measurementInMeter.subtract(measurementInMeter));
    }

}