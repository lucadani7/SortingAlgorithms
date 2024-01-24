package com.lucadani.SortingByComparations;

import com.lucadani.exception.PrintErrorMessageException;

import java.util.Scanner;

public class HeapSort {
    static void printArray(int[] arr) {
        for (var elem : arr) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }

    static void swapValues(int[] arr, int index1, int index2) {
        boolean condition1 = index1 > -1 && index1 < arr.length;
        boolean condition2 = index2 > -1 && index2 < arr.length;
        if (condition1 && condition2) {
            arr[index1] = arr[index1] ^ arr[index2] ^ (arr[index2] = arr[index1]);
        } else {
            throw new PrintErrorMessageException("Invalid index for swapping...");
        }
    }

    static void insertKTh(int[] arr, int n, int t) {
        int j = t;
        boolean heap = false;
        while (2 * j + 1 < n && !heap) {
            int k = 2 * j + 1;
            if (k < n - 1 && arr[k] < arr[k + 1]) {
                ++k;
            }
            if (arr[j] < arr[k]) {
                swapValues(arr, j, k);
                j = k;
            } else {
                heap = true;
            }
        }
    }

    static void heapSort(int[] arr, int n) {
        for (int t = (n - 1) / 2; t > -1; --t) {
            insertKTh(arr, n, t);
        }
        for (int r = n - 1; r > 0; --r) {
            swapValues(arr, 0, r);
            insertKTh(arr, r, 0);
        }
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
        heapSort(arr, n);
        System.out.print("After sorting: ");
        printArray(arr);
    }
}
