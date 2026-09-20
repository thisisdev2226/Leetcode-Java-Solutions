 /*
 Problem: 242. Valid Anagram
 Link: https://leetcode.com/problems/valid-anagram/

 Approach:
 - If lengths are different, strings cannot be anagrams.
 - Convert both strings into character arrays.
 - Sort both arrays.
 - Compare corresponding characters.
 - If all characters match, the strings are anagrams.

 Time Complexity: O(n log n)
 Space Complexity: O(n)
 */

class Solution {
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }

        return true;
    }
}
