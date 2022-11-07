import java.util.Scanner;

/**
 * this class provides multiple methods to print.
 * this class extends MagicSquare class 
 * this class contains methods to print the following features.
 * 1. for diagonal , it displays equation adding up the elements and shows the sum of both diagonal each
 * 2. for 3 types of magic matrice, it prints magic matrix.
 * 3. for the row user selects, it prints equation adding up the elements and shows the sum of the specific row
 * 4. for the column user selects, it prints equation adding up the elements and shows the sum of the specific column
 */
public class PrintMagicSquare extends MagicSquare {

	static int[][] square;
	static int sumRow;
	static int sumColumn;
	static int SumLeftDiagonal;
	static int sumRightDiagonal;

	static Scanner sc = new Scanner(System.in);

	PrintMagicSquare(int nSide) {
		super(nSide);

	}
/**
 * this method  calculates the sum of the right diagonal
 * this method also display the equation adding up elements
 * @param square matrix is passed down to this argument. 
 */
	public static void sumRightDiagonal(int[][] square) 
	{
		for (int i = 0; i < square.length; i++) {
			System.out.print(+square[i][square.length - i - 1]);
			while (i < square[i].length - 1) {
				System.out.print(" + ");
				break;
			}
			sumRightDiagonal += square[i][square.length - 1 - i];
		}

		System.out.print(" = " + sumRightDiagonal + " (Right Diagonal)\n");
	}
/**
 * this methods calculates the sum of the left diagonal
 * this method also displays the equation adding up elements
 * @param square matrix is passed down to this argument. 
 */
	public static void sumLeftDiagonal(int[][] square) 
	{

		for (int i = 0; i < square.length; i++) {
			System.out.print(square[i][i]);
			while (i < square[i].length - 1) {
				System.out.print(" + ");
				break;
			}
			SumLeftDiagonal += square[i][i];
		}
		System.out.print(" = " + SumLeftDiagonal + " (Left Diagonal)\n");
	}
/**
 * this method prints the row that user selects
 * this methods also displays the equations adding up elements.
 * @param square matrix is passed down to this argument.
 * @param row  it's variable to carry the row number.
 */
	public static void printRow(int[][] square, int row) {
		for (int i = 0; i < square[row].length; i++) {
			System.out.print(square[row][i]);
			while (i < square[row].length - 1) {
				System.out.print(" + ");
				break;
			}
			sumRow += square[row][i];

		}
		System.out.print(" = " + sumRow + "\n");

	}
/**
 * this method prints the column that user selects
 * this methods also displays the equations adding up elements.
 * @param square matrix is passed down to this argument.
 * @param column  it's variable to carry the row number.
 */
	public static void printColumn(int[][] square, int column) {
		for (int i = 0; i < square[column].length; i++) {
			System.out.print(square[i][column]);
			while (i < square[column].length - 1) {
				System.out.print(" + ");
				break;
			}
			sumColumn += square[i][column];
		}
		System.out.print(" = " + sumColumn + "\n");
	}

	/**
	 * this methods prints magic square matrix 
	 * @param square  matrix is passed down to this argument.
	 */
	public static void printSquare(int[][] square) {
		for (int i = 0; i < square.length; i++) {
			for (int j = 0; j < square[0].length; j++) {
				System.out.printf("%6d\t", square[i][j]);
			}
			System.out.println();
		}
	}

}

