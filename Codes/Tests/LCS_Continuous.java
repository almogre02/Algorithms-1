package Tests;

public class LCS_Continuous {
    public static int LCS_Continuous(String a, String b) {
        int count = 0;
        int max = 0;
        int indexA = 0;
        int indexB = 0;

        for (int i = 0; i < a.length(); i++) {
            indexA = i;
            indexB = 0;
            count=0;
            for (int j = 0; j < b.length(); j++) {
                if (indexA<a.length() && indexB<b.length() && a.charAt(indexA++) == b.charAt(indexB++))
                    count++;
                else {
                    indexA = i;
                    indexB = j + 1 - count;
                    if (count>0) {
                        j--;
                        count=0;
                    }
                }

                if (count > max) {
                    max = count;
                }
            }
        }
        return max;
    }
    public static void main (String[]args){
        String a = "12324126";
        String b = "223241";
        System.out.println(LCS_Continuous(a, b));
    }
}
