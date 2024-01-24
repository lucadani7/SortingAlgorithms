package com.lucadani.SortingByComparations;

import com.lucadani.exception.PrintErrorMessageException;

import java.util.Random;
import java.util.Scanner;

public class QuickSort {
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

    static int generateRandomNumber(int x, int y) {
        int mini = Math.min(x, y);
        int maxi = Math.max(x, y);
        Random random = new Random();
        return random.nextInt(maxi - mini + 1) + mini;
    }

    static void quickSort(int[] arr, int begin, int end) {
        if (begin < end) {
            int pivotIndex = generateRandomNumber(begin, end);
            int pivot = arr[pivotIndex];
            swapValues(arr, pivotIndex, end);
            int i = begin - 1;
            for (int j = begin; j < end; ++j) {
                if (arr[j] < pivot) {
                    ++i;
                    swapValues(arr, i, j);
                }
            }
            swapValues(arr, i + 1, end);
            quickSort(arr, begin, i);
            quickSort(arr, i + 2, end);
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
        quickSort(arr, 0, n - 1);
        System.out.print("After sorting: ");
        printArray(arr);
    }
}
