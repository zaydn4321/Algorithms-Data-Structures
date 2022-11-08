/* This Node class defines frequency of character, two nodes and character.
 * Comparable interface is used to order of objects.
 */

public class Node implements Comparable<Node>
{
	    public int frequency;
	    public Node leftNode;
	    public Node rightNode;
	    public String character;

	    
	//This is constructor to assign frequency count and character to instant variables.   
    public Node(int freq, String ch)
    {
        this.frequency =freq;    
        this.character = ch;
    }
         
         
    //This is constructor to assign left/right node.This will allow for the sorting of Nodes into a tree, with parent nodes having a frequency with the sum of their children.
	public Node(Node leftNode, Node rightNode)
	{
		this.frequency=leftNode.getFrequency()+rightNode.getFrequency();
		this.leftNode=leftNode;
		this.rightNode=rightNode;
	}
	
	//this is getter for frequency
	public int getFrequency()
	{
	    return this.frequency;
	}

    @Override
 
    //returns an integer for the order of comparison. This is needed for use in the PriorityQueue.
    public int compareTo(Node node)
    {
        //compares frequencies; if a node has a lower frequency that what it is being compared to, then this will return a negative integer.
        //if a node has a higher frequency, this will return a positive integer. If they are the same, this will return zero.
        return Integer.compare(frequency,node.getFrequency()); 
    }
    
    //Returns character in the form f a string.
    public String toString()
    {
        return this.character;
    }
    
    
}