package Tests;
//מטריצה המקבלת אפסים ואחדות ומחזירה את הפלוס הכי גדול
public class PlusMatrix {
    public static int mat[][]={{1,0,1,1,1,1,0,1,1,1},{1,0,1,0,1,1,1,0,1,1},{1,1,1,0,1,1,0,1,0,1},{0,0,0,0,1,0,0,1,0,0},{1,0,0,0,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1},{1,0,0,0,1,0,0,1,0,1},{1,0,1,1,1,1,0,0,1,1},{1,1,0,0,1,0,0,0,0,1},{1,0,1,1,1,1,0,1,0,0}};

    public static int plus(int mat[][]){
        int count=0;
        int maxCount=0;
        for (int i=1;i<mat.length-1;i++){
            for (int j=1;j<mat[0].length-1;j++){
                if (mat[i][j]==1){
                    if (mat[i-1][j]==1 && mat[i][j+1]==1 && mat[i+1][j]==1 && mat[i][j-1]==1){
                        count=1;
                        int xright=j+1;
                        int xleft=j-1;
                        int yup=i-1;
                        int ydown=i+1;
                        while(xright<mat[0].length)
                            if(mat[i][xright++]==1)
                                count++;

                        while(xleft>=0)
                            if(mat[i][xleft--]==1)
                                count++;

                        while(ydown<mat.length)
                            if(mat[ydown++][j]==1)
                                count++;

                        while(yup>=0)
                            if(mat[yup--][j]==1)
                                count++;
                    }
                    if(count>maxCount)
                        maxCount=count;
                }
            }
        }
        return maxCount;
    }




    public static void main(String[] args) {
        System.out.println(plus(mat));
    }
}
