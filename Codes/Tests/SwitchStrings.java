package Tests;

public class SwitchStrings {
    static int[][] mat;


    public static void Switch_between(String X,String Y){
        String common=LCS_string(X, Y);
        int delete=X.length()-common.length();
        int add=Y.length()-common.length();
        System.out.println("the number of deletions is:" + delete +","+"the number of additions is:"+add );
    }


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

    public static void main(String[] args) {
        String a="abcdefh";
        String b="bcefg";
        System.out.println(LCS_string(a,b));
        Switch_between(a,b);

    }
}
