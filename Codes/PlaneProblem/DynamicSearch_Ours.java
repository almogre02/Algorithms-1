package PlaneProblem;

import java.awt.*;

public class DynamicSearch_Ours {

    static class Node {
        int right, down, price, numOfPaths;

        public Node(int right, int down) {
            this.right = right;
            this.down = down;
        }
    }

    /**
     * build the matrix contains the price to get each point (from (0,0))
     * and the number of shortest path until each point
     * Complexity: O(n*m)
     */
        public static int minPrice(Node[][] mat,Point p1,Point p2) {
            int n = mat.length, m = mat[0].length;
            mat[0][0].price = 0;
            mat[0][0].numOfPaths = 1;
            for (int i = 1; i < n; i++) { mat[i][0].price = mat[i-1][0].price + mat[i-1][0].down; mat[i][0].numOfPaths = 1;}
            for (int i = 1; i < m; i++) { mat[0][i].price = mat[0][i-1].price + mat[0][i-1].right; mat[0][i].numOfPaths = 1;}
            mat=minPriceWithDeadArea(mat,p1,p2);
            for (int i = 1; i < n; i++) {
                for (int j = 1; j < m; j++) {
                    int fromUp = mat[i-1][j].price + mat[i-1][j].down;
                    int fromLeft = mat[i][j-1].price + mat[i][j-1].right;
                    mat[i][j].price = Math.min(fromUp,fromLeft);
                    if(fromUp < fromLeft) {mat[i][j].numOfPaths = mat[i-1][j].numOfPaths;}
                    else if(fromUp > fromLeft) {mat[i][j].numOfPaths = mat[i][j-1].numOfPaths;}
                    else mat[i][j].numOfPaths = mat[i-1][j].numOfPaths + mat[i][j-1].numOfPaths;
                }
            }
            return mat[n-1][m-1].price;
        }

    /**
     * returns one of shortest path - induction
     * Complexity: O(n+m) - but need to build the matrix first in O(n*m)
     */
        private static String path(Node[][] mat) {
            int i = mat.length-1, j = mat[0].length-1;
            String ans = "";
            while(i != 0 && j != 0) {
                if(mat[i-1][j].price + mat[i-1][j].down < mat[i][j-1].price + mat[i][j-1].right) {
                    ans = "1" + ans;
                    i--;
                }
                else {
                    ans = "0" + ans;
                    j--;
                }
            }
            while(i != 0) {
                ans = "1" + ans;
                i--;
            }
            while(j != 0) {
                ans = "0" + ans;
                j--;
            }
            return ans;
        }

    /**
     * return the minimal price from point (p1,q1) to (p2,q2)
     * Complexity: O(n*m)
     */
        public static int minPriceBetween(Node[][] mat, Point p1, Point p2) {
            int n = p2.y - p1.y + 1, m = p2.x - p1.x + 1;
            mat[p1.y][p1.x].price = 0;
            for (int i = p1.y + 1; i < p1.y + n; i++) { mat[i][p1.x].price = mat[i-1][p1.x].price + mat[i-1][p1.x].down;}
            for (int i = p1.x + 1; i < p1.x + m; i++) { mat[p1.y][i].price = mat[p1.y][i-1].price + mat[p1.y][i-1].right;}
            for (int i = p1.y + 1; i < p1.y + n; i++) {
                for (int j = p1.x + 1; j < p1.x + m; j++) {
                    mat[i][j].price = Math.min(mat[i-1][j].price + mat[i-1][j].down, mat[i][j-1].price + mat[i][j-1].right);
                }
            }
            return mat[p2.y][p2.x].price;
        }

        public static boolean isOnMinPath(Node[][] mat, Point p1, Point p2) {
            if(p2.x <= p1.x && p2.y <= p1.y) {
                Point t = p1;
                p1 = p2;
                p2 = t;
            }
            if(p1.x <= p2.x && p1.y <= p2.y) {
                int allPrice = minPriceBetween(mat, new Point(0,0), new Point(mat.length-1,mat[0].length-1));
                int toP1 = minPriceBetween(mat, new Point(0,0), p1);
                int p1toP2 = minPriceBetween(mat, p1, p2);
                int p2to = minPriceBetween(mat, p2, new Point(mat.length-1,mat[0].length-1));
                if(allPrice == toP1 + p1toP2 + p2to) return true;
                else return false;
            }
            else return false;
        }

    /**
     * creates a dead area in the matrix between 2 points
     */
        public static Node[][] minPriceWithDeadArea(Node[][] m,Point p1,Point p2){
            if (p1.x==0 && p1.y==0 && p2.y==0 && p2.y==0)
                return m;
            if(p2.x <= p1.x && p2.y <= p1.y) {
                Point t = p1;
                p1 = p2;
                p2 = t;
            }
            if(p1.x <= p2.x && p1.y <= p2.y) {
                for (int i = p1.x;  i <= p2.x ; i++) {
                    for (int j = p1.y; j <=p2.y ; j++) {
                        m[i][j].price=999999;
                    }
                }
            }
            return m;
        }

        public static void main(String[] args) {
            Node[][] mat = {
                    {new Node(1,5),new Node(4,1),new Node(0,6)},
                    {new Node(4,7),new Node(2,5),new Node(0,3)},
                    {new Node(1,0),new Node(2,0),new Node(0,0)}};
            System.out.println(minPrice(mat,new Point(0,1),new Point(1,2)));
            System.out.println(isOnMinPath(mat,new Point(1,1),new Point(1,2)));
        }
    }
