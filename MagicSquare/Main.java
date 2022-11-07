import java.util.Scanner;
/** 
 * The program works for 3 types of magic squares.
 * (1) Odd Magic square : This magic squares represents n=2k+1 where k=1,2,3,4,..
 * (2) Doubly Even Magic Square : This magic squares represents n=4k where k=1,2,3,..
 * (3) Singly Even Magic Square : This magic squares represents n=4k+2 where k=1,2,3,...
 * 
 * 
 * @author Brian Oak, Zayd Nadir
 * @version 1.0
 * 
 */


public class Main {

	/**
	 * this is entry point to run program
	 * With Scanner class, program asks user to enter the size of matrix to play.
	 * User's input is used to argurment of constructor
	 * @param args :This is collection of strings.
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter  the side length of the magic square : ");
		int nSide =sc.nextInt();
	
		MagicSquare ms = new MagicSquare(nSide);
		ms.MagicSquareOption(nSide);


	}
	
	
}