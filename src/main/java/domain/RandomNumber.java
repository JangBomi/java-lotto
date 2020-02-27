package domain;

import java.util.Random;

public class RandomNumber {
    private static final Random random = new Random();
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int MIN_LOTTO_NUMBER = 1;

    public static int generateRandomNumber() {
        return random.nextInt(MAX_LOTTO_NUMBER) + MIN_LOTTO_NUMBER;
    }
}