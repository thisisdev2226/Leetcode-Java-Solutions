/*
Problem: 217. Contains Duplicate
Link: https://leetcode.com/problems/contains-duplicate/

Approach:
1. Create a HashSet to store unique elements from the array.
2. Traverse the array using a for loop.
3. For every element, check whether it already exists in the HashSet.

   a) If the element is already present:
      - It means we have encountered a duplicate.
      - Return true.

   b) Otherwise:
      - Add the current element to the HashSet.

4. If the loop completes without finding any duplicate, return false.

Time Complexity: O(n)
- We traverse the array once.
- HashSet contains() and add() take O(1) average time.

Space Complexity: O(n)
- In the worst case, all n elements are unique and stored in the HashSet.
*/

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {

            if (set.contains(nums[i])) {
                return true;
            }

            set.add(nums[i]);
        }

        return false;
    }
}
