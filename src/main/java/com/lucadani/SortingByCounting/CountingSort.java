package com.lucadani.SortingByCounting;

import java.util.Arrays;
import java.util.Scanner;

public class CountingSort {
    static final int MAX_VALUE = 1000;
    static void printArray(int[] arr) {
        for (var elem : arr) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }

    static int[] countingSort(int[] arr, int n) {
        int[] valuesArray = new int[MAX_VALUE];
        Arrays.fill(valuesArray, 0);
        for (int i = 0; i < n; ++i) {
            ++valuesArray[arr[i]];
        }
        int k = 0;
        for (int i = 0; i < MAX_VALUE; ++i) {
            for (int j = 0; j < valuesArray[i]; ++j) {
                arr[k++] = i;
            }
        }
        return arr;
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
        System.out.print("After sorting: ");
        printArray(countingSort(arr, n));
    }
}
