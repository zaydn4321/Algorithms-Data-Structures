//do-while loop on lines 41-69
//@author: Zayd Nadir
import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String[] args) throws Exception
	{
		Scanner scan = new Scanner(new FileReader("graphs.dat")); //read in file with characters and their connections
        int numTestCases = scan.nextInt(); //number of following test cases
        
        //map to assign each character to an ArrayList of the characters it is connected to
        TreeMap<Character, ArrayList<Character>> tm = new TreeMap<Character, ArrayList<Character>>(); 
        //map to assign each character to a boolean, with the boolean determining whether the character has been visited in the bfs search algorithim
        TreeMap<Character, Boolean> tm2 = new TreeMap<Character, Boolean>(); 
        scan.nextLine();
        System.out.println("Nodes   : Shortest Path");
        System.out.println("-----------------------");
        for(int i = 0; i < numTestCases; i++) //loops through each test case
        {
            String[] edges = scan.nextLine().split(" "); //splits every edge specified by file
            Character c = ' ';
            for(int j = 0; j < edges.length; j++)
            {
                c = edges[j].charAt(0);
                tm.put(c, new ArrayList<Character>()); //put the character at the 0th index of each connection into the treeMap as a key
                tm2.put(c, false); //identify each character as not searched yet
                c = edges[j].charAt(1);
                tm.put(c, new ArrayList<Character>()); //put the character at the first index of each connection into the treeMap as a key
                tm2.put(c, false); //identify each character as not searched through yet

            }
            for(int x = 0; x < edges.length; x++)
            {
                tm.get(edges[x].charAt(1)).add(edges[x].charAt(0)); //assign the character at the 0th index to the 1st index character's ArrayList
                tm.get(edges[x].charAt(0)).add(edges[x].charAt(1)); //assign the character at the 1st index to the 0th index character's ArrayList
            }
            ArrayList<Character> nextNode = new ArrayList<Character>(); //stores the nodes that will be visited next in the search process
            String testCase = scan.nextLine();
            nextNode.add(testCase.charAt(0)); //add starting character of testcase to queue, so that we start searching from there first
            nextNode.add('*'); //after going through every 'layer' of connections, add a * so that we know that we have searched through one node
            char chr = testCase.charAt(1); //character to find
            tm2.put(nextNode.get(0), true); //declare first node as already visited
            int count = 0; //stores length of path
            do //do-while loop
            {
                char n = nextNode.get(0);//node to be searched
                if(nextNode.get(0) == '*') //if reached the end of a layer
                {
                    count++; //add to count
                    nextNode.add('*');//add another * to indicate another layer
                    nextNode.remove(0);//remove the existing *
                    n = nextNode.get(0); //new node to be searched is the following character
                    if(n == '*') //if there are two ** in a row, this condition will be passed, meaning the end of the graph has been reached
                    {
                        count = -1; //store length as -1 as there is no connection
                        break; //break the loop
                    }
                }
                for(int y = 0; y < tm.get(n).size(); y++) //go through all connections of character being searched
                {
                    if(!tm2.get(tm.get(n).get(y))) //if the current node has not already been searched
                    {
                        nextNode.add(tm.get(n).get(y)); //add its connections to the queue
                        tm2.put(tm.get(n).get(y), true); //consider its connections already searched
                    }
                }
                nextNode.remove(0); //take the current node being searched out of nextNode list
                if(n == chr)
                {
                    break; //once we have found the character we are looking for, break out of the loop
                }
            } while(!nextNode.isEmpty()); //do-while loop, loops through nextNode until it is empty
            if(count != -1) //if count is -1 there is no connection
            {
                System.out.println(testCase.charAt(0) + " and " + chr + " : " + count);
            }
            else
            {
                System.out.println(testCase.charAt(0) + " and " + chr + " : " + "No Path");
            }
            
        }
        
        
	}
}
