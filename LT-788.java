/*
Problem: 788. Rotated Digits
Link: https://leetcode.com/problems/rotated-digits/

Approach:
1. Iterate through every number from 1 to n.
2. For each number, extract its digits using num % 10.
3. If a digit is 3, 4, or 7, the number is invalid because it becomes invalid after rotation.
4. If a digit is 2, 5, 6, or 9, mark the number as different because it changes into a different digit after rotation.
5. If no invalid digit is found and at least one digit changes, count the number as a good number.
6. Return the total count.

Time Complexity: O(n * log n)
Space Complexity: O(1)
*/

class Solution {

    public boolean isGood(int num) {
        boolean different = false;

        while (num > 0) {
            int digit = num % 10; // Extract the last digit

            // These digits become invalid after rotation
            if (digit == 3 || digit == 4 || digit == 7) {
                return false;
            }

            // These digits change into different digits
            if (digit == 2 || digit == 5 || digit == 6 || digit == 9) {
                different = true;
            }

            num = num / 10; // Remove the last digit
        }

        // Good number must change and remain valid
        return different;
    }

    public int rotatedDigits(int n) {
        int count = 0;

        for (int i = 1; i <= n; i++) {
            if (isGood(i)) {
                count++;
            }
        }

        return count;
    }
}
