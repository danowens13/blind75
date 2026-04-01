package com.dan_owens.TwoPointer;

import com.dan_owens.Problem;

public class ValidPalendrome implements Problem{
    public String run(String input) {
          input = input.replaceAll(
          "[^a-zA-Z0-9]", "").toLowerCase();
        int sLen = input.length();
        for(int i = 0; i < sLen / 2; i++){
            if(input.charAt(i) != input.charAt(sLen - i - 1))
                return "False";
        }
        return "True";
    }
}
