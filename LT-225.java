/*
Problem: 225. Implement Stack using Queues
Link: https://leetcode.com/problems/implement-stack-using-queues/

Approach:
1. Create a queue named q using LinkedList.
2. push(x): Add the element to the rear of the queue.
3. pop():
   - Rotate the first n-1 elements to the rear of the queue.
   - The last inserted element reaches the front.
   - Remove and return that element.
4. top():
   - Rotate the first n-1 elements to the rear.
   - Get the front element, which is the stack's top.
   - Add it back to the rear to restore the queue's order.
5. empty(): Return true if the queue is empty; otherwise, return false.

Time Complexity:
- push(): O(1)
- pop(): O(n)
- top(): O(n)
- empty(): O(1)

Space Complexity: O(n)
*/

class MyStack {
    Queue<Integer> q = new LinkedList<>();

    public MyStack() {

    }

    public void push(int x) {
        q.add(x);
    }

    public int pop() {
        for (int i = 0; i < q.size() - 1; i++) {
            q.add(q.remove());
        }

        int val = q.peek();
        q.remove();

        return val;
    }

    public int top() {
        for (int i = 0; i < q.size() - 1; i++) {
            q.add(q.remove());
        }

        int val = q.peek();
        q.add(q.remove());

        return val;
    }

    public boolean empty() {
        return q.size() == 0;
    }
}
