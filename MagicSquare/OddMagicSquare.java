/**
 * This is the class to define odd magic matrix
 * this class inherits the property of magic square class by the keyword ' extends' 
 * 
 * */
public class OddMagicSquare extends MagicSquare {
	OddMagicSquare(int nSide) { // constructor with integer variable
		super(nSide); // it's invocation of superclass constructore
	}

	int[][]oddSquare; // this is 2D array to store odd magic matrix
	/**
	 * this method provides the logic to generate odd magic matrix with the following steps.
	 * 1. place the number 1 to the row 0 and the center of column 
	 * 2. decrease the index number of row and column by -1 (i.e. [row][column] -> [row-1][column-1])
	 * 3. if the index becomes negative, take the length -1 (i.e. [-1][1] ->[length-1][1])
	 * 4. if the number presents at next position, increase the previsous row by 1 and keep same column index (i.e. [row][column] ->[row+1][column])
	 */
	public void makeMagic()
	{
		int len=square[0].length;
		int x=0; //first row
		int y=len/2; // center of column
		square[x][y]=1; //it's for [first row][center of column] 

		for (int i = 2; i <=len*len; i++) {

			int tempX=x; 
			int tempY=y;
			
			//x=x-1
			if((x-1)<0) // [x] -> [x-1]. if [x-1] is negative then change it to [length-1];
			{
				x=len-1;
			}else
			{
				x--; // if the index is not negative then decrease the index number by -1
			}

			if((y-1)<0) // [y] -> [y-1]. if [y-1] is negative then change it to [length-1];
			{
				y=len-1;
			}else
			{
				y--;
			}
			if(square[x][y]!=0) // if the number is contained at next position
			{
				x=tempX+1; // increase row by 1
				y=tempY; // keep same column index
			}

			square[x][y]=i;
		}
		this.oddSquare=square; // update container
	}
	/**
	 * this method gets odd magic square matrix
	 * @return return odd magic square matrix
	 */
	public int[][] getSquare() { 
		return oddSquare;
	}

}

