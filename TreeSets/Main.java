//By: Zayd

import java.io.*;
import java.util.*;
public class Main
{
	public static void main(String[] args) throws IOException
	{
		Scanner scan = new Scanner(new FileReader("phrase.dat"));
        int numTestCases = scan.nextInt();
        scan.nextLine();
        for(int i = 0; i < numTestCases; i++)
        {
            TreeSet<String> ts1 = new TreeSet<String>();
            TreeSet<String> ts2 = new TreeSet<String>();
            String[] str = scan.nextLine().split(" ");
            String[] str2 = scan.nextLine().split(" ");
            for(int j = 0; j < str.length; j++)
            {
                ts1.add(str[j]);
            }
            for(int j = 0; j < str2.length; j++)
            {
                ts2.add(str2[j]);
            }
            TreeSet<String> ts3 = new TreeSet<String>();
            TreeSet<String> tsA = new TreeSet<String>(ts1);
            TreeSet<String> tsB = new TreeSet<String>(ts2);
            ts1.removeAll(tsB);
            ts2.removeAll(tsA);
            tsA.retainAll(tsB);
            ts3 = tsA;
            ts3.retainAll(tsA);
            System.out.println("A : " + ts1);
            System.out.println("B : " + ts2);
            System.out.println("BOTH : " + ts3);
            

        }
	}
}
