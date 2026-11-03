/*
Problem: 1899. Merge Triplets to Form Target Triplet

Link: https://leetcode.com/problems/merge-triplets-to-form-target-triplet/

Approach:
1. Create an array maxValue of size 3 initialized with zeros.
2. Iterate through every triplet in the given array.
3. Check whether all three elements of the current triplet are less than or equal to the corresponding target elements.
4. If the condition is satisfied, update each position of maxValue using Math.max().
5. Finally, check whether all three elements of maxValue match the target array.
6. If all match, return true; otherwise, return false.

Time Complexity: O(n)
- We traverse the triplets array once.
- Each triplet takes O(1) time for comparisons and updates.

Space Complexity: O(1)
- We use a fixed-size array of 3 elements.

*/

class Solution {
    public static boolean mergeTriplets(int[][] triplets, int[] target) {

        // Store maximum values for each position
        int[] maxValue = new int[3];

        // Iterate over each triplet
        for (int[] triplet : triplets) {

            // Check whether the triplet can contribute to target
            if (triplet[0] <= target[0] &&
                triplet[1] <= target[1] &&
                triplet[2] <= target[2]) {

                maxValue[0] = Math.max(maxValue[0], triplet[0]);
                maxValue[1] = Math.max(maxValue[1], triplet[1]);
                maxValue[2] = Math.max(maxValue[2], triplet[2]);
            }
        }

        // Check if we can form the target triplet
        return maxValue[0] == target[0] &&
               maxValue[1] == target[1] &&
               maxValue[2] == target[2];
    }
}
