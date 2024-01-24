package com.lucadani.SortingByDistribution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BucketSort {
    static void printArray(double[] arr) {
        for (var elem : arr) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }

    static void bucketSort(double[] arr, int n) {
        List<Double>[] buckets = new List[n];
        for (int i = 0; i < n; buckets[i] = new ArrayList<>(), ++i);
        for (int i = 0; i < n; buckets[(int) (arr[i] * n)].add(arr[i]), ++i);
        for (int i = 0; i < n; Collections.sort(buckets[i]), ++i);
        int k = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < buckets[i].size(); ++j) {
                arr[k++] = buckets[i].get(j);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double[] arr = new double[n];
        for (int i = 0; i < n; ++i) {
            arr[i] = scanner.nextDouble();
        }
        System.out.print("Before sorting: ");
        printArray(arr);
        bucketSort(arr, n);
        System.out.print("After sorting: ");
        printArray(arr);
    }
}
