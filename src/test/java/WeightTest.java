import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class WeightTest {

    @Test
    public void testEqualsIsTrueFor1GramEquals1Gram() throws IllegalArgumentException {
        double weightInGram = 1;
        Weight firstMeasurement = new Weight(weightInGram, Weight.UnitOfWeight.Gram);
        Weight secondMeasurement = new Weight(weightInGram, Weight.UnitOfWeight.Gram);

        assertEquals(firstMeasurement, secondMeasurement);
    }

    @Test
    public void testEqualsIsFalseFor2GramsEquals1Gram() throws IllegalArgumentException {
        double twoGramWeight = 2;
        double oneGramWeight = 1;
        Weight firstMeasurement = new Weight(twoGramWeight, Weight.UnitOfWeight.Gram);
        Weight secondMeasurement = new Weight(oneGramWeight, Weight.UnitOfWeight.Gram);

        assertEquals(firstMeasurement, secondMeasurement);
    }

    @Test
    public void testThrowsExceptionForNegativeValuedDimension() {
        double gramWeight = -1;

        assertThrows(IllegalArgumentException.class, () -> new Weight(gramWeight, Weight.UnitOfWeight.Gram));
    }

    @Test
    public void testThrowsExceptionForZeroValuedDimension() {
        double gramWeight = 0;

        assertThrows(IllegalArgumentException.class, () -> new Weight(gramWeight, Weight.UnitOfWeight.Gram));
    }

    @Test
    public void testEqualsIsTrueForOneTenthKilogramEquals100Gram() throws IllegalArgumentException {
        double oneTenthOfkilogramWeight = 0.1;
        double hundredGramWeight = 100;
        Weight measurementInKilogram = new Weight(oneTenthOfkilogramWeight, Weight.UnitOfWeight.Kilogram);
        Weight measurementInGram = new Weight(hundredGramWeight, Weight.UnitOfWeight.Gram);

        assertEquals(measurementInGram, measurementInKilogram);
    }

    @Test
    public void testEqualsIsTrueFor100GramsEqualsOneTenthKilogram() throws IllegalArgumentException {
        double oneTenthOfkilogramWeight = 0.1;
        double hundredGramWeight = 100;
        Weight measurementInKilogram = new Weight(oneTenthOfkilogramWeight, Weight.UnitOfWeight.Kilogram);
        Weight measurementInGram = new Weight(hundredGramWeight, Weight.UnitOfWeight.Gram);

        assertEquals(measurementInGram, measurementInKilogram);
    }

    @Test
    public void testAddIs1010GramFor10GramAnd1Kilogram() throws IllegalArgumentException {
        double onekilogramWeight = 1;
        double tenGramWeight = 10;
        Weight measurementInKilogram = new Weight(onekilogramWeight, Weight.UnitOfWeight.Kilogram);
        Weight measurementInGram = new Weight(tenGramWeight, Weight.UnitOfWeight.Gram);
        Weight expectedSum = new Weight(1010, Weight.UnitOfWeight.Gram);

        Weight actualSum = measurementInKilogram.add(measurementInGram);

        assertEquals(expectedSum, actualSum);
    }

    @Test
    public void testSubtractIs1KilogramForRemoving500GramsFromOneAndAHalfKilogram() throws IllegalArgumentException {
        double oneAndAHalfkilogramWeight = 1.5;
        double fiveHundredGramWeight = 500;
        Weight measurementInKilogram = new Weight(oneAndAHalfkilogramWeight, Weight.UnitOfWeight.Kilogram);
        Weight measurementInGram = new Weight(fiveHundredGramWeight, Weight.UnitOfWeight.Gram);
        Weight expectedDifference = new Weight(1, Weight.UnitOfWeight.Kilogram);

        Weight actualDifference = measurementInKilogram.subtract(measurementInGram);

        assertEquals(expectedDifference, actualDifference);
    }

    @Test
    public void testSubtractThrowsExceptionForRemoving1GramFrom50Gram() throws IllegalArgumentException {
        double oneGramWeight = 1;
        double fiftyGramWeight = 50;
        Weight measurementOfOneGram = new Weight(oneGramWeight, Weight.UnitOfWeight.Gram);
        Weight measurementOf50Gram = new Weight(fiftyGramWeight, Weight.UnitOfWeight.Gram);

        assertThrows(IllegalArgumentException.class, () -> measurementOfOneGram.subtract(measurementOf50Gram));
    }

    @Test
    public void testSubtractThrowsExceptionForRemoving1MeterFrom1Meter() throws IllegalArgumentException {
        double fiftyGramWeight = 50;
        Weight measurementOf50Gram = new Weight(fiftyGramWeight, Weight.UnitOfWeight.Gram);

        assertThrows(IllegalArgumentException.class, () -> measurementOf50Gram.subtract(measurementOf50Gram));
    }

//    @Test
//    public void testThrowsExceptionForAdding1kilogramTo1kilometer() throws IllegalArgumentException{
//        double oneKilogram= 1, oneKilometer=1;
//        Weight measurementOf1kilogram =new Weight(oneKilogram,Weight.UnitOfWeight.Kilogram);
//        Length measurementOf1Kilometer =new Length(oneKilometer,Length.UnitOfLength.Kilometer);
//
//        assertThrows(IllegalArgumentException.class, ()->measurementOf1kilogram.add(measurementOf1Kilometer));
//
//    }

}