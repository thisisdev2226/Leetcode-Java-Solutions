/*
Problem: 441. Arranging Coins
Link: https://leetcode.com/problems/arranging-coins/

Approach:
1. We are given n coins and need to arrange them into a staircase.
2. Each row requires one more coin than the previous row:
   Row 1 -> 1 coin
   Row 2 -> 2 coins
   Row 3 -> 3 coins, and so on.
3. We need to find the maximum number of complete rows that can be formed.
4. Use binary search to find the maximum k such that:

   k * (k + 1) / 2 <= n

5. If the required coins are less than or equal to n, we can form k rows and search for more.
6. Otherwise, reduce the search range.

Time Complexity: O(log n)
Space Complexity: O(1)
*/

class Solution {
    public int arrangeCoins(int n) {

        long left = 0;
        long right = n;

        while (left <= right) {

            long mid = left + (right - left) / 2;

            long coins = mid * (mid + 1) / 2;

            if (coins == n) {
                return (int) mid;
            } 
            else if (coins < n) {
                left = mid + 1;
            } 
            else {
                right = mid - 1;
            }
        }

        return (int) right;
    }
}
