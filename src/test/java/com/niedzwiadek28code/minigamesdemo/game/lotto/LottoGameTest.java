package com.niedzwiadek28code.minigamesdemo.game.lotto;

import java.util.Scanner;
import java.util.Set;
import java.util.stream.Stream;

import com.niedzwiadek28code.minigamesdemo.game.Game;
import com.niedzwiadek28code.minigamesdemo.game.lotto.config.LottoConfig;
import com.niedzwiadek28code.minigamesdemo.game.lotto.result.LottoResult;
import com.niedzwiadek28code.minigamesdemo.game.lotto.tools.RandomNumbersGenerator;
import com.niedzwiadek28code.minigamesdemo.game.lotto.tools.TwoSetCompare;
import com.niedzwiadek28code.minigamesdemo.game.lotto.tools.UserNumbersRetriever;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class LottoGameTest {
    private static final Scanner mockScanner = new Scanner(System.in);
    private static final TwoSetCompare mockSetCompare = new TwoSetCompare();
    private static final UserNumbersRetriever mockUserNumberRetriever = mock(UserNumbersRetriever.class);
    private static final RandomNumbersGenerator mockRandomGenerator = mock(RandomNumbersGenerator.class);

    @ParameterizedTest(name = "player gave {0}, random numbers were {1}, result {2}")
    @MethodSource("numberAndMessageProvider")
    void should_ReturnCorrectMessage_When_ParametersWereGiven(Set<Integer> playerGivenNumbers,
                                                              Set<Integer> randomNumbers,
                                                              String expectedMessage) {
        // given
        mockNumbers(playerGivenNumbers, randomNumbers);
        Game lottoGame = new LottoGame(mockRandomGenerator, mockUserNumberRetriever, mockSetCompare, mockScanner);
        final LottoResult lottoResult;

        // when
        lottoResult = lottoGame.play();

        // then
        assertEquals(expectedMessage, lottoResult.gameResultInfo().getGameResult());
    }

    private static Stream<Arguments> numberAndMessageProvider() {
        final Arguments arg1 = Arguments.of(Set.of(1, 2, 3, 4, 5, 6),
                Set.of(1, 2, 3, 4, 5, 6),
                "You hit 6 numbers.");

        final Arguments arg2 = Arguments.of(Set.of(1, 2, 3, 4, 5, 6),
                Set.of(6, 9, 5, 2, 11, 1),
                "You hit 4 numbers.");

        final Arguments arg3 = Arguments.of(Set.of(1, 2, 3, 4, 5, 6),
                Set.of(7, 8, 9, 10, 11, 12),
                "You hit 0 numbers.");

        final Arguments arg4 = Arguments.of(Set.of(1, 2, 3, 4, 5, 6),
                Set.of(6, 8, 9, 10, 11, 12),
                "You hit 1 numbers.");

        return Stream.of(arg1, arg2, arg3, arg4);
    }

    private void mockNumbers(Set<Integer> userNumbers, Set<Integer> generatedNumbers) {
        when(mockUserNumberRetriever.getNumbersFromUser(
                mockScanner,
                LottoConfig.NUMBER_POOL,
                LottoConfig.LOWER_RANGE,
                LottoConfig.UPPER_RANGE))
                .thenReturn(userNumbers);

        when(mockRandomGenerator.generateRandomNumbers(
                LottoConfig.NUMBER_POOL,
                LottoConfig.LOWER_RANGE,
                LottoConfig.UPPER_RANGE))
                .thenReturn(generatedNumbers);
    }
}