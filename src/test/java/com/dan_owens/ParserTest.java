package com.dan_owens;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.InputMismatchException;
import static org.junit.jupiter.api.Assertions.*;

class ParserTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testParseValidArray() {
        String input = "[1, 2, 3]";
        int[] result = Parser.parseIntArray(input);
        int[] expected = new int[]{1, 2, 3};
        assertArrayEquals(expected, result);
    }

    @Test
    void testParseMaxInt() {
        String input = "[2147483647]";
        int[] result = Parser.parseIntArray(input);
        assertArrayEquals(new int[]{Integer.MAX_VALUE}, result);
    }

    @Test
    void testParseNegativeValues() {
        String input = "[-1, -5, -10]";
        int[] result = Parser.parseIntArray(input);
        int[] expected = new int[]{-1, -5, -10};
        assertArrayEquals(expected, result);
    }

    @Test()
    void testParseWithFloat() {
        assertThrows(InputMismatchException.class, () -> Parser.parseIntArray("[1.5, 2]"));
    }

    @Test()
    void testParseNullInput() {
        assertThrows(InputMismatchException.class, () -> Parser.parseIntArray(null));
    }

    @Test()
    void testParseEmptyString() {
        assertThrows(InputMismatchException.class, () -> Parser.parseIntArray(""));
    }
}