package com.niedzwiadek28code.minigamesdemo.game.lotto.tools;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomNumbersGenerator {
    private final Random random;

    public RandomNumbersGenerator(Random random) {
        this.random = random;
    }

    public Set<Integer> generateRandomNumbers(int howManyNumbers, int minNumber, int maxNumber) {
        Set<Integer> generatedNumbers = new HashSet<>();

        while (generatedNumbers.size() < howManyNumbers) {
            generatedNumbers.add(random.nextInt(maxNumber - minNumber + 1) + minNumber);
        }
        return generatedNumbers;
    }
}
