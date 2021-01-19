package Tests;

import java.util.Vector;

public class getAllMaxSubSquares {
    /**
     * returns the biggest square contains ones
     * Complexity: O(n*m)
     */
    public static int getAllMaxSubSquares(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int subCount=0;
        int[][] help = new int[n][m];
        int max = 0,imax = 0,jmax = 0;
        for (int i = 0; i < n; i++) {
            help[i][0] = mat[i][0];
        }
        for (int i = 0; i < m; i++) {
            help[0][i] = mat[0][i];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if(mat[i][j] == 1) {
                    help[i][j] = min(help[i][j-1],help[i-1][j],help[i-1][j-1]) + 1;
                    if(help[i][j] > max) {
                        max = help[i][j];
                        jmax = j-max+1;
                        imax = i-max+1;
                        subCount=1;
                    }
                    else if (help[i][j] == max)
                        subCount++;
                }
            }
        }
        if(max != 0)System.out.println("Max square length is - " + max + ", start at: (" + imax + "," + jmax +")");
        return subCount;
    }

    private static int min(int i, int j, int k) {
        if(i <= j && i <= k) return i;
        if(j <= i && j <= k) return j;
        if(k <= i && k <= j) return k;
        else return -1;
    }

    public static void main(String[] args) {
        int[][] a={ {0,0,1,0,1}
                ,{0,1,1,1,1}
                ,{1,1,1,1,1}
                ,{0,1,1,1,1}
                ,{0,0,1,0,1}
        };
        System.out.println(getAllMaxSubSquares(a));
    }
}
