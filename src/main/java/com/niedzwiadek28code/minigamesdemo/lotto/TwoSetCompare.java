package com.niedzwiadek28code.minigamesdemo.lotto;

import java.util.Set;
public class TwoSetCompare {
    public static int howManyNumbersContainInBothSet(Set<Integer> setOne, Set<Integer> setTwo){
        int result = 0;
        for (Integer number : setOne){
            if(setTwo.contains(number))
                result++;
        }
        return result;
    }
}
