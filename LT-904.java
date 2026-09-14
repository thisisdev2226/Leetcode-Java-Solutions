/*
Problem: 904. Fruit Into Baskets
Link: https://leetcode.com/problems/fruit-into-baskets/

Approach:

* Use Sliding Window + HashMap.
* The window can contain at most 2 distinct fruit types.
* Expand the window using `right`.
* If more than 2 types exist, shrink from `left`.
* Track the maximum valid window length.

Time Complexity: O(n)
Space Complexity: O(1) — at most 3 keys in the HashMap
*/

class Solution {
public int totalFruit(int[] fruits) {
int n = fruits.length;
int left = 0;
int maxLen = 0;

    Map<Integer, Integer> freq = new HashMap<>();

    for (int right = 0; right < n; right++) {
        freq.put(
            fruits[right],
            freq.getOrDefault(fruits[right], 0) + 1
        );

        // Shrink window if more than 2 fruit types
        while (freq.size() > 2) {
            int leftFruit = fruits[left];

            freq.put(leftFruit, freq.get(leftFruit) - 1);

            if (freq.get(leftFruit) == 0) {
                freq.remove(leftFruit);
            }

            left++;
        }

        maxLen = Math.max(maxLen, right - left + 1);
    }

    return maxLen;
}

}
