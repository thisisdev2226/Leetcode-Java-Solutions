/*
Problem: 151. Reverse Words in a String
Link: https://leetcode.com/problems/reverse-words-in-a-string/

Approach: Two Pointers + StringBuilder

1. Create a StringBuilder to store the final reversed string.

2. Initialize pointer i at the last index of the string.

3. Traverse the string from right to left.

4. Skip leading, trailing, and multiple spaces:
   - Move i backward while the current character is a space.

5. Find the current word:
   - Store the ending index in end.
   - Move i backward until a space or the beginning of the string is reached.

6. Add a space before the word if ans already contains a word.

7. Append the current word character by character using another pointer j.

8. Return the final StringBuilder as a String.

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {
    public String reverseWords(String s) {

        StringBuilder ans = new StringBuilder();

        int i = s.length() - 1;

        while (i >= 0) {

            // Skip spaces
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }

            if (i < 0) {
                break;
            }

            // Find end of current word
            int end = i;

            // Move to beginning of word
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }

            // Add space between words if a word already exists
            if (ans.length() > 0) {
                ans.append(" ");
            }

            // Add word
            for (int j = i + 1; j <= end; j++) {
                ans.append(s.charAt(j));
            }
        }

        return ans.toString();
    }
}
