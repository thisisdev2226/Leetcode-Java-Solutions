/*
Problem: 557. Reverse Words in a String III
Link: https://leetcode.com/problems/reverse-words-in-a-string-iii/

Approach:

* Convert the string into a character array.
* Use two pointers to identify each word.
* Whenever we find a space or reach the end:

  * Reverse the current word using two pointers.
  * Move start to the beginning of the next word.
* Finally, convert the character array back to String.

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {
public String reverseWords(String s) {

    char[] arr = s.toCharArray();
    int start = 0;

    for (int end = 0; end <= arr.length; end++) {

        // End of word
        if (end == arr.length || arr[end] == ' ') {

            int left = start;
            int right = end - 1;

            // Reverse current word
            while (left < right) {
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;

                left++;
                right--;
            }

            // Move to next word
            start = end + 1;
        }
    }

    return new String(arr);
}

}

