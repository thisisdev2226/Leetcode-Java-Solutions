/*
 * Problem: 1209. Remove All Adjacent Duplicates in String II
 * Link: https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/
 *
 * Approach:
 * 1. Use StringBuilder as a mutable string (acts like a stack).
 * 2. Maintain a count array where count[i] stores the number of
 *    consecutive equal characters ending at index i.
 * 3. If the current character is the same as the previous character,
 *    increase its count; otherwise, reset the count to 1.
 * 4. When count[i] == k, delete the last k characters.
 * 5. Move i back by k positions so newly formed adjacent duplicates
 *    can be checked again.
 *
 * Time Complexity: O(n^2) in the worst case because StringBuilder.delete()
 *                  may shift characters.
 * Space Complexity: O(n)
 */

class Solution {
    public String removeDuplicates(String s, int k) {

        // StringBuilder allows us to modify the string
        StringBuilder sb = new StringBuilder(s);

        // count[i] stores consecutive duplicate count at index i
        int[] count = new int[sb.length()];

        for (int i = 0; i < sb.length(); i++) {

            // If current character matches the previous character,
            // increase the consecutive count
            if (i > 0 && sb.charAt(i) == sb.charAt(i - 1)) {
                count[i] = count[i - 1] + 1;
            } 
            else {
                // New sequence starts
                count[i] = 1;
            }

            // If k consecutive characters are found, remove them
            if (count[i] == k) {

                // Delete k characters ending at index i
                sb.delete(i - k + 1, i + 1);

                // Move back to check newly formed duplicates
                i = i - k;
            }
        }

        return sb.toString();
    }
}
```
