package com.niedzwiadek28code.minigamesdemo.lotto;

import java.util.Set;

public class LottoService {
    UserNumbersRetriever userNumbersRetriever;
    RandomNumbersGenerator generator;

    LottoService(UserNumbersRetriever userNumbersRetriever, RandomNumbersGenerator generator) {
        this.userNumbersRetriever = userNumbersRetriever;
        this.generator = generator;
    }

    private final Set<Integer> generatedNumbers = generator.generateRandomNumbers(
            LottoConfig.NUMBER_POOL,
            LottoConfig.LOWER_RANGE,
            LottoConfig.UPPER_RANGE);

    public Set<Integer> getGeneratedNumbers() {
        return generatedNumbers;
    }

    public NumbersRetrieverResult retrieveNumbersFromUser() {
        return userNumbersRetriever.getNumbersFromUser(
                LottoConfig.NUMBER_POOL,
                LottoConfig.LOWER_RANGE,
                LottoConfig.UPPER_RANGE);
    }

    public int getGameResult() {
        return TwoSetCompare.howManyNumbersContainInBothSet(userNumbers, generatedNumbers);
    }
}
