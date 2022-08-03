package com.niedzwiadek28code.minigamesdemo.lotto;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomNumbersGenerator {
    private final Random random = new Random();


    public Set<Integer> generateRandomNumbers(int howManyNumbers, int minNumber, int maxNumber){
        Set<Integer> generatedNumbers = new HashSet<>();
        while (generatedNumbers.size() < howManyNumbers){
            generatedNumbers.add(random.nextInt(minNumber + maxNumber));
        }
        return generatedNumbers;
    }
}
