/*
Problem: 1967. Number of Strings That Appear as Substrings in Word
Link: https://leetcode.com/problems/number-of-strings-that-appear-as-substrings-in-word/

Approach:
1. Initialize count = 0.
2. Iterate through each pattern in the patterns array using a for-each loop.
3. Check whether word.contains(pattern) is true.
4. If the pattern exists as a substring in word, increment count.
5. Return count after checking all patterns.

Time Complexity: O(n * m * k)
Space Complexity: O(1)

Where:
n = number of patterns
m = length of word
k = maximum length of a pattern
*/

class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int count = 0;

        for (String pattern : patterns) {
            // Check whether the pattern exists inside word
            if (word.contains(pattern)) {
                count++;
            }
        }

        return count;
    }
}
