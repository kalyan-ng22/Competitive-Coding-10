// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Approach : Best time to sell stock and buy, maximum profit can be achived when we buy and sell the stock at each positive slope. Hence,
// we maintain profit and add to it whenever we come across a positive slope, which means buy and sell a stock whenever first profit comes.


class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int profit = 0;
        for(int i = 0; i < n - 1; i++){
            if(prices[i+1] > prices[i]){ //check if next value is greater than current
                profit += prices[i+1] - prices[i]; //sell and add to profit
            }
        }
        return profit;
    }
}