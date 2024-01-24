package com.lucadani.SortingByCounting;

import java.util.*;
import java.util.stream.Collectors;

public class RadixSort {
    static void printArray(int[] arr) {
        for (var elem : arr) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }

    static int getMax(int[] arr) {
        List<Integer> arrayList = Arrays.stream(arr).boxed().collect(Collectors.toCollection(ArrayList::new));
        return Collections.max(arrayList);
    }

    static void radixSort(int[] arr, int n) {
        for (int maxi = getMax(arr), exp = 1; maxi / exp > 0; countSort(arr, n, exp), exp *= 10);
    }

    static void countSort(int[] arr, int n, int exp) {
        int[] output = new int[n];
        int[] count = new int[10];
        for (int i = 0; i < n; ++count[(arr[i] / exp) % 10], ++i);
        for (int i = 1; i < 10; count[i] += count[i - 1], ++i);
        for (int i = n - 1; i > -1; output[count[(arr[i] / exp) % 10] - 1] = arr[i], --count[(arr[i] / exp) % 10], --i);
        System.arraycopy(output, 0, arr, 0, n);
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
        radixSort(arr, n);
        System.out.print("After sorting: ");
        printArray(arr);
    }
}
