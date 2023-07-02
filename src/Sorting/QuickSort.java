package Sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1, 90, -9, 21, 45};
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    static void quickSort(int[] arr, int start, int end){
        if(start >= end)
            return;

        int pivot = arr[(start+end)/2];
//        int randomIndex = start + (int)(Math.random()*(end-start+1)) ;
//        int pivot = arr[randomIndex];
        int i = start, j = end;
        while(i < j)
        {
            while(arr[i] < pivot)
                i++;
            while(arr[j] > pivot)
                j--;
            if(i < j)
            {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        int k;
        for(k = start ; k <= end ; k++)
            if(arr[k] == pivot)
                break;

        quickSort(arr, start, k-1);
        quickSort(arr, k+1, end);
    }
}
