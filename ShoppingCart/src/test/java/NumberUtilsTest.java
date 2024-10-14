package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class NumberUtilsTest {

    /*
     * Testes dos números primos
     */
    @ParameterizedTest
    @ValueSource(ints = {3, 23, 311, 487, 653, 947})
    public void testIsPrimeWithPrimeNumbers(int number) {
        assertTrue(NumberUtils.isPrime(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 21, 100, 200, 300})
    public void testIsPrimeWithNonPrimeNumbers(int number) {
        assertFalse(NumberUtils.isPrime(number));
    }

    /*
     * Testes de números pares
     */
    @ParameterizedTest
    @ValueSource(ints = {32, 64, 2, 20, 30, 26})
    public void testIsEvenWithEvenNumbers(int number) {
        assertTrue(NumberUtils.isEven(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 7, 11})
    public void testIsEvenWithOddNumbers(int number) {
        assertFalse(NumberUtils.isEven(number));
    }

    /*
     * Testes de múltiplos de 23
     */
    @ParameterizedTest
    @CsvSource({"23, 23", "46, 23", "115, 23", "184, 23", "207, 23", "230, 23"})
    public void testIsMultipleWithMultiplesOf23(int number, int divisor) {
        assertTrue(NumberUtils.isMultiple(number, divisor));
    }

    @ParameterizedTest
    @CsvSource({"24, 23", "50, 23", "100, 23", "300, 23"})
    public void testIsMultipleWithNonMultiplesOf23(int number, int divisor) {
        assertFalse(NumberUtils.isMultiple(number, divisor));
    }

    /*
     * Testes com outros valores
     */
    @ParameterizedTest
    @CsvSource({"30, 5", "18, 3", "20, 10", "50, 25"})
    public void testIsMultipleWithOtherValues(int number, int divisor) {
        assertTrue(NumberUtils.isMultiple(number, divisor));
    }

    @Test
    public void testIsMultipleWithDivisorZero() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            NumberUtils.isMultiple(10, 0);
        });
        assertEquals("Can't be divided by zero!", exception.getMessage());
    }
}