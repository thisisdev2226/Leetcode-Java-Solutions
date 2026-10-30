/*
Problem: 3516. Find Closest Person
Link: https://leetcode.com/problems/find-closest-person/

Approach:
1. Calculate the absolute distance between person 1 (x) and person 3 (z).
2. Calculate the absolute distance between person 2 (y) and person 3 (z).
3. Compare both distances:
   - If diff1 < diff2, return 1.
   - If diff2 < diff1, return 2.
   - If both distances are equal, return 0.

Time Complexity: O(1)
Space Complexity: O(1)
*/

class Solution {
    public int findClosest(int x, int y, int z) {
        int diff1 = Math.abs(x - z);
        int diff2 = Math.abs(y - z);

        if (diff1 < diff2) {
            return 1;
        } else if (diff2 < diff1) {
            return 2;
        } else {
            return 0;
        }
    }
}
