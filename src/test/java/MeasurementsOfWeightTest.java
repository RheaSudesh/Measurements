import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MeasurementsOfWeightTest {

    @Test
    public void testEqualsIsTrueFor1GramEquals1Gram() throws InvalidMeasurementException {
        double weightInGram = 1;
        MeasurementsOfWeight firstMeasurement = new MeasurementsOfWeight(weightInGram, Unit.UnitOfWeight.Gram);
        MeasurementsOfWeight secondMeasurement = new MeasurementsOfWeight(weightInGram, Unit.UnitOfWeight.Gram);

        boolean actual = firstMeasurement.equals(secondMeasurement);

        assertTrue(actual);
    }

    @Test
    public void testEqualsIsFalseFor2GramsEquals1Gram() throws InvalidMeasurementException {
        double twoGramWeight = 2;
        double oneGramWeight = 1;
        MeasurementsOfWeight firstMeasurement = new MeasurementsOfWeight(twoGramWeight, Unit.UnitOfWeight.Gram);
        MeasurementsOfWeight secondMeasurement = new MeasurementsOfWeight(oneGramWeight, Unit.UnitOfWeight.Gram);

        boolean actual = firstMeasurement.equals(secondMeasurement);

        assertFalse(actual);
    }

    @Test
    public void testThrowsExceptionForNegativeValuedDimension() {
        double gramWeight=-1;

        assertThrows(InvalidMeasurementException.class, () -> new MeasurementsOfWeight(gramWeight, Unit.UnitOfWeight.Gram));
    }

    @Test
    public void testThrowsExceptionForZeroValuedDimension() {
        double gramWeight=0;

        assertThrows(InvalidMeasurementException.class, () -> new MeasurementsOfWeight(gramWeight, Unit.UnitOfWeight.Gram));
    }

    @Test
    public void testEqualsIsTrueForOneTenthKilogramEquals100Gram() throws InvalidMeasurementException {
        double oneTenthOfkilogramWeight=0.1;
        double hundredGramWeight = 100;
        MeasurementsOfWeight measurementInKilogram = new MeasurementsOfWeight(oneTenthOfkilogramWeight, Unit.UnitOfWeight.Kilogram);
        MeasurementsOfWeight measurementInGram = new MeasurementsOfWeight(hundredGramWeight, Unit.UnitOfWeight.Gram);

        boolean actual = measurementInKilogram.equals(measurementInGram);

        assertTrue(actual);
    }

    @Test
    public void testEqualsIsTrueFor100GramsEqualsOneTenthKilogram() throws InvalidMeasurementException {
        double oneTenthOfkilogramWeight=0.1;
        double hundredGramWeight = 100;
        MeasurementsOfWeight measurementInKilogram = new MeasurementsOfWeight(oneTenthOfkilogramWeight, Unit.UnitOfWeight.Kilogram);
        MeasurementsOfWeight measurementInGram = new MeasurementsOfWeight(hundredGramWeight, Unit.UnitOfWeight.Gram);

        boolean actual = measurementInGram.equals(measurementInKilogram);

        assertTrue(actual);
    }

    @Test
    public void testAddIs1010GramFor10GramAnd1Kilogram() throws InvalidMeasurementException {
        double onekilogramWeight=1;
        double tenGramWeight = 10;
        MeasurementsOfWeight measurementInKilogram = new MeasurementsOfWeight(onekilogramWeight, Unit.UnitOfWeight.Kilogram);
        MeasurementsOfWeight measurementInGram = new MeasurementsOfWeight(tenGramWeight, Unit.UnitOfWeight.Gram);
        MeasurementsOfWeight expectedSum = new MeasurementsOfWeight(1020, Unit.UnitOfWeight.Gram);

        MeasurementsOfWeight actualSum = measurementInKilogram.add(measurementInGram).add(measurementInGram);

        assertEquals(expectedSum, actualSum);
    }

    @Test
    public void testSubtractIs1KilogramForRemoving500GramsFromOneAndAHalfKilogram() throws InvalidMeasurementException {
        double oneAndAHalfkilogramWeight=1.5;
        double fiveHundredGramWeight = 500;
        MeasurementsOfWeight measurementInKilogram = new MeasurementsOfWeight(oneAndAHalfkilogramWeight, Unit.UnitOfWeight.Kilogram);
        MeasurementsOfWeight measurementInGram = new MeasurementsOfWeight(fiveHundredGramWeight, Unit.UnitOfWeight.Gram);
        MeasurementsOfWeight expectedDifference = new MeasurementsOfWeight(1, Unit.UnitOfWeight.Kilogram);

        MeasurementsOfWeight actualDifference = measurementInKilogram.subtract(measurementInGram);

        assertEquals(expectedDifference, actualDifference);
    }

    @Test
    public void testSubtractThrowsExceptionForRemoving1GramFrom50Gram() throws InvalidMeasurementException {
        double oneGramWeight = 1;
        double fiftyGramWeight = 50;
        MeasurementsOfWeight measurementOfOneGram = new MeasurementsOfWeight(oneGramWeight, Unit.UnitOfWeight.Gram);
        MeasurementsOfWeight measurementOf50Gram = new MeasurementsOfWeight(fiftyGramWeight, Unit.UnitOfWeight.Gram);

        assertThrows(IllegalArgumentException.class, () -> measurementOfOneGram.subtract(measurementOf50Gram));
    }

    @Test
    public void testSubtractThrowsExceptionForRemoving1MeterFrom1Meter() throws InvalidMeasurementException {
        double fiftyGramWeight = 50;
        MeasurementsOfWeight measurementOf50Gram = new MeasurementsOfWeight(fiftyGramWeight, Unit.UnitOfWeight.Gram);

        assertThrows(IllegalArgumentException.class, () -> measurementOf50Gram.subtract(measurementOf50Gram));
    }


}