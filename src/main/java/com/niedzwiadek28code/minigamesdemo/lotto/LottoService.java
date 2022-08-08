package com.niedzwiadek28code.minigamesdemo.lotto;

import java.util.Scanner;
import java.util.Set;

import static com.niedzwiadek28code.minigamesdemo.lotto.RandomNumbersGenerator.generateRandomNumbers;

public class LottoService {
    UserNumbersRetriever userNumbersRetriever =
            new UserNumbersRetriever(new Scanner(System.in));
    private Set<Integer> userNumbers;
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
        this.userNumbers = userNumbersRetriever.getNumbersFromUser(
                LottoConfig.NUMBER_POOL,
                LottoConfig.LOWER_RANGE,
                LottoConfig.UPPER_RANGE);
    }
    public int getGameResult(){
        return TwoSetCompare.howManyNumbersContainInBothSet(userNumbers,generatedNumbers);
    }
}
