package com.leetcode.patterns.tree;

/**
 * Pattern 22: Trie (prefix tree). LC 208.
 *
 * <p>O(L) per operation. For alphabets beyond a-z, use {@code Map<Character, Node>}.
 */
public class Trie {

    private static final class Node {
        private final Node[] next = new Node[26];
        private boolean end;
    }

    private final Node root = new Node();

    public void insert(String word) {
        Node node = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (node.next[i] == null) {
                node.next[i] = new Node();
            }
            node = node.next[i];
        }
        node.end = true;
    }

    /** True only if the exact word was inserted. */
    public boolean search(String word) {
        Node node = walk(word);
        return node != null && node.end;
    }

    /** True if any inserted word starts with prefix. */
    public boolean startsWith(String prefix) {
        return walk(prefix) != null;
    }

    /** Supports '.' as a wildcard by branching into every child. LC 211. */
    public boolean searchWithWildcard(String pattern) {
        return wildcard(root, pattern, 0);
    }

    private boolean wildcard(Node node, String pattern, int index) {
        if (node == null) {
            return false;
        }
        if (index == pattern.length()) {
            return node.end;
        }
        char c = pattern.charAt(index);
        if (c == '.') {
            for (Node child : node.next) {
                if (wildcard(child, pattern, index + 1)) {
                    return true;
                }
            }
            return false;
        }
        return wildcard(node.next[c - 'a'], pattern, index + 1);
    }

    private Node walk(String s) {
        Node node = root;
        for (char c : s.toCharArray()) {
            node = node.next[c - 'a'];
            if (node == null) {
                return null;
            }
        }
        return node;
    }
}
