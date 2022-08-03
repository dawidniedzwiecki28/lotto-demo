package com.niedzwiadek28code.minigamesdemo.lotto;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LottoService {
    private final Set<Integer> userNumbers = new HashSet<>();
    private final Set<Integer> generatedNumbers = generateNumbers();

    public Set<Integer> getGeneratedNumbers() {
        return generatedNumbers;
    }
    public Set<Integer> getUserNumbers() {
        return userNumbers;
    }

    public int getGameResult(){
        int result = 0;

        for (Integer number : userNumbers){
            if(generatedNumbers.contains(number))
                result++;
        }
        return result;
    }

    public Set<Integer> generateNumbers(){
        return RandomNumbersGenerator.generateRandomNumbers(
                LottoConfig.NUMBER_POOL,
                LottoConfig.LOWER_RANGE,
                LottoConfig.UPPER_RANGE);
    }

    public void getNumbersFromUser(){

        Scanner scanner = new Scanner(System.in);

        while (userNumbers.size() < LottoConfig.NUMBER_POOL){
            System.out.printf(LottoMessages.NEXT_NUMBER_MESSAGE, userNumbers.size()+1);

            Integer userNumber;
            userNumber = getNumber(scanner);

            if(isNotNumberFromRange(userNumber)) {
                System.out.printf(LottoMessages.NUMBER_OUT_RANGE, LottoConfig.LOWER_RANGE, LottoConfig.UPPER_RANGE);
            }
            else if (userNumbers.contains(userNumber)) {
                System.out.printf(LottoMessages.NUMBER_DUPLICATE);
            }
            else {
                userNumbers.add(userNumber);
            }
        }
        scanner.close();
    }
    private Integer getNumber(Scanner scan) {
        while (!scan.hasNextInt()) {
            scan.next();
            System.out.printf(LottoMessages.NOT_INTEGER, userNumbers.size()+1);
        }
        return scan.nextInt();
    }
    private boolean isNotNumberFromRange(int number){
        return number < LottoConfig.LOWER_RANGE || number > LottoConfig.UPPER_RANGE;
    }
}
