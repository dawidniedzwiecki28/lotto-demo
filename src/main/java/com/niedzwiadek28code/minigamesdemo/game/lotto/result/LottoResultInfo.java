package com.niedzwiadek28code.minigamesdemo.game.lotto.result;

import com.niedzwiadek28code.minigamesdemo.game.lotto.config.LottoMessages;

public class LottoResultInfo {
    private final int result;

    public LottoResultInfo(int result) {
        this.result = result;
    }

    public String getGameResult() {
        return String.format(LottoMessages.DISPLAY_RESULT, result);
    }
}
