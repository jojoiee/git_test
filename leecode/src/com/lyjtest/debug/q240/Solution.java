package com.lyjtest.debug.q240;

import org.junit.Test;

/**
 * @author NoobProgrammer
 * @title: Solution
 * @projectName leecode
 */

public class Solution {
    @Test
    public void test() {
        int[][] test = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        boolean b = searchMatrix(test, 20);
        System.out.println(b);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        return dfs(matrix, 0, 0, target);

    }

    public boolean dfs(int[][] matrix, int x, int y, int target) {
        if (x < 0 || x > matrix.length || y < 0 || y > matrix[0].length) {
            return false;
        }
        if (target == matrix[x][y]) {
            return true;
        }
        if (target < matrix[x][y]) {
            return false;
        } else {
            boolean down = dfs(matrix, x + 1, y, target);
            boolean right = dfs(matrix, x, y + 1, target);
            return down || right;
        }
    }
}