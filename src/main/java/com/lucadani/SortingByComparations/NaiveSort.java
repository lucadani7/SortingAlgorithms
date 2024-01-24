package com.lucadani.SortingByComparations;

import com.lucadani.exception.PrintErrorMessageException;

import java.util.Scanner;

public class NaiveSort {
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

    static void naiveSort(int[] arr, int n) {
        for (int i = 0; i < n - 1; ++i) {
            int pos = i;
            for (int j = i + 1; j < n; ++j) {
                if (arr[j] < arr[pos]) {
                    pos = j;
                }
            }
            swapValues(arr, pos, i);
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
        naiveSort(arr, n);
        System.out.print("After sorting: ");
        printArray(arr);
    }
}
