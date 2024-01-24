package com.lucadani.SortingByComparations;

import java.util.Scanner;

public class InsertSort {
    static void printArray(int[] arr) {
        for (var elem : arr) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }

    static void insertSort(int[] arr, int n) {
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
            for (; j > -1 && arr[j] > key; --j) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = key;
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
        insertSort(arr, n);
        System.out.print("After sorting: ");
        printArray(arr);
    }
}
