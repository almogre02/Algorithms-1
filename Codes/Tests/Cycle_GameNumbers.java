package Tests;

import java.util.Arrays;

/**
 * נתונה סדרת מספרים הנמצאת על מעגל->שחקן א' בוחר איבר ולאחר מכן משחקים את משחק המספרים הרגיל
 * סה"כ הרווח של שחקן א הוא: a-f,כאשר a הוא האיבר שנבחר וf הוא הרווח של שחקן ב
 * 0(n^3)
 */

public class Cycle_GameNumbers {

    public static int numberGameCycle(int[] arr) { // O(n^3)
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int a = arr[i];
            int[] b = new int[n-1];
            int k = (i+1) % n;
            for (int j = 0; j < n-1; j++) {
                b[j] = arr[k];
                k = (k+1) % n;
            }
            int f = numberGame(b);
            if(a-f > max) max = a-f;
        }
        return max;
    }


    public static int numberGame(int[] arr) {
        int n = arr.length;
        int[][] m = new int[n][n];
        for (int i = 0; i < m.length; i++) {
            m[i][i] = arr[i];
        }
        for (int i = n-1; i >= 0; i--) {
            for (int j = i+1; j < n; j++) {
                m[i][j] = Math.max(arr[i] - m[i+1][j], arr[j] - m[i][j-1]);
            }
        }
        for (int i = 0; i < m.length; i++) {
            System.out.println(Arrays.toString(m[i]));
        }
        return m[0][n-1];
    }

    public static void main(String[] args) {
        int[] b={9,10,8,0,1,4};
        System.out.println(numberGame(b));
    }



}
