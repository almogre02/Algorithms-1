package Tests;

import java.util.Arrays;

/**
 * מחזירה את תת הסדרה הארוכה ביותר הנמצאת על מעגל
 * o(n^4) -->can improve it to o(n^2)
 */

public class LIS_Cycle {

    public static int[] LISDynamic(int[] arr) {
        int n = arr.length;
        int[][] mat = new int[n][n];
        mat[0][0] = arr[0];
        int len = 1;
        for (int i = 1; i < n; i++) {
            int index = binarySearchBetween(mat,len,arr[i]);
            mat[index][index] = arr[i];
            if(index == len) len++;
            copy(mat,index);
        }
        int[] ans = new int[len];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = mat[len-1][i];
        }
        return ans;
    }

    private static void copy(int[][] mat, int index) {
        for (int i = 0; i < index; i++) {
            mat[index][i] = mat[index-1][i];
        }
    }

    private static int binarySearchBetween(int[][] mat, int end, int v) {
        if(v > mat[end-1][end-1]) return end;
        if(v < mat[0][0]) return 0;
        int high = end, low = 0;
        while(low <= high) {
            if(low == high)return low;
            int mid = (low + high)/2;
            if(mat[mid][mid] == v) return mid;
            if(mat[mid][mid] > v) high = mid;
            else low = mid+1;
        }
        return -1;
    }

    public static int[] CycleLIS(int[] arr){
        int index=0;
        int n=arr.length;
        int sum=0, length=0;
        int[] longest=null;
        for (int i = 0; i <arr.length ; i++) {
            int num=arr[i];
            index=0;
            int[] cycle=new int[arr.length];
            cycle[0]=num;
            for (int j = 1; j <cycle.length ; j++) {
                cycle[j]=arr[(index+i+1)%n];
                index++;
            }
            if (sum<LISDynamic(cycle).length){
                sum=LISDynamic(cycle).length;
                longest= LISDynamic(cycle);
            }
        }
        return longest;
    }


    public static void main(String[] args) {
        int[] a={1,11,2,10,4,5,2,1};
        int[] b={9,10,8,0,1,4,3,7};
        System.out.println(Arrays.toString(CycleLIS(a)));
        System.out.println(Arrays.toString(CycleLIS(b)));
    }

}
