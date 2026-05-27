/**
 * Problem: 128. Longest Consecutive Sequence
 * Link: https://leetcode.com/problems/longest-consecutive-sequence/
 *
 * Approach:
 * - Store all elements in a HashSet for O(1) lookup.
 * - Start building a sequence only if the current number
 *   is the beginning of a sequence (num - 1 not present).
 * - Count consecutive numbers using while loop.
 * - Track maximum sequence length.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class Solution {
    public int longestConsecutive(int[] nums) {

        HashSet<Integer> st = new HashSet<>();

        // Add all array elements into HashSet
        for (int num : nums) {
            st.add(num);
        }

        int maxStreak = 0;

        // Traverse through HashSet
        for (int num : st) {

            // Check if current number is the start of sequence
            if (!st.contains(num - 1)) {

                int currNum = num;
                int currStreak = 1;

                // Count consecutive sequence length
                while (st.contains(currNum + 1)) {
                    currNum++;
                    currStreak++;
                }

                maxStreak = Math.max(maxStreak, currStreak);
            }
        }

        return maxStreak;
    }
}
