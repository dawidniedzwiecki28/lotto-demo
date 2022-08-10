package com.niedzwiadek28code.minigamesdemo.lotto;

import com.niedzwiadek28code.minigamesdemo.Game;
import com.niedzwiadek28code.minigamesdemo.lotto.tools.RandomNumbersGenerator;
import com.niedzwiadek28code.minigamesdemo.lotto.tools.TwoSetCompare;
import com.niedzwiadek28code.minigamesdemo.lotto.tools.UserNumbersRetriever;

import java.util.Set;


public class LottoGame implements Game {
    TwoSetCompare setCompare;
    RandomNumbersGenerator numbersGenerator;
    UserNumbersRetriever userNumbersRetriever;

    public LottoGame(RandomNumbersGenerator numbersGenerator,
                     UserNumbersRetriever userNumbersRetriever) {
        this.numbersGenerator = numbersGenerator;
        this.userNumbersRetriever = userNumbersRetriever;
        this.setCompare = new TwoSetCompare();
    }

    @Override
    public void play() {
        try {
            // Display introduction message
            System.out.println(LottoMessages.GAME_INTRODUCTION);
            Thread.sleep(1500);
            System.out.println(LottoMessages.START_MESSAGE);
            Thread.sleep(2000);

            // Generate numbers
            Set<Integer> generatedNumbers = numbersGenerator.generateRandomNumbers(
                    LottoConfig.NUMBER_POOL,
                    LottoConfig.LOWER_RANGE,
                    LottoConfig.UPPER_RANGE);

            // Get number from user
            Set<Integer> userNumbers = userNumbersRetriever.getNumbersFromUser(
                    LottoConfig.NUMBER_POOL,
                    LottoConfig.LOWER_RANGE,
                    LottoConfig.UPPER_RANGE);

            // Display user numbers and winning numbers
            System.out.println("\nYour numbers: " + userNumbers);
            System.out.println("Winning numbers: " + generatedNumbers);

            // Display game result
            System.out.println();

            System.out.printf(LottoMessages.DISPLAY_RESULT, setCompare.howManyNumbersContainInBothSet(userNumbers, generatedNumbers));

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
