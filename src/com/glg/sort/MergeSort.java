package com.glg.sort;

import java.util.Arrays;

/*
 * 归并排序
 *
 * */
public class MergeSort {


    public int[] mergeSort(int[] array) {
        if (array.length < 2) {
            return array;
        }
        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);

        int[] a = mergeSort(left);
        int[] b = mergeSort(right);

        return merge(a, b);
    }

    // 有序合并
    public int[] merge(int[] a, int[] b) {
        int[] newArray = new int[a.length + b.length];
        for (int index = 0, i = 0, j = 0; index < newArray.length; index++) {
            if (i >= a.length) {
                newArray[index] = b[j++];
            } else if (j >= b.length) {
                newArray[index] = a[i++];
            } else if (a[i] <= b[j]) {
                newArray[index] = a[i++];
            } else {
                newArray[index] = b[j++];
            }
        }

        return newArray;
    }

    public static void main(String[] args) {
        int[] array = {6,9,8,1,7,4,6,3};
        for (int i : new MergeSort().mergeSort(array)) {
            System.out.println(i);
        }
    }
}
