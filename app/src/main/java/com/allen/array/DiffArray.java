package com.allen.array;

/**
 * 差分数组
 */
public class DiffArray {

    private final int[] diffs;

    /**
     * 1、构建diff差分数组
     */
    public DiffArray(int[] numbers) {
        diffs = new int[numbers.length];
        diffs[0] = numbers[0];
        for (int i = 1; i < diffs.length; i++) {
            diffs[i] = numbers[i] - numbers[i - 1];
        }
    }

    /**
     * 2、利用diff数组反推原数组
     */
    public int[] getNumbers() {
        int[] numbers = new int[diffs.length];
        numbers[0] = diffs[0];
        for (int i = 1; i < numbers.length; i++) {
            numbers[i] = diffs[i] + numbers[i - 1];
        }
        return numbers;
    }

    /**
     * 3、给区间[i,j]所有元素进行加减操作
     * 通过diff反推原数组的操作，我们可以知道diff[i]+3 ,那么返回出来的numbers[i...]都会+3，那如果我们将diff[j]-3,
     * 就可以让number[i...j]这个区间+3
     */
    public void increment(int i, int j, int val) {
        if (i <= j && j < diffs.length) {
            diffs[i] += val;
            diffs[j + 1] -= val;
        }
    }


}
