package com.allen.knowledge;

import com.allen.knowledge.double_pointer.BinarySearch1;
import com.allen.knowledge.double_pointer.LeftBoundBinarySearch;
import com.allen.knowledge.double_pointer.RightBoundBinarySearch;

import org.junit.Test;

/**
 * @Description TODO
 * @Author Allen
 * @Date 07-19-2023 周三 15:02
 */
public class DoublePointerUnitTest {

    @Test
    public void runBinarySearch1() {
        BinarySearch1 binarySearch1 = new BinarySearch1();
        int index = binarySearch1.binarySearch(new int[]{1, 2, 2, 2, 3}, 2);
        System.out.println("Index=" + index);
    }

    @Test
    public void runLeftBoundBinarySearch() {
        LeftBoundBinarySearch leftBoundBinarySearch = new LeftBoundBinarySearch();
        //int i = leftBoundBinarySearch.binarySearch(new int[]{1, 2, 2, 2, 6}, 8);
        int i = leftBoundBinarySearch.binarySearch2(new int[]{1, 2, 2, 2, 6}, 2);
        System.out.println("i=" + i);
    }

    @Test
    public void runRightBoundBinarySearch(){
        RightBoundBinarySearch rightBoundBinarySearch = new RightBoundBinarySearch();
        int i = rightBoundBinarySearch.binarySearch(new int[]{1, 2, 2, 2, 6}, 8);
        //int i = rightBoundBinarySearch.binarySearch2(new int[]{1, 2, 2, 2, 6}, 8);
        System.out.println("i=" + i);
    }

}
