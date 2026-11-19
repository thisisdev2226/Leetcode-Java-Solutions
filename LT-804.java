/*
Problem: 804. Unique Morse Code Words

Link: https://leetcode.com/problems/unique-morse-code-words/

Approach:
1. Create a String array containing the Morse code representations of all 26 lowercase English letters.
2. Create a HashSet to store unique Morse code transformations.
3. Traverse each word in the given words array.
4. For every character:
   - Convert the character into an index using ch - 'a'.
   - Use that index to access its corresponding Morse code.
   - Append the Morse code to a StringBuilder.
5. Convert the StringBuilder into a String and add it to the HashSet.
6. HashSet automatically stores only unique transformations.
7. Return the size of the HashSet.

Time Complexity: O(N * L)
- N = Number of words.
- L = Maximum length of a word.
- Each character is processed once.

Space Complexity: O(N * L)
- HashSet stores unique Morse transformations.
- StringBuilder requires space proportional to the word length.
*/

class Solution {
    public int uniqueMorseRepresentations(String[] words) {

        String[] morse = {
            ".-", "-...", "-.-.", "-..", ".", "..-.",
            "--.", "....", "..", ".---", "-.-", ".-..",
            "--", "-.", "---", ".--.", "--.-", ".-.",
            "...", "-", "..-", "...-", ".--", "-..-",
            "-.--", "--.."
        };

        HashSet<String> set = new HashSet<>();

        // Traverse each word
        for (int i = 0; i < words.length; i++) {

            StringBuilder code = new StringBuilder();

            // Convert each character into Morse code
            for (int j = 0; j < words[i].length(); j++) {

                char ch = words[i].charAt(j);

                // Convert a-z into index 0-25
                int index = ch - 'a';

                code.append(morse[index]);
            }

            // Store unique Morse transformation
            set.add(code.toString());
        }

        return set.size();
    }
}
