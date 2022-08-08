package com.niedzwiadek28code.minigamesdemo.lotto;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static com.niedzwiadek28code.minigamesdemo.lotto.RandomNumbersGenerator.generateRandomNumbers;
import static org.junit.jupiter.api.Assertions.*;

class RandomNumbersGeneratorTest {

    @Test
    void should_generate_Random_Numbers(){

        // given
        int numberPool = 6, minNumber = 2, maxNumber = 10;

        // when
        Set<Integer> numbers = generateRandomNumbers(numberPool,minNumber,maxNumber);

        // then
        assertEquals(numbers.size(), numberPool);
        assertFalse(numbers.contains(minNumber-1));
        assertFalse(numbers.contains(maxNumber+1));
    }
}