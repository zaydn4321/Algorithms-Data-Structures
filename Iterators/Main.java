import java.util.*;
public class Main
{
	public static void main(String[] args) 
	{
		ArrayList <String> list1 = listCreate("abracadabra");
		System.out.println("Test Case 1: " + list1);
		removeChar(list1, "a");
		System.out.println("Altered: " + list1);
		ArrayList <String> list2 = listCreate("abcxdefghijxxxx");
		System.out.println("Test Case 2: " + list2);
		replaceInstance(list2, "+", "x");
		System.out.println("Altered: " + list2);
		ArrayList <String> list3 = listCreate("12abb2c1a2bc3");
		System.out.println("Test Case 3: " + list3);
		replaceInstance(list3, "#", "b");
		removeChar(list3, "2");
		System.out.println("Altered: " + list3);



		
	}
	public static ArrayList <String> listCreate(String str)
	{
		ArrayList <String> L = new ArrayList<String>();
		for(int i = 0; i < str.length(); i++)
		{
		    L.add(str.substring(i, i+1));
		}
		return L;
	}
	public static void removeChar(ArrayList <String> x, String remove)
	{
	    Iterator <String> it = x.iterator();
	    while(it.hasNext())
		{
		    if(it.next().equals(remove))
		    {
		        it.remove();
		    }
		}

	}
	public static void replaceInstance(ArrayList <String> x, String replace, String remove)
	{
	    ListIterator <String> it = x.listIterator();
	    while(it.hasNext())
		{
		    if(it.next().equals(remove))
		    {
		        it.set(replace);
		    }
		}
	}
	
}