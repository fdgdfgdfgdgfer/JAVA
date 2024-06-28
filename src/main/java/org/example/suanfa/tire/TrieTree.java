package org.example.suanfa.tire;

import lombok.Getter;

public class TrieTree {

    //trie数
    private Node root;
    @Getter
    //单词个数
    private int size;

    public TrieTree(Node root) {
        this.root = root;
        this.size = 0;
    }


    public boolean add(String world) {
        try {
            Node cur = root;
            add(cur, world, 0);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    /**
     * 递归方法
     */
    public void add(Node node, String word, int index) {
        //终止条件
        if (!node.isWord && index == word.length()) {
            node.isWord = true;
            size++;
        }

        if (word.length() > index) {
            //当前字符
            char c = word.charAt(index);
            if (node.next.get(c) == null) {
                //插入
                node.next.put(c, new Node());
            }
            add(node.next.get(c), word, index + 1);
        }
    }


    public boolean contains(String world) {
        Node cur = root;
        return  contains(cur,world,0);
    }

    /**
     * 查询单词是否存在
     */

    private boolean contains(Node node, String word, int index) {
        /*
            结束条件
         */
        if (index == word.length()) {
            return node.isWord;
        }
        char c = word.charAt(index);
        if (node.next.get(c) == null) {
            return false;
        } else {
            return contains(node.next.get(c), word, index + 1);
        }

    }
}
