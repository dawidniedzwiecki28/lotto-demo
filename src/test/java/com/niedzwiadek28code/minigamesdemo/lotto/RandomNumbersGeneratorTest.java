package com.niedzwiadek28code.minigamesdemo.lotto;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Set;
import java.util.stream.Stream;

import static com.niedzwiadek28code.minigamesdemo.lotto.RandomNumbersGenerator.generateRandomNumbers;
import static org.junit.jupiter.api.Assertions.*;

class RandomNumbersGeneratorTest {

    @ParameterizedTest
    @MethodSource("expectedNumberOfRandomNumbersDataProvider")
    public void shouldReturnExpectedNumberOfRandomNumbers(int numberPool, int minNumber, int maxNumber) {
            // given

            // when
        Set<Integer> numbers = generateRandomNumbers(numberPool, minNumber, maxNumber);
            // then
        assertEquals(numbers.size(), numberPool);
    }
    private static Stream<Arguments> expectedNumberOfRandomNumbersDataProvider(){
        return Stream.of(
                Arguments.of(5,1,9),
                Arguments.of(0,1,7),
                Arguments.of(1,1,1),
                Arguments.of(95,1,99)
        );
    }
    @ParameterizedTest
    @MethodSource("rangeOfRandomNumbersProvider")
    public void shouldReturnTrueWhenRandomNumberIsNotLowerThanMinValue(int minNumber, int maxNumber){
            // given
        int numberPool = 1;
            // when
        Set<Integer> numbers = generateRandomNumbers(numberPool, minNumber, maxNumber);
        int temp = numbers.iterator().next();
            // then
        for(int i=0; i<100; i++) {
            assertFalse(temp < minNumber);
        }
    }
    @ParameterizedTest
    @MethodSource("rangeOfRandomNumbersProvider")
    public void shouldReturnTrueWhenRandomNumberIsNotBiggerThanMaxValue(int minNumber, int maxNumber){
            // given
        int numberPool = 1;
            // when
        Set<Integer> numbers = generateRandomNumbers(numberPool, minNumber, maxNumber);
        int temp = numbers.iterator().next();
            // then
        for(int i=0; i<100; i++) {
            assertFalse(temp > maxNumber);
        }
    }
    private static Stream<Arguments> rangeOfRandomNumbersProvider(){
        return Stream.of(
                Arguments.of(0,1),
                Arguments.of(1,1),
                Arguments.of(-6,2),
                Arguments.of(99,100),
                Arguments.of(-7,-5)
        );
    }
}