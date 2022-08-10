package com.niedzwiadek28code.minigamesdemo.game.lotto.lotto;

import com.niedzwiadek28code.minigamesdemo.game.lotto.tools.UserNumbersRetriever;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class UserNumbersRetrieverTest {

    @ParameterizedTest
    @MethodSource("userInputValueProvider")
    public void should_FailGettingNumbersFromUser_When_UserInputIntegersLessThanExpectedPool(int howManyNumbers, String numbers){
            // given
        UserNumbersRetriever userNumbersRetriever =
                new UserNumbersRetriever();
            // when
        Set<Integer> numbersFromUser = userNumbersRetriever.getNumbersFromUser(
                mockScannerIn(numbers),
                howManyNumbers,
                1,
                99);
            // then
        assertEquals(numbersFromUser.size(), howManyNumbers);
    }
    private static Stream<Arguments> userInputValueProvider(){
        return Stream.of(
                Arguments.of(0,""),
                Arguments.of(1,"4 0"),
                Arguments.of(6,"1 2 3 4 5 6"),
                Arguments.of(3,"1 2 -3 k 5 -6"),
                Arguments.of(2,"4 0 8 65 82 16"),
                Arguments.of(7,"1 mm 3 -4 5 6 100 8 0 10 98")
        );
    }
    private Scanner mockScannerIn(String data) {
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Scanner scanner = new Scanner(System.in);
        System.setIn(stdin);
        return scanner;
    }
}