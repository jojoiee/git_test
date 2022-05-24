package com.lyjtest.offer.Offer29;

/**
 * @author NoobProgrammer
 * @title: Solution
 * @projectName leecode
 */
public class Solution {
    public static void main(String[] args) {
        int[][] test = {{1,2,3},{4,5,6},{7,8,9}};
        Solution solution = new Solution();
        solution.spiralOrder(test);
    }

    public int[] spiralOrder(int[][] matrix) {
        int col = matrix[0].length - 1;
        int row = matrix.length - 1;
        int[] res = new int[(col + 1) * (row + 1)];
        int startX = 0;
        int startY = 0;
        int index = 0;
        int i;
        int j;
        int offset = 0;
        int maxLength = (col + 1) * (row + 1);
        int length = 0;
        while(true) {
            i = startX;
            j = startY;
            if(length >= maxLength) {
                break;
            }

            for(j = startY; j <= col - offset; j++) {
                res[index++] = matrix[startX][j];
            }
            j--;
            for(i = startX + 1; i <= row - offset; i++) {
                res[index++] = matrix[i][j];
            }
            i--;
            for(j = j - 1; j >= startY + 1; j--) {
                res[index++] = matrix[i][j];
            }
            for(i = i - 1; i >= startX + 1; i--) {
                res[index++] = matrix[i][j];
            }
            offset++;
            startX++;
            startY++;
        }
        return res;

    }
}