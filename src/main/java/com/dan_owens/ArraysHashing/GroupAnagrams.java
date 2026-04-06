package com.dan_owens.ArraysHashing;

import com.dan_owens.Parser;
import com.dan_owens.Problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams implements Problem{
    public String run(String input){
        String[] strings = Parser.parseStringArray(input);
        HashMap<String, List<String>> groups = new HashMap<>();
        for(String s : strings){
            int[] count = new int[26];
            for(char c : s.toCharArray()) {
                count[(int) c - 97] += 1;
            }
            String key = Arrays.toString(count);
            groups.putIfAbsent(key, new ArrayList<>());
            groups.get(key).add(s);
        }
        return groups.toString();
    }
}
