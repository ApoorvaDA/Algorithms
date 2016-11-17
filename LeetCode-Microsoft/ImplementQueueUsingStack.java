/*
Implement the following operations of a queue using stacks.

push(x) -- Push element x to the back of queue.
pop() -- Removes the element from in front of queue.
peek() -- Get the front element.
empty() -- Return whether the queue is empty.
Notes:
You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
Depending on your language, stack may not be supported natively.
You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).

Run-time complexity:
push - O(1)
pop and peek - O(2n)
*/

class MyQueue {
    Stack<Integer> in = new Stack<>();
    Stack<Integer> off = new Stack<>();
    
    // Push element x to the back of queue.
    public void push(int x) {
        in.add(x);
    }

    /**
     * Removes the element from in front of queue.
     * 
     * (1) Elements from `in` are popped onto `off`,
     *     thus reversing the stack.
     * (2) The top element is popped from `off`, which
     *     was our bottom element from `in`
     * (3) Elements from `off` are popped onto `in`,
     *     thus re-reversing the stack and maintaining
     *     our invariant (except first-in was popped).
     */
    public void pop() {
        while (!in.empty()) {
            off.add(in.pop());
        }
        off.pop();
        while (!off.empty()) {
            in.add(off.pop());
        }
    }

    /**
     * Get the front element.
     * 
     * (1) Elements from `in` are popped onto `off`,
     *     thus reversing the stack.
     * (2) The top element from `off` is stored in `ans`.
     *     This was our bottom element from `in`.
     * (3) Elements from `off` are popped onto `in`,
     *     thus re-reversing the stack and maintaining
     *     our invariant.
     */
    public int peek() {
        while (!in.empty()) {
            off.add(in.pop());
        }
        int ans = off.peek();
        while (!off.empty()) {
            in.add(off.pop());
        }
        return ans;
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return in.empty();
    }
}