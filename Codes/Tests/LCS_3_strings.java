package Tests;

public class LCS_3_strings {
    static int[][][] mat3;

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
                if(mat3[i-1][j][k] > mat3[i][j-1][k]&&mat3[i-1][j][k] > mat3[i][j][k-1]) {
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
        String a="asfdkgf";
        String b="dgsfdkgdf";
        String c="asfddlfgkd";
        System.out.println(LCS_3_lengths(a,b,c));
        System.out.println(LCS_3_strings(a,b,c));
    }
}

