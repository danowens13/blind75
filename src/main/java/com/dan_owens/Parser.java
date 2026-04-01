package com.dan_owens;

import java.util.Arrays;
import java.util.InputMismatchException;

public class Parser {

    static String nullCheckAndStrip(String input){
        if (input == null)
            throw new InputMismatchException("Input cannot be null or empty");
        String stripped = input.strip();
        if (stripped.isEmpty())
            throw new InputMismatchException("Input cannot be null or empty");
        return stripped;
    }

    public static int[] parseIntArray(String input) {
        input = nullCheckAndStrip(input);
        String content = input.replaceFirst("^\\[", "")
                .replaceFirst("]$", "")
                .strip();

        try {
            return Arrays.stream(content.split(","))
                    .map(String::strip)
                    .mapToInt(Integer::parseInt)
                    .toArray();
        } catch (NumberFormatException e) {
            throw new InputMismatchException("Invalid integer value: " + e.getMessage());
        }
    }

    public static String parseString(String input) throws InputMismatchException {
        return nullCheckAndStrip(input);
    }
}
