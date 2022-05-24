package com.lyjtest.debug.q59;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author NoobProgrammer
 * @title: Solution
 * @projectName leecode
 */
public class Solution {

    @Test
    public void test() {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        spiralOrder(matrix);

    }

    public int[][] generateMatrix(int n) {
        int time = n / 2;
        int num = 1;
        int startX = 0;
        int startY = 0;
        int[][] res = new int[n][n];
        for (; time > 0; time--) {
            int i = startX;
            int j = startY;
            for (; j < n - startY; j++) {
                res[startX][j] = num++;
            }
            for (; i < n - startX; i++) {
                res[i][j] = num++;
            }
            for (; j > startY; j--) {
                res[i][j] = num++;
            }
            for (; i > startX; i--) {
                res[i][j] = num++;
            }
            startX++;
            startY++;

        }
        return res;
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> resList = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int offset = 0;
        int startX = 0;
        int startY = 0;
        while (resList.size() < m * n) {
            int i = startX;
            int j = startY;
            for (; j < n - startY - 1; j++) {
                resList.add(matrix[startX][j]);
            }
            if (resList.size() == m * n) {
                break;
            }
            for (; i < m - startX - 1; i++) {
                resList.add(matrix[i][j]);
            }
            for (; j > startY; j--) {
                resList.add(matrix[i][j]);
            }
            for (; i > startX; i--) {
                resList.add(matrix[i][j]);
            }
            startX++;
            startY++;
        }
        return resList;
    }

}
