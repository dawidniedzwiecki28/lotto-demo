package com.niedzwiadek28code.minigamesdemo.game.lotto.config;

public class LottoConfig {
    public static final int LOWER_RANGE = 1;
    public static final int UPPER_RANGE = 99;

    /**
     * NUMBER_POOL must be less than or equal to (UPPER_RANGE - LOWER_RANGE + 1)
     * because we need unique numbers and they cannot be duplicate
     */
    public static final int NUMBER_POOL = 6;
}
