import java.io.*; 
import java.util.*;
public class Main
{
	public static void main(String[] args) throws IOException
	{
		Scanner scan = new Scanner(new FileReader("words.dat"));
		int input = scan.nextInt();
		scan.nextLine();
		HashTable table = new HashTable();
		for(int i = 0; i < input; i++)
		{
		    String word = scan.nextLine();
		    hashWord h = new hashWord(word);
		    table.add(h);
		}
        System.out.println(table);
	}
}
