package com.lucadani.SortingByComparations;

import java.util.Scanner;

public class MergeSort {
    static void printArray(int[] arr) {
        for (var elem : arr) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }

    static void mergeSort(int[] arr, int begin, int end) {
        if (begin < end) {
            int m = (begin + end) / 2;
            mergeSort(arr, begin, m);
            mergeSort(arr, m + 1, end);
            merge(arr, begin, m, end);
        }
    }

    static void merge(int[] arr, int begin, int m, int end) {
        int[] leftArray = new int[m - begin + 1];
        int[] rightArray = new int[end - m];
        System.arraycopy(arr, begin, leftArray, 0, m - begin + 1);
        System.arraycopy(arr, m + 1, rightArray, 0, end - m);
        int i = 0, j = 0, k = begin;
        for (; i <= m - begin && j < end - m; ++k) {
            arr[k] = Math.min(leftArray[i], rightArray[j]);
            if (leftArray[i] <= rightArray[j]) {
                ++i;
            } else {
                ++j;
            }
        }
        for (; i <= m - begin; arr[k++] = leftArray[i++]);
        for (; j < end - m; arr[k++] = rightArray[j++]);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; ++i) {
            arr[i] = scanner.nextInt();
        }
        System.out.print("Before sorting: ");
        printArray(arr);
        mergeSort(arr, 0, n - 1);
        System.out.print("After sorting: ");
        printArray(arr);
    }
}
