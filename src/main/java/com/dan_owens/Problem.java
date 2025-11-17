package com.dan_owens;

import java.util.Map;
import com.dan_owens.SlidingWindow.BestTimeToBuyAndSellStock;
import com.dan_owens.TwoPointer.ValidPalendrome;


public interface Problem{
    public String run(String value);
}

class ProblemFactory {
    private static final Map<String, Problem> problems = Map.of(
        "BestTimeToBuyAndSellStock", new BestTimeToBuyAndSellStock(),
        "ValidPalendrome", new ValidPalendrome()
    );

    public static Problem get(String name) {
        return problems.get(name);
    }
}