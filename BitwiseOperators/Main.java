import java.util.*;

//By: Zayd

public class Main
{
    private static String answer;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] numz;
		String in;
		System.out.println("Fill in the blank:");
		for(int i = 0; i < 3; i++) {
		    numz = generator();
		    System.out.println(equationGenerator(numz[0], numz[1], numz[2], numz[3]));
		    in = input.nextLine();
		    if(in.equals(answer))
		    {
		        System.out.println("That Works!      Possible Answer:" + answer);
		        
		    } else {
		        System.out.println("That did not work.           Possible Answer:" + answer);
		    }
		}
		
	    
		
	}
	
	public static int[] generator() {
	    int num1 = (int)(10 * Math.random());
	    int num2 = (int)(10 * Math.random());
	    int blank = (int)(4 * Math.random() + 1);
	    int opr = (int)(4 * Math.random());
	    int[] nums = {num1, num2, blank, opr};
	    return nums;
	}
	public static String equationGenerator(int num1, int num2, int blank, int opr)
	{
	    String[] ops = {"&", "|", "^", "<<"};
	    String str = "";
	    int bitwise = 0;
	    if(blank != 4) {
	        if(opr == 0) {
	            bitwise = (num1 & num2);
	        }
	        if(opr == 1) {
	            bitwise = (num1 | num2);
	        }
	        if(opr == 2) {
	            bitwise = (num1 ^ num2);
	        }
	        if(opr == 3) {
	            bitwise = (num1 << num2);
	        }
	    }
	    
	    if(blank == 1)
	    {
	        str = "__ " + ops[opr] + " " +  num2 + " == ";
	        answer = "" + num1;
	    }
	    if(blank == 2)
	    {
	        str = num1 + " __ " + num2 + " == ";
	        answer = "" + ops[opr];
	    }
	    if(blank == 3)
	    {
	        str = num1 + " " + ops[opr] + " __ == ";
	        answer = "" + num2;
	    }
	    if(blank == 4)
	    {
	        str = num1 + " " + ops[opr] + " " + num2 + " == __";
	        answer = "" + bitwise;
	    }
	    
	    if(blank != 4) {
	        str += bitwise + "";
	    }
        return str;
	}
}

