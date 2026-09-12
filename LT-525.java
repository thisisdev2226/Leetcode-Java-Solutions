/*
Problem: 525. Contiguous Array
Link: https://leetcode.com/problems/contiguous-array/

Approach:

* Convert `0` to `-1` and `1` to `+1`.
* Now, a subarray with equal 0s and 1s will have sum = 0.
* Use a HashMap to store the first index where each prefix sum occurs.
* If the same sum appears again, the elements between those indices have sum 0.
* Store only the first occurrence because it gives the longest possible subarray.
* Initialize `map.put(0, -1)` to handle subarrays starting from index 0.

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {
public int findMaxLength(int[] nums) {

```
    HashMap<Integer, Integer> map = new HashMap<>();

    int sum = 0;
    int maxLen = 0;

    map.put(0, -1);

    for (int i = 0; i < nums.length; i++) {

        // 0 -> -1, 1 -> +1
        if (nums[i] == 1) {
            sum += 1;
        } else {
            sum -= 1;
        }

        // Same prefix sum found
        if (map.containsKey(sum)) {
            int prevIndex = map.get(sum);
            maxLen = Math.max(maxLen, i - prevIndex);
        } else {
            // Store first occurrence
            map.put(sum, i);
        }
    }

    return maxLen;
}
```

}
