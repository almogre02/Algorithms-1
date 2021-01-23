package Tests;

/**
 * מחזירה את אורכו של תת מערך עולה ואז יורד
 * 0(2*[n^2 * log(n)])
 */
public class OlaYoredet {

    public static int LBS(int[] arr){
        int tempMax=0;
        int max=0;
        for (int i = 0; i <arr.length-1 ; i++) {
            int a=LISDynamicLen(arr,i);
            int b=LDSDynamicLen(arr,i+1);
            tempMax=a+b;
            //tempMax=LISDynamicLen(arr,i)+LDSDynamicLen(arr,i+1);

            if (tempMax>max)
                max=tempMax;
            tempMax=0;
        }
        return max;
    }


    private static int binarySearchBetween1(int[][] mat, int end, int v) {//0(log(n))
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

    /**
     * dynamic programming of LIS - get the length only (can be done with array instead of matrix)
     * Complexity: O(n*log n)
     */
    public static int LISDynamicLen(int[] arr,int end) {
        int n = arr.length;
        int[][] mat = new int[n][n];
        mat[0][0] = arr[0];
        int len = 1;
        for (int i = 1; i < end; i++) {
            int index = binarySearchBetween1(mat,len,arr[i]);
            mat[index][index] = arr[i];
            if(index == len) len++;
        }
        return len;
    }



    private static int binarySearchBetween2(int[][] mat, int end, int v) {//0(log(n))
        if(v < mat[end-1][end-1]) return end;
        if(v > mat[0][0]) return 0;
        int high = end, low = 0;
        while(low <= high) {
            if(low == high)return low;
            int mid = (low + high)/2;
            if(mat[mid][mid] == v) return mid;
            if(mat[mid][mid] < v) high = mid;
            else low = mid+1;
        }
        return -1;
    }

    /**
     * dynamic programming of LIS - get the length only (can be done with array instead of matrix)
     * Complexity: O(n*log n)
     */
    public static int LDSDynamicLen(int[] arr,int start) {
        int n = arr.length;
        int[][] mat = new int[n][n];
        mat[0][0] = arr[start];
        int len = 1;
        for (int i = start; i < n; i++) {
            int index = binarySearchBetween2(mat,len,arr[i]);
            mat[index][index] = arr[i];
            if(index == len) len++;
        }
        return len;
    }

    public static void main(String[] args) {
        int[] a={12,11,40,5,3,1};
        System.out.println(LBS(a));
    }
}
