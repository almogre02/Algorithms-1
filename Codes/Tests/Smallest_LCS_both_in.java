package Tests;
//2020-moed a targil 1
//מחזיר אץ המחרוזת הכי קצרה המשותפת לx ו y

public class Smallest_LCS_both_in {
    static int mat[][];
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
    public static String the_smallest_string(String X, String Y){
        int len=LCS_length(X,Y);
        int newLen=X.length()-len+Y.length();
        String similar=LCS_string(X,Y);
        String ans="";
        int i=0,j=0,k=0;
        while(newLen>0){
            if (i<X.length()&& j<Y.length()&& X.charAt(i)==similar.charAt(k) && Y.charAt(j)==similar.charAt(k)){
                    ans=ans+similar.charAt(k);
                    i++;
                    j++;
                    k++;
                    newLen--;
                }
            else if (i<X.length()&&X.charAt(i)!=similar.charAt(k)){
                ans=ans+X.charAt(i);
                i++;
                newLen--;
            }
            else{
                if (j<X.length())
                ans=ans+Y.charAt(j);
                j++;
                newLen--;
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        String a="abcbdab";
        String b="bdcaba";
        System.out.println(the_smallest_string(a,b));
    }

}
