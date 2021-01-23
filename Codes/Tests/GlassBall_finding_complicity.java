package Tests;

/**
 * returns the number of steps we throws the ball
 * מחזירה את מספר הפעמים שאנו נצטרך לזרוק את הכדור עד למציאת הקומה המינימאלית שבה הכדור יישבר
 * 0(sqrt(2*n))
 */

public class GlassBall_finding_complicity {

    public static int glassBall2(int[] floors, int ball) {//O(sqrt(n)) - sqrt(2*n) ===sqrt(2*n)
        int n = floors.length;
        int step = 1;
        int count=0;
        while((step*(step+1))/2 < n) {
            step++;
        }
        int currentFloor = step;
        boolean isBreak = false;
        while(!isBreak) {
            count++;
            if(floors[currentFloor] > ball) {
                currentFloor = currentFloor - step + 1;
                while(!isBreak) {
                    count++;
                    if(floors[currentFloor] > ball) {
                        return count;
                    }
                    currentFloor++;
                }
            }
            if(currentFloor == n-1) break;
            step--;
            currentFloor += step;
            if(currentFloor > n-1) currentFloor = n-1;
        }
        return count;
    }
    public static int glassBall1(int[] floors, int ball) { //o(n)
        int n = floors.length;
        int currentFloor = floors[0];
        int i=1;
        int count=0;
        boolean isBreak = false;
        while(!isBreak) {
            count++;
            if (ball<currentFloor){
                isBreak=true;
            }
            if (currentFloor==floors[n-1])
                return n-1;
            currentFloor=floors[i++];
        }
        return count;
    }

    public static int glassBall_k(int[] floors,int k,int ball){
        int numChecks=0;
        int min=0;
        int[][] checks=new int[k+1][floors.length+1];
        for (int j = 0; j <floors.length ; j++) {
            checks[0][j]=0;
            checks[1][j]=1;
        }
        for (int i = 2; i <k ; i++) {
            checks[i][0]=0;
            checks[i][1]=1;
            if (floors.length>=2)
                checks[i][2]=2;
            for (int j = 2; j < floors.length ; j++) {
                min= floors.length+1;
                for (int p = 1; p <j-1 ; p++) {
                    min=Math.min(Math.max(checks[i-1][p-1],checks[i][j-p]),min)+1;
                }
                checks[i][j]=min;
            }
        }
        numChecks=checks[k][floors.length];
        return numChecks;
    }

    public static int firstTry(int[] floors){
        int num=floors.length;
        int step = 1;
        while((step*(step+1))/2 < num) {
            step++;
        }
        return step;
    }

    public static void main(String[] args) {
        System.out.println(glassBall2(new int[] {10,20,30,40,50,60,70,80},68));
        System.out.println(firstTry(new int[] {10,20,30,40,50,60,70,80,90,100,111,123,154,178,199}));
       // System.out.println(glassBall_k(new int[] {10,20,30,40,50,60,70,80,90,100},3,88));
    }
}
