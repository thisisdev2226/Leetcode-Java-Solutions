/**

* Problem: 682. Baseball Game
* Link: https://leetcode.com/problems/baseball-game/
*
* Approach:
* 1. Use a Stack to store the scores of valid rounds.
* 2. Traverse the operations array:
* * "C": Remove the last valid score using pop().
* * "D": Double the last valid score using peek() and push it.
* * "+": Add the last two valid scores and push their sum.
* ```
   First, pop the top score, peek at the second score,
  ```
* ```
   then push both the original score and their sum.
  ```
* * Otherwise, convert the string into an integer using
* ```
   Integer.parseInt() and push it onto the stack.
  ```
* 3. After processing all operations, pop all scores from
* the stack and calculate their total.
* 4. Return the final sum.
*
* Time Complexity: O(n)
* Space Complexity: O(n)
  */

class Solution {
public int calPoints(String[] operations) {
int n = operations.length;
Stack<Integer> st = new Stack<>();

    for (int i = 0; i < n; i++) {
        String s = operations[i];

        if (s.equals("C")) {
            st.pop();
        } 
        else if (s.equals("D")) {
            st.push(2 * st.peek());
        } 
        else if (s.equals("+")) {
            int top = st.pop();
            int top2 = st.peek();

            int sum = top + top2;

            st.push(top);
            st.push(sum);
        } 
        else {
            st.push(Integer.parseInt(s));
        }
    }

    int sum = 0;

    while (st.size() > 0) {
        sum += st.pop();
    }

    return sum;
}

}
