package com.niedzwiadek28code.minigamesdemo.lotto;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoGameTest {

    @Test
    @DisplayName("should return winner message")
    public void should_return_winner_message_when_user_gave_six_numbers_and_generator_generated_winning_numbers() {
        // given
        LottoGame game = new LottoGame(
                new UserNumbersRetriever(mockScannerIn("1, 2, 3, 4, 5 , 6")),

        );


        // when
        game.play();
    }

    private Scanner mockScannerIn(String data) {
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Scanner scanner = new Scanner(System.in);
        System.setIn(stdin);
        return scanner;
    }
}
