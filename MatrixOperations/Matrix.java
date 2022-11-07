/**
 * This class has methods to compute the sum of two matrices ,and the product of two matrices.
 * This class has methods to print the sum of two matrices, and the product of two matrices.
 * The name of matrices are 'matrixA' and 'matrixB'.
 * The method to compute the product of two matrices allows (matrixA x matrixB) and (matrixB x matrixA)
 * Different size of matrices in this program can be exercised. 
 *
 */
public class Matrix {

	int [][] matrixA  = {{1,2},{3,4}};   // Initialize matrixA
	int [][] matrixB = {{5,6},{7,8}};        // Initialize matrixB
	int [][] sum;	                         // Declare variable to store the sum of matrixA and matrixB
	int [][] product;				         // Declare variable to store the product of matrixA x matrixB

	Matrix() // Constructor
	{
		printMatrix_Plus(matrixA,matrixB);	// Display the two pre-defined orginal matrices	
		matrix_Sum(matrixA,matrixB);//Compute the sum of matrixA + matrixB

		System.out.println("\n-------------------");
		printMatrix_Product(matrixA,matrixB);//Display the two pre-defined orginal matrices	
		matrix_Product(matrixA,matrixB);//Compute the product of matrixA x matrixB

		System.out.println("\n-------------------");
		printMatrix_Product(matrixB,matrixA);//Display the two original matrices	
		matrix_Product(matrixB,matrixA);//Compute the product of matrixB x matrixA

	}
	/**
	 * this method multiplies two metrices 
	 * two for-loops are used for row and column each.
	 * this method checks validation if two matrices can be computed for a product
	 * For instance, 2x3 and 3x2 outputs 2x2 matrix.
	 * For instance, 2x3 and 2x3 can't computes as it violates the rule of matrix multiplication.
	 * 
	 * @param m1 the first matrix in 2D array
	 * @param m2 the second matrix in 2D array
	 */

	private void matrix_Product(int[][]m1,int[][]m2)
	{
		product = new int[m1.length][m2[0].length]; //Initialize the size of matrices
		if(m1[0].length==m2.length) // validate if the column size of the first matrix is equal to the row size of the second matrix
		{

			for (int i = 0; i < m1.length; i++) // loop through the row index of the first matrix
			{
				for (int j = 0; j < m2[0].length; j++) // loop through the column index of the second matrix
				{
					for (int k = 0; k < m2.length; k++) // loop through the row index of the second matrix.
					{

						product[i][j] += m1[i][k] * m2[k][j]; // Compute the product of two matrices and store the result.
					}
				}
			}

			for(int i =0; i<m1.length; i++)
			{
				for(int j = 0; j<m2[0].length; j++)
				{

					System.out.printf("%6d",product[i][j]);	//use printf and have space enough to display for 3 digits in each elements
				}
				System.out.println(); //to nearly display, add blank new line.
			}
		}

		else
		{
			System.out.println("     undefined"); //if a product is not possible, display "undefined"
		}

	}


/**
 * this method adds the two matrices 
 * two for-loops are used for row and column each.
 * this method checks validation if two matrices can be computed for the sum.
 * For instance, 3x3 matrix and 2x3 matrix can't computes as it violates the rule
 * @param m1 the first matrix in 2D array
 * @param m2 the second matrix in 2D array
 */
	private void matrix_Sum(int[][] m1,int[][] m2)
	{
		sum = new int [matrixA.length][matrixB.length]; //Initialize the size of matrices

		if(m1.length == m2.length && m1[0].length == m2[0].length) // validate if two matrices can compute for the sum.
		{

			for(int i = 0; i<m1.length; i++) // loop through the row index of the first matrix
			{
				for(int j = 0; j<m1[0].length; j++) // loop through the column index of the second matrix
				{

					sum[i][j] = m1[i][j] + m2[i][j]; //Compute the sum of two matrices and store the result.
				}
			}
			for(int i = 0; i<m1.length; i++)
			{
				for(int j = 0; j<m1[0].length; j++)
				{

					System.out.printf("%6d",sum[i][j]);	//use printf and have space enough to display for 3 digits in each elements
				}
				
				System.out.println(); //to nearly display, add blank new line.
			}
		}
		else
		{
			System.out.println("     undefined"); //if a product is not possible, display "undefined"
		}
	}
/**
 * this method prints the sum of the matrices 
 * @param m1 the first matrix in 2D array
 * @param m2 the second matrix in 2D array
 */
	private void printMatrix_Plus(int[][] m1,int[][]m2)
	{
		//this loop works for the first matrix
		for(int i = 0; i<m1.length; i++) // loop through the row index of the first matrix
		{
			for(int j = 0; j<m1[0].length; j++) // loop through the column index of the second matrix
			{

				System.out.printf("%6d",m1[i][j]); //use printf and have space enough to display for 3 digits in each elements
			}
			System.out.println(" "); //to nearly display, add blank new line.
		}	
		
		System.out.println("+"); // display the addition symbol 
		
		//this loop works for the second matrix
		for(int i =0; i<m2.length; i++) 
		{
			for(int j = 0; j<m2[0].length; j++)
			{

				System.out.printf("%6d",m2[i][j]);	
			}
			
			System.out.println(" ");
		}
		
		System.out.println("=");
	}
/**
 * this method prints the product of the matrices 
 * @param m1 the first matrix in 2D array
 * @param m2 the second matrix in 2D array
 */
	private void printMatrix_Product(int[][] matrixA, int[][] matrixB)
	{
		//this loop works for the second matrix
		for(int i = 0; i<matrixA.length; i++) // loop through the row index of the first matrix
		{
			for(int j = 0; j<matrixA[0].length; j++) // loop through the column index of the second matrix
			{

				System.out.printf("%6d",matrixA[i][j]);	//use printf and have space enough to display for 3 digits in each elements 
			}
			System.out.println(" "); //to nearly display, add blank new line.
		}	
		
		System.out.println("x"); //it displays the multiplication symbol 
		
		//this loop works for the second matrix
		for(int i = 0; i<matrixB.length; i++)
		{
			for(int j = 0; j<matrixB[0].length; j++)
			{

				System.out.printf("%6d",matrixB[i][j]);	
			}
			
			System.out.println(" ");
		}
		
		System.out.println("=");

	}

}	