package com.niedzwiadek28code.minigamesdemo.lotto;

import com.niedzwiadek28code.minigamesdemo.Game;

public class LottoGame implements Game {

    LottoService lottoService = new LottoService();

    @Override
    public void play() {
        System.out.println(LottoMessages.GAME_INTRODUCTION);
        System.out.println(LottoMessages.START_MESSAGE);

        //lottoService.getNumbersFromUser();

        System.out.println("Your numbers are: " + lottoService.getUserNumbers());
        System.out.println("Winning numbers are: " + lottoService.getGeneratedNumbers());


        System.out.println(LottoMessages.DISPLAY_RESULT);

    }

}
