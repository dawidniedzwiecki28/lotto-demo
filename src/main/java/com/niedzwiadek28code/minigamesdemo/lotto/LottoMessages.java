package com.niedzwiadek28code.minigamesdemo.lotto;

public class LottoMessages {
    public static final String GAME_INTRODUCTION = "Welcome in LOTTO game!";
    public static final String START_MESSAGE =
                    "Check your luck!\n" +
                    "Give " + LottoConfig.NUMBER_POOL +
                    " different numbers from range " + LottoConfig.LOWER_RANGE +
                    "-" + LottoConfig.UPPER_RANGE;
    public static final String NEXT_NUMBER_MESSAGE = "Please enter your %d number: ";
    public static final String NOT_INTEGER = "That's not a integer, enter your %d number: ";
    public static final String NUMBER_OUT_RANGE = "Number out of range %d-%d\n";
    public static final String NUMBER_DUPLICATE = "That number is already saved. ";
    public static final String DISPLAY_RESULT = "You hit %d numbers.\n";
}