package Sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {8, 3, 4, 12, 5, 6, 99, 78, -12, 90, -78};
        mergeSortInPlace(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    static int[] mergeSort(int[] arr){
        if(arr.length <= 1)
            return arr;

        int mid = arr.length/2;

        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        return merge(left, right);
    }

    static int[] merge(int[] first, int[] second){
        int n1 = first.length, n2 = second.length;
        int[] merged = new int[n1+n2];
        int i = 0, j = 0, k = 0;
        while(i < n1 && j < n2){
            if(first[i] <= second[j])
                merged[k++] = first[i++];
            else
                merged[k++] = second[j++];
        }

        while(i<n1)
            merged[k++] = first[i++];

        while(j<n2)
            merged[k++] = second[j++];

        return merged;
    }

    static void mergeSortInPlace(int[] arr, int start, int end){
        if(start >= end)
            return;

        int mid = (end-start)/2+start;

        mergeSortInPlace(arr, start, mid);
        mergeSortInPlace(arr, mid+1, end);

        mergeInPlace(arr, start, mid+1, end);
    }
    static void mergeInPlace(int[] arr, int s, int m, int e){

        int[] merged = new int[e-s+1];
        int i = s, j = m, k = 0;
        while(i < m && j <= e){
            if(arr[i] <= arr[j])
                merged[k++] = arr[i++];
            else
                merged[k++] = arr[j++];
        }

        while(i<m)
            merged[k++] = arr[i++];

        while(j<=e)
            merged[k++] = arr[j++];
        int ind = 0;
        for (int c = s; c <= e; c++) {
            arr[c] = merged[ind++];
        }
    }
}
