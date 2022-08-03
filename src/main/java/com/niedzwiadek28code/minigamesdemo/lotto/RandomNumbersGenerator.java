package com.niedzwiadek28code.minigamesdemo.lotto;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomNumbersGenerator {
    private final Random random = new Random();


    public Set<Integer> generateRandomNumbers(int howManyNumbers, int minNumber, int maxNumber){
        Set<Integer> generatedNumbers = new HashSet<>();
        while (generatedNumbers.size() < howManyNumbers){
            int temp = random.nextInt(minNumber + maxNumber);
            if (isNumberFromRange(temp, minNumber, maxNumber)){
                generatedNumbers.add(temp);
            }
        }
        return generatedNumbers;

    }
    private boolean isNumberFromRange(int number, int minValue, int maxValue){
        return number >= minValue || number <= maxValue;
    }
}
