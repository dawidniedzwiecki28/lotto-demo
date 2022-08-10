package com.niedzwiadek28code.minigamesdemo;

import com.niedzwiadek28code.minigamesdemo.game.Game;
import com.niedzwiadek28code.minigamesdemo.game.lotto.LottoGame;
import com.niedzwiadek28code.minigamesdemo.game.lotto.tools.RandomNumbersGenerator;
import com.niedzwiadek28code.minigamesdemo.game.lotto.tools.TwoSetCompare;
import com.niedzwiadek28code.minigamesdemo.game.lotto.tools.UserNumbersRetriever;

import java.util.Random;
import java.util.Scanner;

public class MiniGamesDemoApplication {

    public static void main(String[] args) {
        Game game = prepareLottoGame();
        game.play();
    }

    private static Game prepareLottoGame() {
        RandomNumbersGenerator numbersGenerator = new RandomNumbersGenerator(new Random());
        UserNumbersRetriever userNumbersRetriever = new UserNumbersRetriever();
        TwoSetCompare setCompare = new TwoSetCompare();
        Scanner scanner = new Scanner(System.in);

        return new LottoGame(numbersGenerator, userNumbersRetriever, setCompare, scanner);
    }
}
