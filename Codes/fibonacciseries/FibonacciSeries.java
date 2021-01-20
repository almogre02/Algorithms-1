package fibonacciseries;

/**
 * o(n)
 */
public class FibonacciSeries {

    public static int FibonacciSeries(int n){
        int f1=1;
        int f2=1;
        int sum=0;
        if (n==1 || n==2)
            return f1;
        for (int i = 2; i <n ; i++) {
            sum=f1+f2;
            f1=f2;
            f2=sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(FibonacciSeries(7));
    }
}
