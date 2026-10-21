/*
Problem: 232. Implement Queue using Stacks
Link: https://leetcode.com/problems/implement-queue-using-stacks/

Approach:
1. Create two stacks: st and helper.
2. push(x): Push the element into st.
3. pop(): Move all elements except the last one from st to helper.
   Remove and return the last element of st (the front of the queue).
   Move the remaining elements back from helper to st.
4. peek(): Move all elements except the last one to helper.
   Get the top element of st without removing it.
   Move the remaining elements back to st.
5. empty(): Return true if st is empty; otherwise, return false.

Time Complexity:
- push(): O(1)
- pop(): O(n)
- peek(): O(n)
- empty(): O(1)

Space Complexity: O(n)
*/

class MyQueue {
    Stack<Integer> st = new Stack<>();
    Stack<Integer> helper = new Stack<>();

    public MyQueue() {

    }

    public void push(int x) {
        st.push(x);
    }

    public int pop() {
        while (st.size() > 1) {
            helper.push(st.pop());
        }

        int x = st.pop();

        while (helper.size() > 0) {
            st.push(helper.pop());
        }

        return x;
    }

    public int peek() {
        while (st.size() > 1) {
            helper.push(st.pop());
        }

        int x = st.peek();

        while (helper.size() > 0) {
            st.push(helper.pop());
        }

        return x;
    }

    public boolean empty() {
        return st.size() == 0;
    }
}
