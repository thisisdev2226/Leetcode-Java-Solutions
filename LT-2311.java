/*
Problem: 2311. Longest Binary Subsequence Less Than or Equal to K
Link: https://leetcode.com/problems/longest-binary-subsequence-less-than-or-equal-to-k/

Approach:
1. Traverse the binary string from right to left because the rightmost character has the smallest positional value.
2. Initialize count = 0 to store the maximum subsequence length.
3. Every '0' can always be included because adding zero does not increase the binary value.
4. For a '1', calculate its positional value using 2^idx, where idx represents its position from the right.
5. Add the '1' only if the updated sum remains less than or equal to k.
6. Once adding a '1' makes the sum greater than k, set isValidOne = false.
7. Continue counting zeros even after isValidOne becomes false.
8. Return count.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public int longestSubsequence(String s, int k) {
        int n = s.length();
        int count = 0;
        int sum = 0;
        boolean isValidOne = true;

        for (int i = n - 1; i >= 0; i--) {

            if (s.charAt(i) == '0') {
                count++;
            } 
            else if (isValidOne) {
                int idx = n - 1 - i;
                sum += Math.pow(2, idx);

                if (sum <= k) {
                    count++;
                } else {
                    isValidOne = false;
                }
            }
        }

        return count;
    }
}
