/**
 * Problem: 169. Majority Element
 * Link: https://leetcode.com/problems/majority-element/
 *
 * Approach:
 * - Use the Boyer-Moore Voting Algorithm.
 * - Maintain a candidate (majority) and a vote count.
 * - If votes become 0, choose the current element as the new candidate.
 * - Increment votes when the current element matches the candidate,
 *   otherwise decrement votes.
 * - Since the majority element appears more than n/2 times,
 *   the final candidate will be the majority element.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
class Solution {
    public int majorityElement(int[] num) {
        int majority = num[0];
        int votes = 1;

        for (int i = 1; i < num.length; i++) {
            if (votes == 0) {
                majority = num[i];
                votes++;
            } else if (majority == num[i]) {
                votes++;
            } else {
                votes--;
            }
        }

        return majority;
    }
}
