package com.niedzwiadek28code.minigamesdemo.lotto;

import java.util.Set;

import static com.niedzwiadek28code.minigamesdemo.lotto.RandomNumbersGenerator.generateRandomNumbers;
import static com.niedzwiadek28code.minigamesdemo.lotto.UserNumbersRetriever.getNumbersFromUser;

public class LottoService {
    private Set<Integer> userNumbers = null;
    private final Set<Integer> generatedNumbers = generateRandomNumbers(
            LottoConfig.NUMBER_POOL,
            LottoConfig.LOWER_RANGE,
            LottoConfig.UPPER_RANGE);

    public Set<Integer> getGeneratedNumbers() {
        return generatedNumbers;
    }
    public Set<Integer> getUserNumbers() {
        return userNumbers;
    }
    public void retrieveNumbersFromUser(){
        this.userNumbers = getNumbersFromUser(
                LottoConfig.NUMBER_POOL,
                LottoConfig.LOWER_RANGE,
                LottoConfig.UPPER_RANGE);
    }
    public int getGameResult(){
        int score = 0;

        for (Integer number : userNumbers){
            if(generatedNumbers.contains(number))
                score++;
        }
        return score;
    }
}
