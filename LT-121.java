/**
 * Problem: 121. Best Time to Buy and Sell Stock
 * Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 *
 * Approach:
 * - Keep track of the minimum buying price seen so far.
 * - For each day, calculate the profit if sold on that day.
 * - Update the maximum profit accordingly.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int maxProfit(int[] prices) {
        int buy_price = prices[0];
        int profit = 0;

        for (int i = 0; i < prices.length; i++) {

            // Update minimum buying price
            if (prices[i] < buy_price) {
                buy_price = prices[i];
            } 
            else {

                // Calculate current profit
                int current_profit = prices[i] - buy_price;

                // Update maximum profit
                profit = Math.max(current_profit, profit);
            }
        }

        return profit;
    }
}
