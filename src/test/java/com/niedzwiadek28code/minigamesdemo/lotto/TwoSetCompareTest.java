package com.niedzwiadek28code.minigamesdemo.lotto;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class TwoSetCompareTest {

    @ParameterizedTest
    @MethodSource("dataProvider")
    public void should_Pass_When_TwoSetsContainsExpectedNumberOfTheSameValues(int expectedResult, Set<Integer> winningNumbers, Set<Integer> userNumbers){
            //given

            //when
        int result = TwoSetCompare.howManyNumbersContainInBothSet(
                winningNumbers,
                userNumbers);
            //then
        assertEquals(expectedResult,result);
    }
    private static Stream<Arguments> dataProvider(){
        return Stream.of(
                Arguments.of(
                        0,
                        new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)),
                        new HashSet<>(Arrays.asList(7, 11, 33, 14, 25, 76))),
                Arguments.of(
                        1,
                        new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)),
                        new HashSet<>(Arrays.asList(0, 5, 33, 14, 11, 8))),
                Arguments.of(
                        6,
                        new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)),
                        new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)))
        );
    }
}