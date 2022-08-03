package com.niedzwiadek28code.minigamesdemo;

import com.niedzwiadek28code.minigamesdemo.lotto.Lotto;

public class MiniGamesDemoApplication {

    public static void main(String[] args) {
        Game game = new Lotto();
        game.play();
    }

}
