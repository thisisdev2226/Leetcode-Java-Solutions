/*
Problem: 258. Add Digits
Link: https://leetcode.com/problems/add-digits/

Approach:
1. This problem can be solved using the Digital Root concept.
2. The digital root of a positive integer is the single digit obtained by repeatedly adding its digits.
3. Instead of repeatedly calculating the sum of digits, we can use the mathematical formula:

   Digital Root = 1 + (num - 1) % 9

4. If num is 0, return 0 directly because its digital root is 0.
5. Otherwise, apply the formula to get the final single digit.

Time Complexity: O(1)
Space Complexity: O(1)
*/

class Solution {
    public int addDigits(int num) {
        if (num == 0) return 0;

        return 1 + (num - 1) % 9;
    }
}
