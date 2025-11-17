package com.dan_owens.SlidingWindow;

import com.dan_owens.Parser;
import com.dan_owens.Problem;

// import com.dan_owens.validator;
public class BestTimeToBuyAndSellStock implements Problem{
    public String run(String input) {
        int[] prices = Parser.parseIntArray(input);
        int maxP = 0;
        int minBuy = prices[0];

        for(int price : prices){
            maxP = Math.max(maxP, price - minBuy);
            minBuy = Math.min(minBuy, price);
        }
        return Integer.toString(maxP);
    }
}