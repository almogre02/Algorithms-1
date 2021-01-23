package Tests;

/**
 * יש ליישם את האלגוריתם המחשב את אורכה של תת-מחרוזת פלינדרומית הארוכה ביותר של המחרוזת הנתונה.
 * 0(m*n) for using LCS function + 0(n) for reversing the String ->>>0(m*n)
 * Method: reverse the given String and than calculate the LCS between the original String and the reversed String.
 */
public class Palindrome {
    static int[][] mat;

    public static String lps(String s) {
        String revers = "";
        String ans = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            revers += s.charAt(i);
        }
        ans=LCS_string(s,revers);
        return ans;
    }


    public static int LCS_length(String X, String Y) {
        int n = X.length() + 1;
        int m = Y.length() + 1;
        mat = new int[n][m];
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    mat[i][j] = mat[i - 1][j - 1] + 1;
                } else {
                    mat[i][j] = Math.max(mat[i - 1][j], mat[i][j - 1]);
                }
            }
        }
        return mat[n - 1][m - 1];
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


    public static void main(String[] args) {
        String str="aubcxctybza";
        String str1="alfalfa";
        String str2="bbbbb";
        System.out.println(lps(str));
        System.out.println(lps(str1));
        System.out.println(lps(str2));

    }
}
