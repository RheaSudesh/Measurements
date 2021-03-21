import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MeasurementsOfWeightTest {

    @Test
    public void testEqualsIsTrueFor1GramEquals1Gram() throws IllegalArgumentException {
        double weightInGram = 1;
        MeasurementsOfWeight firstMeasurement = new MeasurementsOfWeight(weightInGram, UnitOfWeight.Gram);
        MeasurementsOfWeight secondMeasurement = new MeasurementsOfWeight(weightInGram, UnitOfWeight.Gram);

        boolean actual = firstMeasurement.equals(secondMeasurement);

        assertTrue(actual);
    }

    @Test
    public void testEqualsIsFalseFor2GramsEquals1Gram() throws IllegalArgumentException {
        double twoGramWeight = 2;
        double oneGramWeight = 1;
        MeasurementsOfWeight firstMeasurement = new MeasurementsOfWeight(twoGramWeight, UnitOfWeight.Gram);
        MeasurementsOfWeight secondMeasurement = new MeasurementsOfWeight(oneGramWeight, UnitOfWeight.Gram);

        boolean actual = firstMeasurement.equals(secondMeasurement);

        assertFalse(actual);
    }

    @Test
    public void testThrowsExceptionForNegativeValuedDimension() {
        double gramWeight = -1;

        assertThrows(IllegalArgumentException.class, () -> new MeasurementsOfWeight(gramWeight, UnitOfWeight.Gram));
    }

    @Test
    public void testThrowsExceptionForZeroValuedDimension() {
        double gramWeight = 0;

        assertThrows(IllegalArgumentException.class, () -> new MeasurementsOfWeight(gramWeight, UnitOfWeight.Gram));
    }

    @Test
    public void testEqualsIsTrueForOneTenthKilogramEquals100Gram() throws IllegalArgumentException {
        double oneTenthOfkilogramWeight = 0.1;
        double hundredGramWeight = 100;
        MeasurementsOfWeight measurementInKilogram = new MeasurementsOfWeight(oneTenthOfkilogramWeight, UnitOfWeight.Kilogram);
        MeasurementsOfWeight measurementInGram = new MeasurementsOfWeight(hundredGramWeight, UnitOfWeight.Gram);

        boolean actual = measurementInKilogram.equals(measurementInGram);

        assertTrue(actual);
    }

    @Test
    public void testEqualsIsTrueFor100GramsEqualsOneTenthKilogram() throws IllegalArgumentException {
        double oneTenthOfkilogramWeight = 0.1;
        double hundredGramWeight = 100;
        MeasurementsOfWeight measurementInKilogram = new MeasurementsOfWeight(oneTenthOfkilogramWeight, UnitOfWeight.Kilogram);
        MeasurementsOfWeight measurementInGram = new MeasurementsOfWeight(hundredGramWeight, UnitOfWeight.Gram);

        System.out.println("gram " + measurementInGram.unit.dimensionInSIunits(measurementInGram.dimension) + " kilo " + measurementInKilogram.unit.dimensionInSIunits(measurementInKilogram.dimension));
        assertEquals(measurementInGram, measurementInKilogram);
    }

    @Test
    public void testAddIs1010GramFor10GramAnd1Kilogram() throws IllegalArgumentException {
        double onekilogramWeight = 1;
        double tenGramWeight = 10;
        MeasurementsOfWeight measurementInKilogram = new MeasurementsOfWeight(onekilogramWeight, UnitOfWeight.Kilogram);
        MeasurementsOfWeight measurementInGram = new MeasurementsOfWeight(tenGramWeight, UnitOfWeight.Gram);
        MeasurementsOfWeight expectedSum = new MeasurementsOfWeight(1020, UnitOfWeight.Gram);

        MeasurementsOfWeight actualSum = (MeasurementsOfWeight) measurementInKilogram.add(measurementInGram).add(measurementInGram);

        assertEquals(expectedSum, actualSum);
    }

    @Test
    public void testSubtractIs1KilogramForRemoving500GramsFromOneAndAHalfKilogram() throws IllegalArgumentException {
        double oneAndAHalfkilogramWeight = 1.5;
        double fiveHundredGramWeight = 500;
        MeasurementsOfWeight measurementInKilogram = new MeasurementsOfWeight(oneAndAHalfkilogramWeight, UnitOfWeight.Kilogram);
        MeasurementsOfWeight measurementInGram = new MeasurementsOfWeight(fiveHundredGramWeight, UnitOfWeight.Gram);
        MeasurementsOfWeight expectedDifference = new MeasurementsOfWeight(1, UnitOfWeight.Kilogram);

        MeasurementsOfWeight actualDifference = (MeasurementsOfWeight) measurementInKilogram.subtract(measurementInGram);

        assertEquals(expectedDifference, actualDifference);
    }

    @Test
    public void testSubtractThrowsExceptionForRemoving1GramFrom50Gram() throws IllegalArgumentException {
        double oneGramWeight = 1;
        double fiftyGramWeight = 50;
        MeasurementsOfWeight measurementOfOneGram = new MeasurementsOfWeight(oneGramWeight, UnitOfWeight.Gram);
        MeasurementsOfWeight measurementOf50Gram = new MeasurementsOfWeight(fiftyGramWeight, UnitOfWeight.Gram);

        assertThrows(IllegalArgumentException.class, () -> measurementOfOneGram.subtract(measurementOf50Gram));
    }

    @Test
    public void testSubtractThrowsExceptionForRemoving1MeterFrom1Meter() throws IllegalArgumentException {
        double fiftyGramWeight = 50;
        MeasurementsOfWeight measurementOf50Gram = new MeasurementsOfWeight(fiftyGramWeight, UnitOfWeight.Gram);

        assertThrows(IllegalArgumentException.class, () -> measurementOf50Gram.subtract(measurementOf50Gram));
    }


}