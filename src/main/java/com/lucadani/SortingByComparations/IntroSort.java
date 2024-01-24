package com.lucadani.SortingByComparations;

import com.lucadani.exception.PrintErrorMessageException;

import java.util.Scanner;

public class IntroSort {
    private final int[] array;
    private int n;

    public IntroSort(int n) {
        array = new int[n];
        this.n = 0;
    }

    void appendData(int temp) {
        array[n++] = temp;
    }

    void maxHeap(int index, int heapN, int begin) {
        int temp = array[begin + index - 1];
        while (index <= heapN / 2) {
            int child = 2 * index;
            if (child < heapN && array[begin + child - 1] < array[begin + child]) {
                ++child;
            }
            if (temp >= array[begin + child - 1]) {
                break;
            }
            array[begin + index - 1] = array[begin + child - 1];
            index = child;
        }
        array[begin + index - 1] = temp;
    }

    void heapSort(int begin, int end) {
        int heapN = Math.abs(begin - end);
        for (int i = heapN / 2; i > 0; --i) {
            maxHeap(i, heapN, begin);
        }
        for (int i = heapN; i > 0; --i) {
            swapValues(array, begin, begin + i);
            maxHeap(1, i, begin);
        }
    }

    void insertSort(int begin, int end) {
        for (int i = begin; i <= end; ++i) {
            int key = array[i];
            int j = i;
            for (; j > begin && array[j - 1] > key; --j) {
                array[j] = array[j - 1];
            }
            array[j] = key;
        }
    }

    int findPivot(int a, int b, int c) {
        int maxi = Math.max(Math.max(array[a], array[b]), array[c]);
        int mini = Math.min(Math.min(array[a], array[b]), array[c]);
        int median = maxi ^ mini ^ array[a] ^ array[b] ^ array[c];
        if (median == array[a]) {
            return a;
        } else if (median == array[b]) {
            return b;
        } else {
            return c;
        }
    }

    int partition(int begin, int end) {
        int pivot = array[end];
        int i = begin - 1;
        for (int j = begin; j < end; ++j) {
            if (array[j] > pivot) {
                continue;
            }
            ++i;
            swapValues(array, i, j);
        }
        swapValues(array, i + 1, end);
        return i + 1;
    }

    void sortData() {
        int depthLimit = (int) (2 * Math.floor(Math.log(n) / Math.log(2)));
        sortDataUtil(0, n - 1, depthLimit);
    }

    private void sortDataUtil(int begin, int end, int depthLimit) {
        if (end - begin < 17) {
            insertSort(begin, end);
        } else {
            if (depthLimit == 0) {
                heapSort(begin, end);
                return;
            }
            --depthLimit;
            int pivot = findPivot(begin, (begin + end) / 2 + 1, end);
            swapValues(array, pivot, end);
            int partitionIndex = partition(begin, end);
            sortDataUtil(begin, partitionIndex - 1, depthLimit);
            sortDataUtil(partitionIndex + 1, end, depthLimit);
        }
    }

    void printArray() {
        for (var elem : array) {
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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        IntroSort introSort = new IntroSort(n);
        for (int i = 0; i < n; ++i) {
            introSort.appendData(scanner.nextInt());
        }
        System.out.print("Before sorting: ");
        introSort.printArray();
        introSort.sortData();
        System.out.print("After sorting: ");
        introSort.printArray();
    }
}
