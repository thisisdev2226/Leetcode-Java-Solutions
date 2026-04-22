/*
Problem: 66. Plus One
Link: https://leetcode.com/problems/plus-one/

Approach:
- Traverse the array from right to left.
- If the current digit is less than 9, simply increment it and return the array.
- If the digit is 9, set it to 0 and continue to the next digit.
- If all digits are 9 (e.g., 999), create a new array of size n+1.
- Set the first element to 1 and return the new array.

Time Complexity: O(n)
- In worst case, we traverse all digits once.

Space Complexity: O(1)
- No extra space used except when all digits are 9 (then O(n) for new array).
*/

class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            } else {
                digits[i] = 0;
            }
        }

        int newNumber[] = new int[n + 1];
        newNumber[0] = 1;

        return newNumber;
    }
}
