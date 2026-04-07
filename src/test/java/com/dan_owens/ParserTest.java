package com.dan_owens;

import org.junit.jupiter.api.Test;
import java.util.InputMismatchException;
import static org.junit.jupiter.api.Assertions.*;

class ParserTest {

    @Test
    void testParseIntArrayValidArray() {
        String input = "[1, 2, 3]";
        int[] result = Parser.parseIntArray(input);
        int[] expected = new int[]{1, 2, 3};
        assertArrayEquals(expected, result);
    }

    @Test
    void testParseIntArrayMaxInt() {
        String input = "[2147483647]";
        int[] result = Parser.parseIntArray(input);
        assertArrayEquals(new int[]{Integer.MAX_VALUE}, result);
    }

    @Test
    void testParseIntArrayNegativeValues() {
        String input = "[-1, -5, -10]";
        int[] result = Parser.parseIntArray(input);
        int[] expected = new int[]{-1, -5, -10};
        assertArrayEquals(expected, result);
    }

    @Test()
    void testParseIntArrayWithFloat() {
        assertThrows(InputMismatchException.class, () -> Parser.parseIntArray("[1.5, 2]"));
    }

    @Test()
    void testParseIntArrayNullInput() {
        assertThrows(InputMismatchException.class, () -> Parser.parseIntArray(null));
    }

    @Test()
    void testParseIntArrayEmptyString() {
        assertThrows(InputMismatchException.class, () -> Parser.parseIntArray(""));
    }

    @Test()
    void testParseStringArrayValidArray(){
        String input = "[\"abc\", \"def\",\"ghi\"]";
        String[] result = Parser.parseStringArray(input);
        String[] expected = new String[]{"abc", "def", "ghi"};
        assertArrayEquals(expected, result);
    }

    @Test
    public void testParseStringArrayValidSingleElement() {
        String[] result = Parser.parseStringArray("[\"hello\"]");
        assertEquals(1, result.length);
        assertEquals("hello", result[0]);
    }

    @Test
    public void testParseStringArrayValidEmptyArray() {
        String[] result = Parser.parseStringArray("[]");
        assertEquals(1, result.length);
        assertEquals("", result[0]);
    }

    @Test
    public void testParseStringArrayValidWithWhitespace() {
        String[] result = Parser.parseStringArray("[ \"a\" , \"b\" ]");
        assertEquals(2, result.length);
        assertArrayEquals(new String[]{"a", "b"}, result);
    }

    @Test
    public void testParseStringArrayValidWithoutBrackets() {
        String[] result = Parser.parseStringArray("\"a\",\"b\",\"c\"");
        assertEquals(3, result.length);
        assertArrayEquals(new String[]{"a", "b", "c"}, result);
    }

    @Test
    public void testParseStringArrayNullInputThrowsException() {
        Exception exception = assertThrows(InputMismatchException.class, () ->
                Parser.parseStringArray(null));
        assertTrue(exception.getMessage().contains("null"));
    }

    @Test
    public void testParseStringArrayEmpty() {
        String[] result = Parser.parseStringArray(" ");
        assertEquals(0, result.length);
    }

    @Test
    public void testParseStringArrayInputWithNumbers() {
        String[] result = Parser.parseStringArray("[1,2,3]");
        assertEquals(3, result.length);
        assertArrayEquals(new String[]{"1", "2", "3"}, result);
    }

    @Test
    public void testParseStringArrayInputWithSpecialCharacters() {
        String[] result = Parser.parseStringArray("[\"hello-world\",\"testParseStringArray@name\"]");
        assertEquals(2, result.length);
        assertArrayEquals(new String[]{"hello-world", "testParseStringArray@name"}, result);
    }
}