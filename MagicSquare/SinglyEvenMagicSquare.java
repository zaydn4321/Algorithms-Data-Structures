
/**
 * This is the class to define singly even magic square matrix. 
 * this class inherits the property of magic square class by the keyword 'extends' 
 * 
 * */
public class SinglyEvenMagicSquare extends MagicSquare  {
	SinglyEvenMagicSquare(int nSide) {// constructor with integer variable
		super(nSide);// it's invocation of superclass constructore
		
	}
	int[][] singleEvenSquare;

/**
 *  this method provides the logic to generate singly even magic square matrix with the following steps.
 *  this method consists of five sub methods. 
 *  singly magic square matrix needs 4 quardants; square A,B,C and D.
 *  
 *  A  B
 *  C  D
 *  
 *  in for-loop, the follwoing index represents 4 guardants.
 *  
 *  [i][j] -> Square A,              [i][j+length/2] -> Square B,
 *  [i+length/2][j]->Square C,     [i+length/2][j+length/2] -> Square D
 *  
 *  1. the first method fills the number 3 in square A
 *  2. the second method fills the number 1 in square B. Then replace 1 with 2 except for the last column in square B
 *  3. the thrid method maps the number in square A and B. Then replace the numbers in square C and D
 *  4. the fourth method generates odd magic square matrix and add up invididual elements with the numbers in A,B,C and D.
 *  5. the last method multiplies each elements in square A,B,C and D by (length/2)*(length/2)
 *  
 */
	public void makeMagic() 
	{
		makeSquareA(); // it's the first method to fill the number 3 in square A
		makeSquareB(); // it's the second method to fills the number 1 in square B.
		makeSquareCD(); //it's the third method to map elements in A and B then fill the number accordingly in C and D
		makeAll(); // it's the fourth method to multiply elements by (length/2)*(length/2)
		makeAdd();//its is the firth method to generate odd magic square matrix and sum up each elements with the number in A,B,C, and D.
		this.singleEvenSquare=square; // update the matrix
	}
	
	/**
	 * this is fifth method which generates odd magic square matrix 
	 * After having odd magic square matrix , sum up each elements with the number in A,B,C, and D.
	 */
	private void makeAdd() // 
	{
		int len = square.length;// store the matrix size
		OddMagicSquare odd = new OddMagicSquare(len/2); // generate object to access the class to make odd magic matrix.
		odd.makeMagic(); // object calls the method to generate odd magic square matrix
		int[][]oddMagic=odd.getSquare(); // store the matrix

		for (int i = 0; i < len/2; i++) {
			for (int j = 0; j < len/2; j++) {
				// Square A
				square[i][j] +=oddMagic[i][j];
				// Square B
				square[i][j+len/2] +=oddMagic[i][j];
				// Square C
				square[i+len/2][j] +=oddMagic[i][j];
				// Square D
				square [i+len/2][j+len/2] +=oddMagic[i][j];


			}
		}
	}
	/**
	 * this is the fourth method which multiplies each elements in square A,B,C and D by (length/2)*(length/2)
	 * in case of 10 by 10 matrix , the number 25 will be multiplied to each elements.
	 */
	private void makeAll() 
	{
		int len = square.length;
		int m=(len/2)*(len/2);

		for (int i = 0; i < len/2; i++) {
			for (int j = 0; j < len/2; j++) {
				// Square A
				square[i][j] *=m;
				// Square B
				square[i][j+len/2] *=m;
				// Square C
				square[i+len/2][j] *=m;
				// Square D
				square [i+len/2][j+len/2] *=m;
			}
		}
	}
	/**
	 * this is the third method which maps the numbers in square A and B then replace the number in C and D
	 * for instance, 3 in A will be 0 in C , and 0 in A will be 3 in C
	 * for instance, 2 in B will be 1 in D, and 1 in B will be 2 in D.
	 */
	private void makeSquareCD() 
	{
		int len=square.length;
		for (int i = 0; i < len/2; i++) {
			for (int j = 0; j < len/2; j++) {

				
				if(square[i][j]==3) // Map the number in Square A and then replace 3 with 0 in Square C
				{
					square[i+len/2][j]=0;
				}
				else
				{
					square[i+len/2][j]=3;
				}
				
				if(square[i][j+len/2]==2) {// Map the number in Square B then replace 2 with 1 in Square D
					square[i+len/2][j+len/2]=1;
				}
				else
				{
					square[i+len/2][j+len/2]=2;
				}
			}
		}
	}
	
	/**
	 * this is the first method which fills the number 3 in square A.
	 * in this area, keeps last column with 0. one column at the center row needs to be pushed in.
	 */
	private void makeSquareA()
	{
		int len=square.length; 

		for (int i = 0; i < len/2; i++) {
			for (int j = 0; j < len/4; j++) {
				if(i==len/4) {
					square[i][j+1]=3; 
				}
				else
				{
					square[i][j]=3;
				}
			}
		}


	}
	
	/**
	 * this is the second method which fills the number 1 in square B.
	 * After fill all positions with 1, replace 1 with 2 except for the last column
	 */
	private void makeSquareB() 
	{
		int len= square.length;
		for (int i = 0; i < len/2; i++) {
			for (int j = 0; j < len/2; j++) {

				square[i][j+len/2]=1; // fill 1 in square B
			}
		}

		for (int i = 0; i < len/2; i++)
		{ 
			for (int j = 0; j <(len/2)-(len/4-1); j++)

			{
				square[i][j+len/2]=2;  //replace 1 with 2 in square B except for last column
			} 
		}


	}
	
	/**
	 * this method gets odd magic square
	 * @return return odd magic square
	 */
	public int[][] getSquare() {
		return singleEvenSquare;
	}


}