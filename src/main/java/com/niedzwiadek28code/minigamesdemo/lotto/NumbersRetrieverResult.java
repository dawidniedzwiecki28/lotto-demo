package com.niedzwiadek28code.minigamesdemo.lotto;

import java.util.Set;

public record NumbersRetrieverResult(
        String message,
        Set<Integer> userNumbers
) {

}
