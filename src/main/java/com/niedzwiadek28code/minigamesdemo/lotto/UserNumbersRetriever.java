package com.niedzwiadek28code.minigamesdemo.lotto;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class UserNumbersRetriever {

    static Set<Integer> getNumbersFromUser(int howManyNumbers, int minValue, int maxValue){

        Set<Integer> userNumbers = new HashSet<>();
        Scanner scanner = new Scanner(System.in);

        while (userNumbers.size() < howManyNumbers){

            System.out.printf(LottoMessages.NEXT_NUMBER_MESSAGE, userNumbers.size()+1);

            Integer userNumber;
            userNumber = getIntereger(scanner, userNumbers.size());

            if(isNotNumberFromRange(userNumber, minValue, maxValue)) {
                System.out.printf(LottoMessages.NUMBER_OUT_RANGE, minValue, maxValue);
            }
            else if (userNumbers.contains(userNumber)) {
                System.out.printf(LottoMessages.NUMBER_DUPLICATE);
            }
            else {
                userNumbers.add(userNumber);
            }
        }
        scanner.close();

        return userNumbers;
    }
    private static Integer getIntereger(Scanner scanner, int userNumbersSize) {
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.printf(LottoMessages.NOT_INTEGER, userNumbersSize+1);
        }
        return scanner.nextInt();
    }
    private static boolean isNotNumberFromRange(int number, int min, int max){
        return number < min || number > max;
    }
}
