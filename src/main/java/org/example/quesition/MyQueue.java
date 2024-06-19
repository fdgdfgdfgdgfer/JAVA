package org.example.quesition;

import java.util.Stack;

class MyQueue {
    Stack<Integer> original;
    Stack<Integer> temp;

    public MyQueue() {
        original = new Stack<>();
        temp = new Stack<>();
    }

    public void push(int x) {
        original.push(x);
    }

    public int pop() {
        int peek = peek();
         temp.pop();
        return peek;
    }

    public int peek() {
        if (!temp.isEmpty()) {
            return temp.peek();
        }
        if (original.isEmpty()) {
            return -1;
        }
        while (!original.isEmpty()) {
            temp.push(original.pop());
        }
        return temp.peek();
    }

    public boolean empty() {
            if(temp.isEmpty() && original.isEmpty()){
                return false;
            }else {
                return true;
            }

    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(3);
        System.out.println(myQueue.empty());
    }
}
