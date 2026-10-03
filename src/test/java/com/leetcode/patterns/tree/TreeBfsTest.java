package com.leetcode.patterns.tree;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.leetcode.patterns.model.TreeNode;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("17. Tree BFS")
class TreeBfsTest {

    @Test
    @DisplayName("level order")
    void levelOrder() {
        assertEquals(List.of(List.of(3), List.of(9, 20), List.of(15, 7)),
                TreeBfs.levelOrder(TreeNode.of(3, 9, 20, null, null, 15, 7)));
        assertTrue(TreeBfs.levelOrder(null).isEmpty());
    }

    @Test
    @DisplayName("right side view")
    void rightSideView() {
        assertEquals(List.of(1, 3, 4), TreeBfs.rightSideView(TreeNode.of(1, 2, 3, null, 5, null, 4)));
        assertEquals(List.of(1, 2, 5), TreeBfs.rightSideView(TreeNode.of(1, 2, null, 5)));
    }

    @Test
    @DisplayName("min depth stops at first leaf")
    void minDepth() {
        assertEquals(2, TreeBfs.minDepth(TreeNode.of(3, 9, 20, null, null, 15, 7)));
        assertEquals(5, TreeBfs.minDepth(TreeNode.of(2, null, 3, null, 4, null, 5, null, 6)));
        assertEquals(0, TreeBfs.minDepth(null));
    }
}
