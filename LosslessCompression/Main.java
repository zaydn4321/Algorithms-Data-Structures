/**
 * 
 * @author: Zayd Nadir
 * Scanner to read text file; use a loop to count letters and store each one in an array
 * 
 * Create a TreeMap that can be used to assign occurences of each character to the character
 * 
 * Print out above TreeMap, then create nodes for each letter which each store the letter and corresponding frequency
 * 
 * Create PriorityQueue that adds newly created Nodes which are then sorted by frequency into a tree
 * 
 * Use recursion to traverse the tree, adding a 1 to the string of binary numbers if 
 * going left, and adding 0 to the string of binary numbers if going right, until every individual letter is reached
 * Use another treemap to map character to its corresponding binary representation and print out each letter and its corresponding binary string
 * 
 * Using the treemap, use the corresponding letters in the message to map each character to its binary representation and print all of the
 * resulting binary strings together, giving the compressed bit pattern.
 */
import java.util.*;
import java.io.*;

public class Main 
{
    //TreeMap to assign each character with corresponding binary string
    private static TreeMap<String, String> map2 = new TreeMap <String, String>();

	public static void main(String[] args) throws Exception
	{
	    //Scanner to read file
		Scanner scan = new Scanner(new FileReader("banana.txt"));
		String message = scan.nextLine();
		ArrayList <String> str = new ArrayList <>();
		//TreeMap to assign each character with corresponding no. of occurences
		TreeMap<String,Integer> map = new TreeMap <String, Integer>();
		for(int i = 0; i < message.length(); i++)
		{
		    str.add(message.substring(i, i+1)); //splits message and stores each character in an array
		    
		}
		for(int i = 0; i < str.size(); i++) //loops through message
		{
		    if(map.containsKey(str.get(i))) //if there is already an occurence of the character in the message,
		    {
		        map.put(str.get(i), map.get(str.get(i))+1); //add 1 to the count for this character
		    }
		    else //otherwise, if there is no occurence of the character in the message,
		    {
		        map.put(str.get(i), 1); //add this character to the treemap and give it a starting count of 1.
		    }
		}
		System.out.println("CHARACTER COUNT:\n" + map + "\n"); //display character count
		PriorityQueue <Node> queue = new PriorityQueue<>(); //PriorityQueue full of Nodes to sort into a tree based on frequency
        for(String s : map.keySet()) //for each element in the treemap of characters and their frequencies
        {
            Node n = new Node(map.get(s), s);//create an instance of Node with the character and its frequency as parameters
            queue.add(n); //add all nodes to the PriorityQueue
        }
        while(queue.size()>1) //While the priorityqueue still has nodes (while the tree is still being built)
        {
            //Take two leaf nodes
            Node n1 = queue.poll();
            Node n2 = queue.poll();
            
            Node x = new Node(n1, n2); //Create a new node above them that that has a frequency of the sum of the two leaf nodes
            queue.add(x);//Add this new node to the PriorityQueue and repeat until the root node is made with the sum of all frequencies.
        }
        System.out.println("CHARACTER ENCODING:");
        System.out.print("{");
        setBitCode(queue.poll(),""); //prints out the binary that each character is mapped to
        System.out.println("}\n");
        System.out.println("COMPRESSED BIT PATTERN:");
        for(int i = 0; i < message.length(); i++) //goes through original message
        {
            System.out.print(map2.get(message.substring(i, i+1))); //using each character as a key, the binary is obtained for each character in the message to compress it.
        }
	}
	
	/**
	 * Method that sets binary code for each character
	 * Takes in each character's node and its current bitcode(for recursion purposes)
	 */
	public static void setBitCode(Node node, String str)
	{
	    //traverse the tree to develop the new bit sequence for each character
	    if(node.character != null && node.leftNode == null && node.rightNode == null) 
	    {
	        map2.put(node.character, str); 
	        System.out.print(node.character + "=" + str + " "); //print out each character and its bitcode
	    }
	    else
	    {
	       // for traveling left node, add a ‘1’ to the sequence
		   // for traveling right node , add a ‘0’ to the sequence
	       setBitCode(node.leftNode, str + "1");
	       setBitCode(node.rightNode, str + "0");
	    }
	}
}
