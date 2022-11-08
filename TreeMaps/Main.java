import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String[] args) throws IOException
	{
	    Scanner scan = new Scanner(new FileReader("Espanol-English.dat"));
        int numLines = scan.nextInt();
        scan.nextLine();
        TreeMap m = new TreeMap();
        for(int i = 0; i < numLines; i++)
        {
            String[] str = scan.nextLine().split(" ");
            m.put(str[0], str[1]);
            
        }
        Scanner s2 = new Scanner(new FileReader("translate.in"));
        while(s2.hasNext())
        {
            String[] str2 = s2.nextLine().split(" ");
            for(int r = 0; r < str2.length; r++)
            {
                System.out.print(m.get(str2[r]) + " ");;
            }
            System.out.println();
            
        }
	}
}
