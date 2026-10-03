package com.leetcode.patterns.tree;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("22. Trie")
class TrieTest {

    private Trie trie;

    @BeforeEach
    void setUp() {
        trie = new Trie();
        trie.insert("apple");
        trie.insert("bad");
        trie.insert("dad");
    }

    @Test
    @DisplayName("search distinguishes words from prefixes")
    void searchVsPrefix() {
        assertTrue(trie.search("apple"));
        assertFalse(trie.search("app"));
        assertTrue(trie.startsWith("app"));
        trie.insert("app");
        assertTrue(trie.search("app"));
        assertFalse(trie.startsWith("xyz"));
    }

    @Test
    @DisplayName("wildcard search with '.'")
    void wildcard() {
        assertTrue(trie.searchWithWildcard(".ad"));
        assertTrue(trie.searchWithWildcard("b.."));
        assertFalse(trie.searchWithWildcard("pad"));
        assertFalse(trie.searchWithWildcard("ba"));
    }
}
