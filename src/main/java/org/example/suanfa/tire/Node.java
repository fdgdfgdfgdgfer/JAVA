package org.example.suanfa.tire;

import java.util.TreeMap;

public class Node {
    public boolean isWord;
    public TreeMap<Character, Node> next;

    public Node(boolean isWord) {
        this.isWord = isWord;
        next = new TreeMap<>();
    }

    public Node() {
        this(false);
    }
}
