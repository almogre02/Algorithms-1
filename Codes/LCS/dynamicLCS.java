package LCS;

import java.util.Vector;

/**
 * LCS - Longest Common Substring
 * returns the LCS of X and Y
 */
public class dynamicLCS {
    static int[][] mat;
    static int[][][] mat3;
    /**
     * Dynamic programming of LCS - length
     * Complexity: O(m*n) - |X| = n , |Y| = m
     */
    public static int LCS_length(String X, String Y) {
        int n = X.length()+1;
        int m = Y.length()+1;
        mat = new int[n][m];
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if(X.charAt(i-1) == Y.charAt(j-1)) {
                    mat[i][j] = mat[i-1][j-1] + 1;
                }
                else {
                    mat[i][j] = Math.max(mat[i-1][j], mat[i][j-1]);
                }
            }
        }
        return mat[n-1][m-1];
    }

    /**
     * Dynamic programming of LCS - string
     * Complexity: O(m*n) - build a matrix|X| = n , |Y| = m . O(m+n) - get the string
     */
    public static String LCS_string(String X, String Y) {
        int len = LCS_length(X,Y);
        int i = X.length();
        int j = Y.length();
        String ans = "";
        while(len > 0) {
            if(X.charAt(i-1) == Y.charAt(j-1)) {
                ans = X.charAt(i-1) + ans;
                i--;
                j--;
                len--;
            }
            else {
                if(mat[i-1][j] > mat[i][j-1]) {
                    i--;
                }
                else {
                    j--;
                }
            }
        }
        return ans;
    }

    /**
     * Dynamic programming of LCS - string - Recursion
     * Complexity: O(m*n) - build a matrix|X| = n , |Y| = m . O(m+n) - get the string
     */
    public String LCS_string_Recursion(String X, String Y) {
        int len = LCS_length(X,Y);
        return LCS_string_Recursion(X,Y,X.length(),Y.length(),len);
    }

    private String LCS_string_Recursion(String X, String Y, int i, int j, int len) {
        if(len == 0) return "";
        if(X.charAt(i-1) == Y.charAt(j-1)) {
            return LCS_string_Recursion(X,Y,i-1,j-1,len-1) + X.charAt(i-1);
        }
        else {
            if(mat[i-1][j] > mat[i][j-1]) {
                return LCS_string_Recursion(X,Y,i-1,j,len);
            }
            else {
                return LCS_string_Recursion(X,Y,i,j-1,len);
            }
        }
    }

    /**
     * Dynamic programming of LCS - all substrings - Recursion
     * Complexity: O(m*n) - build a matrix|X| = n , |Y| = m . O(2^(m+n)) - get the strings
     */
    public Vector<String> LCS_Allstrings(String X, String Y) {
        int len = LCS_length(X,Y);
        Vector<String> ans = new Vector<String>();
        LCS_Allstrings(ans,X,Y,X.length(),Y.length(),len,"");
        return ans;
    }

    private void LCS_Allstrings(Vector<String> ans, String X, String Y, int i, int j, int len,String temp) {
        if(len == 0) {
            if(!ans.contains(temp))ans.add(temp);
            return;
        }
        if(X.charAt(i-1) == Y.charAt(j-1)) {
            LCS_Allstrings(ans,X,Y,i-1,j-1,len-1,X.charAt(i-1) + temp);
        }
        else {
            if(mat[i-1][j] > mat[i][j-1]) {
                LCS_Allstrings(ans,X,Y,i-1,j,len,temp);
            }
            else if(mat[i-1][j] < mat[i][j-1]) {
                LCS_Allstrings(ans,X,Y,i,j-1,len,temp);
            }
            else {

                LCS_Allstrings(ans,X,Y,i-1,j,len,temp);
                LCS_Allstrings(ans,X,Y,i,j-1,len,temp);
            }
        }
    }

//////////////////////////////////////////////////////////////
    public static String LCS_3_strings(String X, String Y, String Z) {
        int len = LCS_3_lengths(X,Y,Z);
        int i = X.length();
        int j = Y.length();
        int k = Z.length();
        String ans = "";
        while(len > 0) {
            if(X.charAt(i-1) == Y.charAt(j-1) && X.charAt(i-1) ==Z.charAt(k-1)) {
                ans = X.charAt(i-1) + ans;
                i--;
                j--;
                k--;
                len--;
            }
            else {
                if(mat3[i-1][j][k] >= mat3[i][j-1][k]&&mat3[i-1][j][k] > mat3[i][j][k-1]) {
                    i--;
                }
                else if (mat3[i][j-1][k] > mat3[i-1][j][k]&&mat3[i][j-1][k] > mat3[i][j][k-1]){
                    j--;
                }
                else
                    k--;
            }
        }
        return ans;
    }

    public static int LCS_3_lengths(String X, String Y, String Z) {
        int n = X.length()+1;
        int m = Y.length()+1;
        int l = Z.length()+1;
        mat3 = new int[n][m][l];
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                for (int k = 1; k < l; k++)
                if(X.charAt(i-1) == Y.charAt(j-1) && X.charAt(i-1) ==Z.charAt(k-1) ) {
                    mat3[i][j][k] = mat3[i-1][j-1][k-1] + 1;
                }
                else {
                    mat3[i][j][k] = Math.max(mat3[i-1][j][k], Math.max(mat3[i][j-1][k], mat3[i][j][k-1]));
                }
            }
        }
        return mat3[n-1][m-1][l-1];
    }

    public static void main(String[] args) {
        String a="1232412";
        String b="243121";
        String c="asfddlfgkd";
        System.out.println(LCS_length(a,b));
        System.out.println(LCS_string(a,b));
        System.out.println(LCS_3_lengths(a,b,c));
        System.out.println(LCS_3_strings(a,b,c));
    }
}