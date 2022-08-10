package com.niedzwiadek28code.minigamesdemo.game.lotto.tools;

import com.niedzwiadek28code.minigamesdemo.game.lotto.result.LottoResultInfo;

import java.util.Set;

public class TwoSetCompare {
    public LottoResultInfo getHitNumbers(Set<Integer> setOne, Set<Integer> setTwo) {
        int result = 0;
        for (Integer number : setOne) {
            if (setTwo.contains(number))
                result++;
        }
        return new LottoResultInfo(result);
    }
}
