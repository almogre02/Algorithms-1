package Tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LIS_all_once {
    public static int[] allOnce(int[] a, int[] b){
        List<Integer> once=new ArrayList<>();
        int count=0;
        for (int i=0;i<b.length;i++){
            if (b[i]==1)
                count++;
        }
        int index=0;
        int[] newArray=new int[count];
        for (int i=0;i<b.length;i++) {
            if (b[i] == 1) {
                newArray[index] = a[i];
                index++;
            }
        }
        return LISDynamic(newArray);
    }

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


    public static void main(String[] args) {
        int[] a={0,5,8,3,4,6,11,9,61};
        int[] b={1,1,1,1,1,1,1,1,1};
        System.out.println(Arrays.toString(allOnce(a,b)));
    }
}
