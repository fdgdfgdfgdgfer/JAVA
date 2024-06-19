package org.example.quesition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class MinStack {
    public final static ArrayList<Integer> minStatck = new ArrayList<>();

    public MinStack() {

    }

    public void push(int val) {
        minStatck.add(val);
    }

    public void pop() {
        if (null != minStatck) {
            minStatck.remove(minStatck.size() - 1);
        }
    }

    public int top() {
        return minStatck.get(minStatck.size() - 1);
    }

    public int getMin() {

        return minStatck.stream().min(Integer::compareTo).get();
    }

}

//class MinStack {
//    Stack<Integer> stack;
//    Stack<Integer> minStack;
//
//
//    public MinStack() {
//        stack = new Stack<>();
//        minStack = new Stack<>();
//
//
//    }
//
//    public void push(int val) {
//        stack.push(val);
//        if(!minStack.isEmpty()){
//            int top = minStack.peek();
//            if(val<= top){
//                minStack.push(val);
//            }
//
//        }else{
//            minStack.push(val);
//        }
//    }
//
//    public void pop() {
//
//        int top = stack.pop();
//        int pop = minStack.peek();
//        if(pop == top){
//            minStack.pop();
//        }
//
//
//    }
//
//    public int top() {
//        return stack.peek();
//
//    }
//
//    public int getMin() {
//        return minStack.peek();
//
//    }
//}
//
///**
// * Your MinStack object will be instantiated and called as such:
// * MinStack obj = new MinStack();
// * obj.push(val);
// * obj.pop();
// * int param_3 = obj.top();
// * int param_4 = obj.getMin();
// */
