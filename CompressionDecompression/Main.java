
// Author: Zayd Nadir




import java.util.*;
import java.io.*;

public class Main
{
    
    static TreeMap<Character, String> encodingMap = new TreeMap<>();
    
    public static void main(String[] args) throws IOException
    {
        
        // Ask if compressing or decompressing
        String method = "";
        Scanner userInput = new Scanner(System.in);
        do
        {
            System.out.println("Would you like to (c)ompress or (d)ecompress?");
            method = userInput.nextLine();
        } while (!method.equals("c") && !method.equals("d"));
        
        // Ask for file name
        System.out.println("What file?");
        String f = userInput.nextLine();
		if (method.equals("c"))
		{
    		encode(f, f.split("\\.")[0] + ".zpr");
		}
		else
		{
		    decode(f, f.split("\\.")[0] + ".out");
		}
    }
    
    
    /**
     * Generate tree based on frequencies of each character 
     */
    public static Node createTree(TreeMap<Character, Integer> freq)
    {
        // Create a node for each unique character using map keys
		PriorityQueue<Node> nodes = new PriorityQueue<>();
		for (char c: freq.keySet()) // go through the characters in the map (must be unique)
		{
		    Node n = new Node(c, freq.get(c));
		    nodes.add(n);
		}
		
		// if theres only 1 node, we can't traverse the tree
		if (nodes.size() == 1)
		{
		    // create a dummy node (-1 frequency) so that a tree can be created
		    nodes.add(new Node(-1));
		}
		// Use PriorityQueue to create tree
		while (nodes.size() > 1) 
		{
		    // pull out 2 smallest frequency nodes
		    Node one = nodes.poll(); 
		    Node two = nodes.poll();
		    
		    // create a new node that is the parent of the two nodes
		    Node three = new Node(one.freq + two.freq); 
		    three.left = one;
		    three.right = two; 
		    
		    // add the new node back into the priority queue
		    nodes.add(three);
		}
		// the last node in the priority queue should be the root node
		Node parent = nodes.poll(); 

		// Traverse tree to generate bit sequence for each character
		findBitSequences(parent, "");
		
		// return the root node of the tree
		return parent;
    }
    
    /**
     * Reads input file and writes compressed data to outFile
     * 
     * Compressed file format:
     *  - number of bits that should be ignored at the end of the file
     *  - number of unique characters in the file
     *  - frequencies of characters (1 byte for char, 4 bytes for frequency)
     *  - compressed binary data
     */
	public static void encode(String inFile, String outFile) throws IOException 
	{
	    // Read input file
	    Scanner input = new Scanner(new FileReader(inFile));
        String data = "";
		while (input.hasNext())
		{
		    data += input.nextLine();
		    data += "\n";
		}
		// delete extra '\n' 
		data = data.substring(0, data.length() - 1);
	    
	    
	    // Create OutputStream object to write to compressed file
	    OutputStream out = new FileOutputStream(outFile);
	    
		// Create a map to store frequencies by looping through data string
		TreeMap<Character, Integer> freq = new TreeMap<>();
		for (int i = 0; i < data.length(); i++)
		{
		    char c = data.charAt(i);
		    if (freq.containsKey(c)) // add 1 if character is already in map
		    {
		        freq.put(c, freq.get(c) + 1);
		    }
		    else // else add character to map and set its frequency to 1
		    {
		        freq.put(c, 1);
		    }
		}
		// Generate tree of nodes and update encodingMap to map characters to bits
		createTree(freq);
		
	    String bits = "";
	    String output = "";
	    
	    for (int i = 0; i < data.length(); i++)
	    {
	        // print the encoded bits for each character in data
	        bits += encodingMap.get(data.charAt(i));
	    }
	    // extra: the number of bits that will need to be added at the end 
	    // of the file to make sure each byte is filled
	    int extra = (bits.length() % 8 == 0) ? 0 : 8 - (bits.length() % 8);
	    out.write(extra);
	    
	    // Write the length of the frequency map so that the decryption algorithm
	    // knows how long the frequency data is
	    out.write(freq.size());
	    // loop through the characters and write their frequencies into the file
	    for (char c: freq.keySet())
	    {
	        // convert frequency integer to binary
	        String bin = Integer.toBinaryString(freq.get(c)); 
	        while (bin.length() != 32) // make sure binary is exactly 4 bytes
	        {
	            bin = "0" + bin;
	        }
	        
	        out.write((int)c); // Write the current character
	        // Write the frequency of the character as a 4 byte number
	        out.write(Integer.parseInt(bin.substring(0, 8), 2));
	        out.write(Integer.parseInt(bin.substring(8, 16), 2));
	        out.write(Integer.parseInt(bin.substring(16, 24), 2));
	        out.write(Integer.parseInt(bin.substring(24, 32), 2));
	    }
	    
	    // group binary data in groups of 8 (read byte by byte)
	    for (int i = 0; i < bits.length(); i += 8)
	    {
	        String b;
	        if (i + 8 <= bits.length()) // if there are atleast 8 bits left
	        {
	            b = bits.substring(i, i + 8);
	        }
	        else // if there are less than 8 bits left
	        {
	            b = bits.substring(i);
	            
	            // since we must write a full byte to the file, we will
	            // append 0s until the binary string is 8 bits
	            
	            // the number of extra 0s is already stored in the file header
	            // and these extra bits will be ignored when decompressing
	            for (int j = 0; j < extra; j++)
	            {
	                b = b + "0";
	            }
	        }
	        
	        // write byte to file
	        out.write(Integer.parseInt(b, 2));
	    }
	    out.close();
	    
	    double newLength = 2 + 5 * freq.size() + ((bits.length() + extra) / 8);
	    System.out.printf("Original File Length: %d bytes\n", data.length());
	    System.out.printf("Compressed File Length: %d bytes\n", (int)newLength);
	    System.out.printf("That's a %.2f%% reduction!\n",
	                        (1 - newLength/data.length()) * 100);
	}
	
