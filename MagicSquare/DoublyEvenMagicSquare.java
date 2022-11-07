
/**
 * /**
 * This is the class to define doubly even magic square matrix. 
 * this class inherits the property of magic square class by the keyword ' extends' 
 * 
 * */
 
public class DoublyEvenMagicSquare extends MagicSquare {

	DoublyEvenMagicSquare(int nSide) {// constructor with integer variable
		super(nSide);// the invocation of superclass constructor

	}
	int [][]dobuleEvenSquare;// this is 2D array to store odd magic matrix
/**
 *  this method provides the logic to generate double even magic matrix with the following steps.
 *  this method consists of two sub methods. One is to fill the number in order and the other one is to locate the number at specific postion.
 *  1.doubly Even magic Square uses 1:2:1 ratio of matrix for row and column
 *  2.Fill the numbers 1,2,3 n^2 in order
 *  
 *  example : 4 square magic square
 *  1  2  3  4 
 *  5  6  7  8 
 *  9 10 11 12 
 *  13 14 15 16 
 *  
 *  3. place the numbers at the center position(s) of row and column as follows.
 *  in conclusion, a and b are replaced with c and d. e and f are replaced with h and g
 *  1   a  b   4
 *  e   6  7   g
 *  f  10  11  h
 *  13  d  c   16
 */
	
	public void makeMagic()
	{
		makeSquareA(); //this method fills 1,2,3,..n^2 in the order.
		makeSquareB(); //this method locates numbers at specific location.

		this.dobuleEvenSquare=square;

	}

	/**
	 * this is first method to fill the numbers in order.
	 * [i/len] => [0/4=0],[4/4=1],[8/4=2],[12/4=3] : row
	 * [i%len] => [0%4=0],[1%4=1],[2%4=2],[3%/4=3] : column
	 */
	private void makeSquareA()
	{
		int len=square.length;
		for (int i = 0; i < len*len; i++)//
		{			
			square[i/len][i%len]=i+1; // fill the number 1,2,3,4... n^2
		}
	}
	
	/**
	 * this is the second method to locate the numbers at specific positions. (refer to the above 4 magic square matrix example)
	 * There are two for-loops to run for the row and column.
	 * This methond defines the specific location and fill the numbers.
	 */
	private void makeSquareB() {

		int len=square.length;
		for (int i = 0; i < len; i++)//
		{
			for (int j = 0; j < len; j++) {

				if(i>=0 && i<(len/4) || i>=(len/4)*3 && i<len) // For the first and last row
				{
					if(j>=(len/4) && j<(len/4)*3) //For the center of column
					{
						square[i][j]=len*len-(i*len+j);
					}
				}
				else
				{
					if(j>=0 && j<(len/4) || j>=(len/4)*3 && j<len) // For the first coumn or last column 
					{
						square[i][j]=(len*len)-(i*len+j);
					}
				}
			}
		}
	}
	
	/**
	 * this method gets odd magic square
	 * @return return odd magic square
	 */
	public int[][] getSquare() {
		return dobuleEvenSquare;
	}
}
