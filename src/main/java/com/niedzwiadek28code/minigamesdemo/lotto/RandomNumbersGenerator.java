package com.niedzwiadek28code.minigamesdemo.lotto;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomNumbersGenerator {
    private final static Random random = new Random();

    public static Set<Integer> generateRandomNumbers(int howManyNumbers, int minNumber, int maxNumber){
        Set<Integer> generatedNumbers = new HashSet<>();

        while (generatedNumbers.size() < howManyNumbers){
            generatedNumbers.add(random.nextInt(maxNumber - minNumber + 1) + minNumber);
        }
        return generatedNumbers;
    }
}
