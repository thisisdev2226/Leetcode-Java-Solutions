/*
 * Problem: 402. Remove K Digits
 * Link: https://leetcode.com/problems/remove-k-digits/
 *
 * Approach:
 * - Use StringBuilder as a stack.
 * - Traverse the digits from left to right.
 * - If the current digit is smaller than the last digit in the stack,
 *   remove the larger digit while k > 0.
 * - This makes the resulting number as small as possible.
 * - Avoid adding leading zeros.
 * - If k is still greater than 0 after traversal, remove digits
 *   from the end.
 * - If nothing remains, return "0".
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

public class Solution {
    public String removeKdigits(String num, int k) {

        // StringBuilder acts like a stack
        StringBuilder result = new StringBuilder();

        int n = num.length();

        for (int i = 0; i < n; i++) {

            // Remove larger previous digits
            // Example: 143 -> when we see 3, nothing is removed
            // Example: 143 -> if current digit was 2, remove 4 and 3
            while (result.length() > 0
                    && result.charAt(result.length() - 1) > num.charAt(i)
                    && k > 0) {

                result.deleteCharAt(result.length() - 1);
                k--;
            }

            // Avoid leading zeros
            if (result.length() > 0 || num.charAt(i) != '0') {
                result.append(num.charAt(i));
            }
        }

        // If k is still remaining, remove digits from the end
        while (result.length() > 0 && k > 0) {
            result.deleteCharAt(result.length() - 1);
            k--;
        }

        // If nothing remains, return "0"
        if (result.length() == 0) {
            return "0";
        }

        return result.toString();
    }
}
