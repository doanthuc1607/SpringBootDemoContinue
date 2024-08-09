package com.sample.administration.util;

import java.util.Random;

public class Util {
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final Random RANDOM = new Random();

    public static String generateRandomString(int length) {
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int index = RANDOM.nextInt(ALPHABET.length());
            sb.append(ALPHABET.charAt(index));
        }

        return sb.toString();
    }
}
