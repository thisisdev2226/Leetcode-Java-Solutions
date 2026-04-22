/*
Problem: 69. Sqrt(x)
Link: https://leetcode.com/problems/sqrtx/

Approach:
- Use Binary Search to find the integer square root.
- Search range: [1, x]
- For each mid:
    - If mid == x / mid → exact square root found.
    - If mid > x / mid → mid is too large → move left (high = mid - 1)
    - Else → mid is too small → move right (low = mid + 1)
- Return high because it will store the floor value of sqrt(x).

Why x/mid instead of mid*mid?
- To avoid integer overflow when x is large.

Time Complexity: O(log x)
- Binary search halves the range each time.

Space Complexity: O(1)
- No extra space used.
*/

class Solution {
    public int mySqrt(int x) {
        if (x == 0) return 0;

        int low = 1, high = x;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (mid == x / mid) return mid;
            else if (mid > x / mid) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return high;
    }
}
