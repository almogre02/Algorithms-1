package Tests;

/**
 * מחזירה את רצף האותיות הארוך ביותר, כאשר אותה אות לא יכולה לחזור פעמיים
 * 0(n^2)->במקרה הגרוע מכיוון שזה דומה לשיטת מיון בועות
 */

public class Longest_Sequence {
    public static String The_Longest_Sequence(String str){
        if (str=="")
            return "";
        String temp= ""+str.charAt(0);
        String max="";
        char tempChar;
        int count=1;
        int i=0;
        while (i<str.length()){
            if ((count+i)<str.length() && !temp.contains(""+str.charAt(count+i)) ){
                    temp += str.charAt(count + i);
                    count++;
            }
            else {
                if (temp.length()>max.length())
                    max=temp;
                if (i+1<str.length())
                    temp=""+str.charAt(i+1);
                i++;
                count=1;

            }
        }
        return max;
    }

    public static void main(String[] args) {
        String a="abcabcbb";
        String b="bbbbbb";
        String c="pwwkew";
        System.out.println(The_Longest_Sequence(a));
        System.out.println(The_Longest_Sequence(b));
        System.out.println(The_Longest_Sequence(c));
    }
}
