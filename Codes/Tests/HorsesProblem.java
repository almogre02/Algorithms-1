package Tests;


import java.util.Arrays;
import java.util.Comparator;

/**
 * נתונים 25 סוסים,מהו המספר המינימאלי מרוצים שעלייך לערוך על מנת לאתר את ה3 סוסים המהירים ביותר כאשר בכל מירוץ ניתן לשים עד 5 סוסים
 */
public class HorsesProblem {
    public static class horse {
        private static Object ArrayUtils;
        private String name = "";
        private int speed = 0;
        horse[][] race;

        public horse(String name, int speed) {
            this.name = name;
            this.speed = speed;
        }



        public static horse[] fast_horse(horse[] arr){
            horse[] race1=race(arr,0);
            horse[] race2=race(arr,5);
            horse[] race3=race(arr,10);
            horse[] race4=race(arr,15);
            horse[] race5=race(arr,20);
            horse [][] first_place={race1,race2,race3,race4,race5};
            race(first_place,5);

            return race1;
        }



        public static horse[] race(horse[] arr, int start) {
            int[] temp = new int[5];
            horse[] temp_winners = new horse[3];
            int min = Integer.MAX_VALUE;
            int j = 0;
            for (int i = 0; i < 5; i++)
                temp[i] = arr[i].speed;
            Arrays.sort(temp);
            for (int i = 0; i < temp.length; i++) {
                if (arr[i].speed >= temp[2]) {
                    temp_winners[j] = arr[i];
                    j++;
                }
            }
            horse [] winners=new horse[3];
            if(temp_winners[0].speed>temp_winners[1].speed&&temp_winners[0].speed>temp_winners[2].speed) {
                winners[0] = temp_winners[0];
                if (temp_winners[1].speed > temp_winners[2].speed) {
                    winners[1] = temp_winners[1];
                    winners[2] = temp_winners[2];
                }
                else {winners[1] = temp_winners[2];
                    winners[2] = temp_winners[1];}
            }
            if(temp_winners[1].speed>temp_winners[0].speed&&temp_winners[1].speed>temp_winners[2].speed) {
                winners[0] = temp_winners[1];
                if (temp_winners[0].speed > temp_winners[2].speed) {
                    winners[1] = temp_winners[0];
                    winners[2] = temp_winners[2];
                }
                else {winners[1] = temp_winners[2];
                    winners[2] = temp_winners[0];}
            }
            if(temp_winners[2].speed>temp_winners[0].speed&&temp_winners[2].speed>temp_winners[1].speed) {
                winners[0] = temp_winners[2];
                if (temp_winners[1].speed > temp_winners[0].speed) {
                    winners[1] = temp_winners[1];
                    winners[2] = temp_winners[0];
                }
                else {winners[1] = temp_winners[0];
                    winners[2] = temp_winners[1];}
            }
            return winners;
        }

        public static void race(horse[][] arr,int n){
            Arrays.sort(arr, new Comparator<horse[]>() {
                @Override
                public int compare(horse[] o1, horse[] o2) {
                    if(o1[n-1].speed>o2[n-1].speed){return -1;}
                    if(o1[n-1].speed<o2[n-1].speed){return 1;}
                    return 0;
                }
            });
        }



        public static void main(String[] args) {
            horse a1 = new horse("a", 8);
            horse b1 = new horse("b", 12);
            horse c1 = new horse("c", 3);
            horse d1 = new horse("d", 7);
            horse e1 = new horse("e", 15);
            horse a2 = new horse("a", 8);
            horse b2 = new horse("b", 12);
            horse c2 = new horse("c", 3);
            horse d2 = new horse("d", 7);
            horse e2 = new horse("e", 15);
            horse a3 = new horse("a", 8);
            horse b3 = new horse("b", 12);
            horse c3 = new horse("c", 3);
            horse d3 = new horse("d", 7);
            horse e3 = new horse("e", 15);
            horse a4 = new horse("a", 8);
            horse b4 = new horse("b", 12);
            horse c4 = new horse("c", 3);
            horse d4 = new horse("d", 7);
            horse e4 = new horse("e", 15);
            horse a5 = new horse("a", 8);
            horse b5 = new horse("b", 12);
            horse c5 = new horse("c", 3);
            horse d5 = new horse("d", 7);
            horse e5 = new horse("e", 15);
            horse[] arr={a1, b1, c1, d1, e1,a2, b2, c2, d2, e2,a3, b3, c3, d3, e3,a4, b4, c4, d4, e4,a5, b5, c5, d5, e5};
            horse[] arr1 = {a1, b1, c1, d1, e1};
            horse[] arr2 = {a2, b2, c2, d2, e2};
            horse[] arr3 = {a3, b3, c3, d3, e3};
            horse[] arr4 = {a4, b4, c4, d4, e4};
            horse[] arr5 = {a5, b5, c5, d5, e5};
            horse[][] big={arr1,arr2,arr3,arr4,arr5};
            fast_horse(arr);

        }
    }


}
