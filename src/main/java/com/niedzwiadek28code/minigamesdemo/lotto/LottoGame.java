package com.niedzwiadek28code.minigamesdemo.lotto;

import com.niedzwiadek28code.minigamesdemo.Game;

public class LottoGame implements Game {

    LottoService lottoService = new LottoService();

    @Override
    public void play() {

        try {
            // Display introduction message
            System.out.println(LottoMessages.GAME_INTRODUCTION);
            Thread.sleep(1500);
            System.out.println(LottoMessages.START_MESSAGE);
            Thread.sleep(2000);

            // Get number from user
            lottoService.getNumbersFromUser();

            // Display user numbers and winning numbers
            System.out.println("\nYour numbers: " + lottoService.getUserNumbers());
            System.out.println("Winning numbers: " + lottoService.getGeneratedNumbers());

            // Display game result
            System.out.println();
            System.out.printf(LottoMessages.DISPLAY_RESULT, lottoService.getGameResult());

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
