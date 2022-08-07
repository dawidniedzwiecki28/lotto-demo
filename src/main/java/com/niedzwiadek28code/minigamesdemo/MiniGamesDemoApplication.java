package com.niedzwiadek28code.minigamesdemo;

import com.niedzwiadek28code.minigamesdemo.lotto.LottoGame;

public class MiniGamesDemoApplication {

    public static void main(String[] args) {
        Game game = new LottoGame();
        game.play();

    }
}
