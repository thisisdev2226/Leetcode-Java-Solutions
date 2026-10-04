/*
Problem: 540. Single Element in a Sorted Array
Link: https://leetcode.com/problems/single-element-in-a-sorted-array/

Approach:

1. Since the array is sorted and every element appears exactly twice except one, we can use Binary Search to find the single element in O(log n) time.
2. First, handle the edge cases:

   * If the array has only one element, return it.
   * If the first or last element is unique, return it.
3. Find the middle element and check whether it is the single element by comparing it with its neighbors.
4. If it is part of a pair, identify the first (p) and second (d) positions of that pair.
5. Calculate the number of elements on the left and right sides of the pair.
6. If the left count is even, the single element must be on the right, so update low = d + 1.
7. Otherwise, the single element must be on the left, so update high = p - 1.
8. Repeat until the single element is found.

Time Complexity: O(log n)
Space Complexity: O(1)
*/

class Solution {
public int singleNonDuplicate(int[] nums) {
int n = nums.length;

```
    if (n == 1) return nums[0];

    if (nums[0] != nums[1]) return nums[0];
    if (nums[n - 1] != nums[n - 2]) return nums[n - 1];

    int low = 0, high = n - 1;

    while (low <= high) {
        int mid = low + (high - low) / 2;

        if (nums[mid] != nums[mid - 1] &&
            nums[mid] != nums[mid + 1]) {
            return nums[mid];
        }

        int p = mid; // First element of the pair
        int d = mid; // Second element of the pair

        if (nums[mid - 1] == nums[mid]) {
            p = mid - 1;
        } else {
            d = mid + 1;
        }

        int leftCount = p - low;
        int rightCount = high - d;

        if (leftCount % 2 == 0) {
            low = d + 1;
        } else {
            high = p - 1;
        }
    }

    return -1;
}
```

}
