package com.allen.knowledge.array;

/**
 * 二维数组（矩阵）的花式遍历
 * <p>
 * 1. 设一个 n x n 的二维矩阵表示一个图像，现在将图像顺时针旋转90度，请注意需要原地旋转，不能新建矩阵。
 * <p>
 * 顺时针旋转90度，先计算出主对角线镜像（沿主对角线旋转180度），再反转每一行数据。
 * <p>
 * 逆时针旋转90度，先计算出次对角线镜像（沿次对角线旋转180度），再反转每一行数据。
 */
public class MatrixArray {
    /**
     * 顺时针旋转90度
     *
     * @param matrix 矩阵
     */
    public void clockwiseRotation(int[][] matrix) {
        int length = matrix.length;
        // 主对角线遍历
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int[] ints : matrix) {
            reverse(ints);
        }
    }

    /**
     * 逆时针旋转90度
     *
     * @param matrix 矩阵
     */
    public void anticlockwiseRotation(int[][] matrix) {
        int length = matrix.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[length - j - 1][length - i - 1];
                matrix[length - j - 1][length - i - 1] = temp;
            }
        }

        for (int[] ints : matrix) {
            reverse(ints);
        }
    }


    private void reverse(int[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int temp = array[right];
            array[right] = array[left];
            array[left] = temp;
            left++;
            right--;
        }
    }


}
