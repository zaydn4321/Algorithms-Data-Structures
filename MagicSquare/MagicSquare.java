import java.util.Scanner;

/**
 * This class provides a option for user to select odd,Doubly even or Singly
 * even magic square. The class has instant variables to define the matrix and
 * store the size of matrix.
 */
public class MagicSquare {
	int[][] square;
	int nSide;
	Scanner sc = new Scanner(System.in);

	/**
	 * User's input in Main class is used to argument of this constructore. The size
	 * of row and column of matrix is defined by this integer.
	 * 
	 * @param nSide this integer value defines the size of matrix and is passed down
	 *              from the Main.
	 * 
	 */
	MagicSquare(int nSide) {
		this.nSide = nSide;
		this.square = new int[nSide][nSide];

	}

	/**
	 * This method checks conditional option to see if the matrix is odd, doubly
	 * even or singly even matrix. If the remainder of number devided by 2 is equal
	 * to 1 the method defines it as odd square matrix. If the remainder of number devided
	 * by 4 is equal to 0, the method defines it as doubly even square matrix. If the
	 * remainder of number devided by 4 is equal to 2, the method defines it as
	 * singly even square matrix.
	 * 
	 * Since the program is designed to work for the matrix greater than the size of
	 * 3. additional condition is added to comply with. When 'If-statment' is met to
	 * the condition, each object is generated to access to methods. When
	 * 'getSquare' returns the matrix after matrix is maded, it is displayed by the
	 * method of 'printSquare' After display the matrix, right side diagonal and
	 * left side diagonal are calculated The equation adding up the elements is
	 * displayed showing the sum of both diagonal each
	 * 
	 * Next, the program asks user to add the row to sum up each elements. If the row
	 * is input incorrectly, the program returns a message saying' undefined'. Then,
	 * the program asks user to add the column to sum up each elements. If the column
	 * is input correctly, th program display the equation addiing up th elements
	 * and the sum. Or, it returns a message.
	 * 
	 * @param nSide Its' define it as the size of matrix and it is used to determine
	 *              whether the matrix is odd or even.
	 */
	public void MagicSquareOption(int nSide) {

		if (nSide >= 3 && nSide % 2 == 1) { // check if it is odd square matrix.
			OddMagicSquare odd = new OddMagicSquare(nSide); // generate object to access the class
			odd.makeMagic(); // call the method to generate odd magic matrix
			PrintMagicSquare.printSquare(odd.getSquare()); // the matrix is passed down as an argument to be printed
			System.out.println();// to nearly display, skip the one line

			PrintMagicSquare.sumLeftDiagonal(odd.getSquare());// Call the method to calculate the sum of left diagonal.
			PrintMagicSquare.sumRightDiagonal(odd.getSquare());// Call the method to calculate the sum of right diagonal.
			System.out.println();// to nearly display skip the one line

			System.out.print("\nwhich row to sum ? ");// Ask user to row number to display
			int number1 = sc.nextInt();// variable stores the user's input
			if (number1 >= nSide) {// if user's input is out of boundary, it should report 'undefined'
				System.out.println("undefined");
			} else {
				PrintMagicSquare.printRow(odd.getSquare(), number1);// if user's input is correct, display equation and the sum.
																	 
			}

			System.out.print("\nwhich Column to sum ? ");// Ask user to column number to display
			int number2 = sc.nextInt();// variable stores the user's input
			if (number2 >= nSide) {// if user's input is out of boundary, it should report 'undefined'
				System.out.println("undefined");
			} else {
				PrintMagicSquare.printColumn(odd.getSquare(), number2);// if user's input is correct, display equation and the sum.
																		
			}
		} else if (nSide > 3 && nSide % 4 == 0) {// check if it is doubly even square matrix.
			DoublyEvenMagicSquare even = new DoublyEvenMagicSquare(nSide);
			even.makeMagic();
			PrintMagicSquare.printSquare(even.getSquare());
			System.out.println();

			PrintMagicSquare.sumLeftDiagonal(even.getSquare());
			PrintMagicSquare.sumRightDiagonal(even.getSquare());
			System.out.println();

			System.out.print("\nwhich row to sum ? ");
			int number1 = sc.nextInt();
			if (number1 >= nSide) {
				System.out.println("undefined");
			} else {
				PrintMagicSquare.printRow(even.getSquare(), number1);
			}

			System.out.print("\nwhich Column to sum ? ");
			int number2 = sc.nextInt();
			if (number2 >= nSide) {
				System.out.println("undefined");
			} else {
				PrintMagicSquare.printColumn(even.getSquare(), number2);
			}

		} else if (nSide >= 6 && nSide % 4 == 2) {// check if it is singly even square matrix
			SinglyEvenMagicSquare otherEven = new SinglyEvenMagicSquare(nSide);
			otherEven.makeMagic();
			PrintMagicSquare.printSquare(otherEven.getSquare());
			System.out.println();

			PrintMagicSquare.sumLeftDiagonal(otherEven.getSquare());
			PrintMagicSquare.sumRightDiagonal(otherEven.getSquare());
			System.out.println();

			System.out.print("\nwhich row to sum ? ");
			int number1 = sc.nextInt();
			if (number1 >= nSide) {
				System.out.println("undefined");
			} else {
				PrintMagicSquare.printRow(otherEven.getSquare(), number1);
			}

			System.out.print("\nwhich Column to sum ? ");
			int number2 = sc.nextInt();
			if (number2 >= nSide) {
				System.out.println("undefined");
			} else {
				PrintMagicSquare.printColumn(otherEven.getSquare(), number2);
			}
		} else {// the matrix is not odd, doubly even or singly even, notify the user that the
				// program cannot create a magic square of that size.
			System.out.printf("\nCannot create a magic square of the size");
		}
	}

}
