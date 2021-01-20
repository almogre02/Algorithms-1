package Tests;


/**
 * Longest Un Common Substring
 * O(m*n)+o(m+n)+o(n) == 0(m*n)+o(2n+m)-->o(m*n)
 */
public class L_not_CS {
    static int[][] mat;

    /**
     * Dynamic programming of LCS - length
     * Complexity: O(m*n) - |X| = n , |Y| = m
     */
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
        int len = LCS_length(X, Y);
        int i = X.length();
        int j = Y.length();
        String ans = "";
        while (len > 0) {
            if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                ans = X.charAt(i - 1) + ans;
                i--;
                j--;
                len--;
            } else {
                if (mat[i - 1][j] > mat[i][j - 1]) {
                    i--;
                } else {
                    j--;
                }
            }
        }
        return ans;
    }

    /**
     * Longest Un Common Substring for String X
     * @param X
     * @param Y
     * @return
     */
    public static String LCS_Un_Common_string(String X, String Y) {
        String common = LCS_string(X, Y);
        String unCommon = "";
        int index = 0;
        for (int i = 0; i < X.length(); i++) {
            if (index<common.length() && X.charAt(i) != common.charAt(index))
                unCommon += X.charAt(i);
            else
                index++;
        }
        return unCommon;
    }

    /**
     * Longest Un Common Substring for String X & String Y
     * @param X
     * @param Y
     * @return
     */
    public static String LCS_Un_Common_string2(String X, String Y) {
        String common = LCS_string(X, Y);
        String unCommonX = "";
        String unCommonY = "";
        int x = 0;
        int y = 0;
        for (int i = 0; i < X.length(); i++) {
            if (x<common.length() && X.charAt(i) != common.charAt(x))
                unCommonX += X.charAt(i);
            else
                x++;

            if (y<common.length() && Y.charAt(i) != common.charAt(y))
                unCommonY += Y.charAt(i);
            else
                y++;
        }
        if (unCommonX.length()>unCommonY.length())
            return unCommonX;
        return unCommonY;
    }

    public static void main(String[] args) {
        String a="vfaiu";
        String b="fsabhu";
        System.out.println(LCS_Un_Common_string(a,b));
        System.out.println(LCS_Un_Common_string(b,a));
        System.out.println(LCS_Un_Common_string2(a,b));
    }
}
