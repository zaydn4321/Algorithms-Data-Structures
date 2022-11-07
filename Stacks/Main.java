//@author Zayd Nadir

import java.util.*;
public class Main
{
	public static void main(String[] args) {
	    Stack<String> openings = new Stack<>();
	    String temp;
	    Scanner input = new Scanner(System.in);
	    System.out.println("Enter the phrase to validate:");
	    String phrase = input.nextLine();
	    for(int i = 0; i < phrase.length(); i++)
	    {
	        if(phrase.substring(i, i + 1).equals( "("))
	        {
	            openings.push("(");
	        }
	        else if(phrase.substring(i, i + 1).equals("["))
	        {
	            openings.push("[");
	        }
	        else if(phrase.substring(i, i + 1).equals("{"))
	        {
	            openings.push("{");
	        }
	        else if(phrase.substring(i, i + 1).equals("<"))
	        {
	            openings.push("<");
	        }
	        if(phrase.substring(i, i + 1).equals( ")"))
	        {
	            temp = openings.pop();
	            if(!temp.equals("("))
	            {
	                break;
	            }
	        }
	        if(phrase.substring(i, i + 1).equals( "]"))
	        {
	            temp = openings.pop();
	            if(!temp.equals("["))
	            {
	                break;
	            }
	        }
	        if(phrase.substring(i, i + 1).equals( "}"))
	        {
	            temp = openings.pop();
	            if(!temp.equals("{"))
	            {
	                break;
	            }
	        }
	        if(phrase.substring(i, i + 1).equals( ">"))
	        {
	            temp = openings.pop();
	            if(!temp.equals("<"))
	            {
	                break;
	            }
	        }
	    }
	    if(openings.empty())
	    {
	        System.out.println("The phrase is valid!");
	    }
	    else
	    {
	    System.out.println("The phrase is not valid.");
	    }
	}
}


