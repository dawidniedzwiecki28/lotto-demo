package com.niedzwiadek28code.minigamesdemo.game.lotto;

import com.niedzwiadek28code.minigamesdemo.game.Game;
import com.niedzwiadek28code.minigamesdemo.game.lotto.config.LottoMessages;
import com.niedzwiadek28code.minigamesdemo.game.lotto.result.LottoResult;
import com.niedzwiadek28code.minigamesdemo.game.lotto.tools.RandomNumbersGenerator;
import com.niedzwiadek28code.minigamesdemo.game.lotto.tools.TwoSetCompare;
import com.niedzwiadek28code.minigamesdemo.game.lotto.config.LottoConfig;
import com.niedzwiadek28code.minigamesdemo.game.lotto.result.LottoResultInfo;
import com.niedzwiadek28code.minigamesdemo.game.lotto.tools.UserNumbersRetriever;

import java.util.Scanner;
import java.util.Set;

public class LottoGame implements Game {
    TwoSetCompare setCompare;
    RandomNumbersGenerator numbersGenerator;
    UserNumbersRetriever userNumbersRetriever;
    Scanner scanner;

    public LottoGame(RandomNumbersGenerator numbersGenerator,
                     UserNumbersRetriever userNumbersRetriever,
                     TwoSetCompare setCompare,
                     Scanner scanner) {
        this.numbersGenerator = numbersGenerator;
        this.userNumbersRetriever = userNumbersRetriever;
        this.setCompare = setCompare;
        this.scanner = scanner;
    }

    @Override
    public LottoResult play() {
        System.out.println(LottoMessages.GAME_INTRODUCTION);
        System.out.println(LottoMessages.START_MESSAGE);

        final LottoResultInfo gameResultInfo = getHitNumbers();
        return getGameResult(gameResultInfo);
    }

    private LottoResultInfo getHitNumbers() {
        final Set<Integer> inputNumbers = userNumbersRetriever.getNumbersFromUser(scanner,
                LottoConfig.NUMBER_POOL,
                LottoConfig.LOWER_RANGE,
                LottoConfig.UPPER_RANGE);
        final Set<Integer> randomNumbers = numbersGenerator.generateRandomNumbers(
                LottoConfig.NUMBER_POOL,
                LottoConfig.LOWER_RANGE,
                LottoConfig.UPPER_RANGE);
        return setCompare.getHitNumbers(inputNumbers, randomNumbers);
    }

    private LottoResult getGameResult(LottoResultInfo gameResultInfo) {
        final LottoResult lottoResult = new LottoResult(this, gameResultInfo);
        System.out.println(lottoResult.gameResultInfo().getGameResult());
        return lottoResult;
    }
}
