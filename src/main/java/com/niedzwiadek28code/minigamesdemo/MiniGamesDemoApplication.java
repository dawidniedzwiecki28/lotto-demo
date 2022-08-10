package com.niedzwiadek28code.minigamesdemo;

import com.niedzwiadek28code.minigamesdemo.lotto.LottoGame;
import com.niedzwiadek28code.minigamesdemo.lotto.tools.RandomNumbersGenerator;
import com.niedzwiadek28code.minigamesdemo.lotto.tools.UserNumbersRetriever;

import java.util.Random;
import java.util.Scanner;

public class MiniGamesDemoApplication {

    public static void main(String[] args) {

        RandomNumbersGenerator numbersGenerator = new RandomNumbersGenerator(new Random());
        UserNumbersRetriever userNumbersRetriever = new UserNumbersRetriever(new Scanner(System.in));

        Game game = new LottoGame(numbersGenerator, userNumbersRetriever);
        game.play();
    }
}
