package gameNumbers;

/**
 * f(i,j)=max(a[i]-f(i+1,j), a[j]-f(i,j-1))
 * 0(n^2)
 *
 */

public class GameOptimalDynamic {
	int gameArr[];
	int[][]mat;
	public GameOptimalDynamic(int []arr){
		gameArr = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			gameArr[i] = arr[i];
		}
		mat = buildMatrix();
	}
	private int[][]buildMatrix(){
		int n = gameArr.length;
		int [][]mat = new int[n][n];
		for(int i=0; i<n; i++){
			mat[i][i] = gameArr[i];
		}
		for (int i=n-2; i>=0; i--){
			for (int j=i+1; j<n; j++){
				int x = gameArr[i] - mat[i+1][j];
				int y = gameArr[j] - mat[i][j-1];
				mat[i][j] = Math.max(x, y);
			}
		}
		MyLibrary.printIntMatrix(mat);
		return mat;
	}
	//not necessary for the cod
	public int gameStrategy(){
		int i=0, j = gameArr.length - 1;
		int first=0, second=0;
		int firstSum = 0, secondSum = 0;
		for (int k = 0; k < gameArr.length/2; k++) {
			// the first takes a number
			if (gameArr[i]-mat[i+1][j] > gameArr[j] - mat[i][j-1]){
				firstSum = firstSum + gameArr[i];
				first = i++;
			}
			else{
				firstSum = firstSum + gameArr[j];
				first = j--;
			}
			// the second takes a number
			if (i != j){//j>0 && i<gameArr.length-1){
				if (gameArr[i]- mat[i+1][j] > gameArr[j] - mat[i][j-1]){
					secondSum = secondSum + gameArr[i];
					second = i++;
				}
				else{
					secondSum = secondSum + gameArr[j];
					second = j--;
				}
			}
			else{//j=0 or i=gameArr.length-1, the second takes the last element
				second = j;
				secondSum = secondSum + gameArr[j];
			}
			System.out.print((first+1)+"->"+(second+1)+"->");
			System.out.println("first: gameArr["+first+"] = "+gameArr[first]+
					", second: gameArr["+second+"] = "+gameArr[second]);
		}
		System.out.println();
		System.out.println("firstSum = "+firstSum+", secondSum = "+secondSum+", diff = "+(firstSum-secondSum));
		return firstSum;
	}
	public static void main(String[] args) {
		int[] test={1,3,6,1,3,6};
		System.out.println(new GameOptimalDynamic(test));
		//int[] arr={1,2,3,4};
		//int[] arr={4,3,2,1};
		//int arr[] = {5,10,20,1};
		//int arr[] = {5,20,10,1};
		//int arr[] = {1,3,6,1,3,6};
		//int arr[] = {6,3,1,6,3,1};
		//int arr[] = {1, 5, 3, 3, 5, 3}; 
		//int arr[] = {3, 5, 3, 3, 5, 1}; 
		// int []arr = {7, 1, 3, 9, 6, 0, 3, 2, 2, 7};
		//int arr[] = {3, 5, 3, 3, 5, 1}; 
		//int arr[] = {48, 70, 1, 8, 5, 35};
		//int arr[] = {54, 16, 78, 0, 40, 76, 80, 87}; 
		int arr[] = {54, 162, 78, 44,140, 76, 100, 87};
		//int arr[] = {4, 3, 0, 4, 5, 3};
		//int arr []  =  { 6, 9, 1, 2, 16, 28};
		//int arr []  =  { 6, 9, 1, 2, 16, 8};
		//int arr []  =  {3, 4, 6, 2, 1, 5};
		//int arr []  =  {3, 4, 6, 2, 1, 5, 8, 4};
		//int arr []  =  {6, 9, 1, 2, 16, 12};
		//int arr []  = {20, 30, 2, 2, 2, 10};
		
		int size = 8;
		//int arr[] = MyLibrary.randomIntegerArray(size);
		MyLibrary.printIntegerArray(arr);
		System.out.println();
		GameOptimalDynamic game = new GameOptimalDynamic(arr);
		game.gameStrategy();
	}
}
/** the first example
1, 3, 6, 1, 3, 6, 

1, 2, 4, 3, 0, 6, 
0, 3, 3, -2, 5, 1, 
0, 0, 6, 5, 4, 2, 
0, 0, 0, 1, 2, 4, 
0, 0, 0, 0, 3, 3, 
0, 0, 0, 0, 0, 6, 
first: gameArr[5] = 6, second: gameArr[4] = 3
first: gameArr[0] = 1, second: gameArr[3] = 1
first: gameArr[2] = 6, second: gameArr[1] = 3
firstSum = 13, secondSum = 7, diff = 6
=============================================
the second example

1, 5, 3, 3, 5, 3, 

1, 4, -1, 4, 1, 2, 
0, 5, 2, 5, 0, 3, 
0, 0, 3, 0, 5, 2, 
0, 0, 0, 3, 2, 1, 
0, 0, 0, 0, 5, 2, 
0, 0, 0, 0, 0, 3, 
first: gameArr[5] = 3, second: gameArr[4] = 5
first: gameArr[3] = 3, second: gameArr[2] = 3
first: gameArr[1] = 5, second: gameArr[0] = 1
firstSum = 11, secondSum = 9, diff = 2

*/
