package Tests;

/**
 * יש למצוא תת סדרה ארוכה ביותר שההפרש בין שני איברים סמוכים שלה לא יעלה על 1 בערך מוחלט
 * 0(n^2)
 */
public class LIS_Diff_1 {
    public static int longestSubseqWithDiffOne(int[] arr){
        int tempIndex=0;
        int count=1;
        int max=0;
        for (int i = 0; i <arr.length ; i++) {
            tempIndex=i;
            for (int j = i+1; j <arr.length ; j++) {
                if (Math.abs(arr[tempIndex]-arr[j])<=1){
                    count++;
                    tempIndex=j;
                }
            }
            if (count>max)
                max=count;
            count=1;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a={10,9,4,5,4,8,6,7,11,12,13};
        System.out.println(longestSubseqWithDiffOne(a));
    }


}
