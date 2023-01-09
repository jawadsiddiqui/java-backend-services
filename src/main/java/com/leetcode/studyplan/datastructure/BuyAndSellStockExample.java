package com.leetcode.studyplan.datastructure;

public class BuyAndSellStockExample {
    public static void main(String[] args) {
        int[] arr = new int[]{7,1,5,3,6,4};
        int i = maxProfit(arr);
        System.out.println(i);
    }

    public static int maxProfit(int[] prices) {
        if(prices.length < 2)
            return 0;

        int minPrice = prices[0];
        int maxProfit = 0;
        for(int price : prices){
            if ( price < minPrice)
                minPrice = price;
            else if (price - minPrice > maxProfit)
                maxProfit = price - minPrice;
        }

        return  maxProfit;
    }
}
