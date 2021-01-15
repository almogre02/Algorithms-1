package pizza;

public class pizzaProblem {
    /**
     * returns the optimal division for the faster man
     * k=speed of eating
     * Complexity: O(1)
     */
    public static int getNumberOfPieces(double k) {
        if(k == (int)k) return (int)k+1;
        return (int)k+2;
    }
}
