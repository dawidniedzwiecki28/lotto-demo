package com.niedzwiadek28code.minigamesdemo.lotto.tools;

import com.niedzwiadek28code.minigamesdemo.lotto.LottoMessages;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class UserNumbersRetriever {
    private final Scanner scanner;

    public UserNumbersRetriever(Scanner scanner) {
        this.scanner = scanner;
    }

    public Set<Integer> getNumbersFromUser(int howManyNumbers, int minValue, int maxValue) {

        Set<Integer> userNumbers = new HashSet<>();

        while (userNumbers.size() < howManyNumbers) {

            System.out.printf(LottoMessages.NEXT_NUMBER_MESSAGE, userNumbers.size() + 1);

            Integer userNumber;
            userNumber = getInteger(scanner, userNumbers.size());

            if (isNotNumberFromRange(userNumber, minValue, maxValue)) {
                System.out.printf(LottoMessages.NUMBER_OUT_RANGE, minValue, maxValue);
            } else if (userNumbers.contains(userNumber)) {
                System.out.printf(LottoMessages.NUMBER_DUPLICATE);
            } else {
                userNumbers.add(userNumber);
            }
        }
        scanner.close();

        return userNumbers;
    }

    private Integer getInteger(Scanner scanner, int userNumbersSize) {
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.printf(LottoMessages.NOT_INTEGER, userNumbersSize + 1);
        }
        return scanner.nextInt();
    }

    private boolean isNotNumberFromRange(int number, int min, int max) {
        return number < min || number > max;
    }
}
