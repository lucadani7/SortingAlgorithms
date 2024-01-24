package com.lucadani.SortingByComparations;

import com.lucadani.exception.PrintErrorMessageException;

import java.util.Scanner;

public class BubbleSort {
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
    static void bubbleSort(int[] arr, int n) {
        boolean swapped;
        for (int i = 0; i < n - 1; ++i) {
            swapped = false;
            for (int j = 0; j < n - i - 1; ++j) {
                if (arr[j] <= arr[j + 1]) {
                    continue;
                }
                swapValues(arr, j, j + 1);
                swapped = true;
            }
            if (!swapped) {
                break;
            }
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
        bubbleSort(arr, n);
        System.out.print("After sorting: ");
        printArray(arr);
    }
}
