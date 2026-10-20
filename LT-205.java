/*
Problem: 205. Isomorphic Strings
Link: https://leetcode.com/problems/isomorphic-strings/

Approach:
1. If the lengths of s and t are different, return false.
2. Create a HashMap to store the mapping of characters from s to t.
3. Traverse both strings simultaneously.
4. If a character from s is already present in the map, check whether it maps to the current character of t. If not, return false.
5. If the character from s is not mapped yet, check whether the current character of t is already mapped to another character. If yes, return false.
6. Otherwise, store the mapping in the HashMap.
7. If all characters satisfy the mapping rules, return true.

Time Complexity: O(n²) in the worst case because containsValue() takes O(n) time and is called inside the loop.
Space Complexity: O(1) because the map stores at most 256 distinct characters for ASCII input.
*/

class Solution {
    public boolean isIsomorphic(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        // Map characters of s to characters of t
        HashMap<Character, Character> mp = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {

            char sCh = s.charAt(i);
            char tCh = t.charAt(i);

            if (mp.containsKey(sCh)) {

                // Existing mapping must match
                if (mp.get(sCh) != tCh) {
                    return false;
                }

            } else if (mp.containsValue(tCh)) {

                // Prevent two different characters mapping to the same character
                return false;

            } else {

                // Create a new mapping
                mp.put(sCh, tCh);
            }
        }

        return true;
    }
}
