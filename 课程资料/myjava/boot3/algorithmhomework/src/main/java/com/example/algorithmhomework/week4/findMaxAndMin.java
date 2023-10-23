package com.example.algorithmhomework.week4;

/**
 * @PACKAGE_NAME: com.example.algorithmhomework.week4
 * @NAME: findMaxAndMin
 * @USER: jiang000
 * @DATE: 2023/10/11
 **/
public class findMaxAndMin {
    public int[] MaxAndMin(int arr[], int l, int r) {
        int res[] = new int[2];
        if (l + 1 == r) {
            res[0] = arr[l] > arr[l + 1] ? arr[l] : arr[l + 1];
            res[1] = arr[l] > arr[l + 1] ? arr[l + 1] : arr[l];
        }
        else if(l == r){
            res[0] = arr[l];
            res[1] = arr[l];
        }
        else {
            int mid = (l + r) >> 1;
            int[] currLeft = MaxAndMin(arr, l, mid);
            int[] currRight = MaxAndMin(arr, mid + 1, r);
            res[0] = currLeft[0] > currRight[0] ? currLeft[0] : currRight[0];
            res[1] = currLeft[1] > currRight[1] ? currRight[1] : currLeft[1];
        }
        return res;
    }

    public static void main(String[] args) {
        int arr[] = {1, 0, 8};
        findMaxAndMin s1 = new findMaxAndMin();
        int res[] = s1.MaxAndMin(arr,0, arr.length - 1);
        System.out.println("min " + res[1]);
        System.out.println("max " + res[0]);



    }
}
