package com.niedzwiadek28code.minigamesdemo.lotto;

import com.niedzwiadek28code.minigamesdemo.Game;
import java.util.Scanner;

public class LottoGame implements Game {

    UserNumbersRetriever userNumbersRetriever;
    RandomNumbersGenerator generator;
    LottoService lottoService;

    LottoGame(UserNumbersRetriever userNumbersRetriever, RandomNumbersGenerator generator) {
        this.userNumbersRetriever = userNumbersRetriever;
        this.generator = generator;
        this.lottoService = new LottoService(
                new UserNumbersRetriever(new Scanner(System.in)),
                new RandomNumbersGenerator()
        );
    }


    @Override
    public GameResult play() {

        try {
            // Display introduction message
            System.out.println(LottoMessages.GAME_INTRODUCTION);
            Thread.sleep(1500);
            System.out.println(LottoMessages.START_MESSAGE);
            Thread.sleep(2000);

            // Get number from user


            NumbersRetrieverResult numbersRetrieverResult = lottoService.retrieveNumbersFromUser();

            // Display user numbers and winning numbers
            System.out.println("\nYour numbers: " + numbersRetrieverResult.userNumbers());
            System.out.println("Winning numbers: " + lottoService.getGeneratedNumbers());

            // Display game result
            System.out.println();
            System.out.printf(LottoMessages.DISPLAY_RESULT, lottoService.getGameResult());


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
