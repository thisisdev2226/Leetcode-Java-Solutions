/*
Problem: 219. Contains Duplicate II
Link: https://leetcode.com/problems/contains-duplicate-ii/

Approach:
1. Create a HashMap to store each element and its most recent index.
2. Traverse the array using a for loop.
3. Check whether the current element already exists in the HashMap.
4. If it exists:
   - Get its previous index using mp.get(nums[i]).
   - Calculate the difference between the current index and previous index.
   - If (i - idx) <= k, return true because the same element
     occurs within the allowed distance.
   - Otherwise, update its index to the current index.
5. If the element does not exist, insert it into the HashMap
   with its current index.
6. If no nearby duplicate is found, return false.

Time Complexity: O(n)
- We traverse the array once.
- HashMap operations take O(1) average time.

Space Complexity: O(n)
- In the worst case, the HashMap stores all n elements.
*/

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> mp = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            if (mp.containsKey(nums[i])) {

                int idx = mp.get(nums[i]);

                if ((i - idx) <= k) {
                    return true;
                } else {
                    mp.put(nums[i], i);
                }

            } else {
                mp.put(nums[i], i);
            }
        }

        return false;
    }
}
