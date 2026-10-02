/*
Problem: 2220. Minimum Bit Flips to Convert Number
Link: https://leetcode.com/problems/minimum-bit-flips-to-convert-number/

Approach:
1. Use XOR (^) between start and goal.
2. XOR gives 1 at positions where the bits of start and goal are different.
3. Use Integer.bitCount() to count the number of set bits (1s) in the XOR result.
4. The count represents the minimum number of bit flips required.

Time Complexity: O(1)
Space Complexity: O(1)
*/

class Solution {
    public int minBitFlips(int start, int goal) {
        return Integer.bitCount(start ^ goal);
    }
}
