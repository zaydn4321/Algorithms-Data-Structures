public class Node implements Comparable<Node>
{
    public char data;
    public int freq;
    public Node left;
    public Node right;
    
    public Node(int freq)
    {
        this.freq = freq;
    }
    
    public Node(char c, int freq)
    {
        this.data = c;
        this.freq = freq;
    }
    
    public String toString()
    {
        // display in the format [freq]:[char] when printed
        return freq + ":" + data;
    }
    
    public int compareTo(Node n)
    {
        // compare nodes by their frequency
        // break ties by ascii value
        if (freq == n.freq)
        {
            return (int)data - (int)n.data;
        }
        return freq - n.freq;
    }
    
    public boolean isLeaf()
    {
        // if the node has no children, its a leaf
        return left == null && right == null;
    }
}