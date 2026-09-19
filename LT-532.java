/*
Problem: 532. K-diff Pairs in an Array
Link: https://leetcode.com/problems/k-diff-pairs-in-an-array/

Approach:

* Store frequency of each number in HashMap.
* If k < 0, no valid pair exists.
* If k == 0, count numbers having frequency > 1.
* If k > 0, check whether num + k exists.
* Checking only num + k avoids duplicate pairs.

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {
public int findPairs(int[] nums, int k) {

    if (k < 0) return 0;

    HashMap<Integer, Integer> map = new HashMap<>();

    // Store frequency
    for (int num : nums) {
        if (map.containsKey(num)) {
            map.put(num, map.get(num) + 1);
        } else {
            map.put(num, 1);
        }
    }

    int count = 0;

    // Check unique numbers
    for (int num : map.keySet()) {

        if (k == 0) {
            // Same number should occur at least twice
            if (map.get(num) > 1) {
                count++;
            }

        } else {
            // Check num + k to avoid duplicate pairs
            if (map.containsKey(num + k)) {
                count++;
            }
        }
    }

    return count;
}

}

