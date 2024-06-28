package org.example.suanfa.tire;

public class TireMain {
    public static void main(String[] args) {
        TrieTree trieTree = new TrieTree(new Node());
        boolean hello = trieTree.add("hello");
        boolean hello1 = trieTree.contains("a");
        System.out.println(hello1);
    }

}










