package com.dan_owens;

import java.util.Arrays;
import java.util.InputMismatchException;

public class Parser {
    public static int[] parseIntArray(String input) throws InputMismatchException{
        try{
        input = input.strip().substring(1, input.length() - 1);
        int[] arr = Arrays.stream(input.split(","))
                          .mapToInt(Integer::parseInt)
                          .toArray();
        return arr;
        }
        catch(Exception e){
            throw new InputMismatchException("Input must be an 1D Integer array of type [1,2,3,4,5]");
        }
    }
}
