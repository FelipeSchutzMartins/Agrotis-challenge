package com.agrotis.utils;

public class RegexPatternsUtils {

    public static Boolean containsNonNumeric(String input) {
        return input.matches(".*\\D.*");
    }

}