	public static void decode(String inFile, String outFile) throws IOException
	{
	    // Create InputStream object to read compressed file
	    InputStream in = new FileInputStream(inFile);
	    
	    TreeMap<Character, Integer> freq = new TreeMap<>();
	    
	    // Get the number of extra bits at the end of the file
	    int extra = in.read();
	    
	    // Get the number of letters in the file
	    // Used to know when the frequency data ends and the compressed data starts
	    int numLetters = in.read();
	    
        for (int i = 0; i < numLetters; i++)
        {
            // Read in character
            int c = in.read();
            // Read in frequency (4 bytes)
            int n = readInt(in);
        
            freq.put((char)c, n);
        }
        // Generate compression tree based on frequencies
        // Should be the same tree that was used to compress the file
	    Node root = createTree(freq);
	    
	    String binary = "";
	    while (true)
	    {
	        int n = in.read(); 
	        if (n == -1) // reached the end of the file
	        {
	            break;
	        }
	        String bin = Integer.toBinaryString(n);
	        
	        // ensure that binary string is 8 bits long
	        int l = bin.length();
            for (int j = 0; j < 8 - l; j++)
            {
                bin = "0" + bin;
            }
            
            binary += bin;
	    }
	    // Remove extra bits
	    binary = binary.substring(0, binary.length() - extra);
	    // Traverse tree to decompress file
	    String output = "";
	    Node current = root;
	    for (char bit: binary.toCharArray())
	    {
	        if (bit == '0') // go right if the bit is a 0
	        {
	            current = current.right;
	        }
	        else if (bit == '1') // go left if the bit is a 1
	        {
	            current = current.left;
	        }
	        
	        // if the current node is a leaf, add the nodes data to the output
	        if (current.isLeaf()) 
	        {
	            output += Character.toString(current.data);
	            
	            // reset the current node back to the top of the tree
	            current = root;
	        }
	    }
	    
	    FileWriter out = new FileWriter(outFile);
	    out.write(output);
	    out.close();
	    in.close();
	    
	}
	
	/**
	 * Reads and returns a 4 byte integer from an input stream
	 */
	public static int readInt(InputStream i) throws IOException
	{
	    /* 
	    InputStream returns a single byte at a time
	    
	    To read an integer that takes multiple bytes, we use left shifts to
	    preserve place value
	    
	    Ex: to read "153" in decimal you can think of it as:
	       - Reading the 1 and shifting it to the left twice to get 100
	       - Reading the 5 and shifting it to the left once to get 50
	       - Reading the 3
	    The sum of all of these is 153
	    */
	    
	    int n = i.read() << 24; // leftmost byte gets shifted 3 bytes to the left
	    n += i.read() << 16; // shifting 2 bytes to the left
	    n += i.read() << 8; // shifting 1 byte to the left
	    n += i.read(); // no shift since this is the least significant byte*/
	    
	    return n;
	}
	
	public static void findBitSequences(Node n, String currentSequence)
	{
	    if (n == null) // null node has no sequence
	    {
	        return;
	    }
	    if (n.isLeaf()) // if we hit a leaf, add the current sequence to the map
	    {
	        encodingMap.put(n.data, currentSequence);
	    }
	    else
	    {
	        // find the bit sequences for the left and right subtrees
	        findBitSequences(n.left, currentSequence + "1");
	        findBitSequences(n.right, currentSequence + "0");
	    }
	}
}
