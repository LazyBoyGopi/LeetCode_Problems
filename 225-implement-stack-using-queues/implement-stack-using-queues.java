import java.util.*;

class MyStack {
    ArrayDeque<Integer> queue ;
    public MyStack() {
        queue  = new ArrayDeque<>();
    }
    
    public void push(int x) {
        queue.add(x);
    }
    
    public int pop() {
        return queue.pollLast();
    }
    
    public int top() {
        return queue.peekLast();
    }
    
    public boolean empty() {
        return queue.size() == 0 ? true : false;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */