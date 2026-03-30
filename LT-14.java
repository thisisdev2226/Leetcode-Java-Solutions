/**
 * Problem: 14. Longest Common Prefix
 * Link: https://leetcode.com/problems/longest-common-prefix/
 *
 * Approach:
 * - Sort the array of strings.
 * - Compare only the first and last strings after sorting.
 * - The common prefix of these two will be the answer.
 * - Iterate character by character and stop when mismatch occurs.
 *
 * Time Complexity: O(N log N + M)
 *   - Sorting takes O(N log N)
 *   - Comparing characters takes O(M)
 *
 * Space Complexity: O(1)
 */

import java.util.Arrays;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder result = new StringBuilder();

        Arrays.sort(strs);

        char[] first = strs[0].toCharArray();
        char[] last = strs[strs.length - 1].toCharArray();

        for (int i = 0; i < first.length; i++) {
            if (i >= last.length || first[i] != last[i]) break;
            result.append(first[i]);
        }

        return result.toString();
    }
}
