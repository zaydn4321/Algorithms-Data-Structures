import java.util.LinkedList;

public class LinkedListBasics
{
	private LinkedList<Integer> list;

	public LinkedListBasics()
	{
		list = new LinkedList<Integer>();
	}

	public LinkedListBasics(int[] nums)
	{
		list = new LinkedList<Integer>();
		for(int num : nums)
		{
			list.add(num);
		}
	}

	public double getSum(  )
	{
		double total=0;
		for(int i = 0; i < list.size(); i++)
		{
		    total += list.get(i);
		}
		return total;
	}

	public double getAvg(  )
	{
	    double avg = 0;
	    avg = getSum() / list.size();
		return avg;
	}

	public int getLargest()
	{
    
		int largest = 0;
		int lastLargest = 0;
		for(int i = 0; i < list.size(); i++)
		{
		    if(list.get(i) > lastLargest)
		    {
		        lastLargest = list.get(i);
		    }
		}
		largest = lastLargest;
		return largest;
	}

	public int getSmallest()
	{
	    int smallest = 0;
	    int lastSmallest = list.get(1);
		for(int i = 0; i < list.size(); i++)
		{
		    if(list.get(i) < lastSmallest)
		    {
		        lastSmallest = list.get(i);
		    }
		}
		smallest = lastSmallest;
		return smallest;
	}

	public String toString()
	{
		String output="SUM: " + getSum() + "\nAVERAGE: "+ getAvg() + "\nLARGEST: " + getLargest() + "\nSMALLEST: " + getSmallest();
		return output;
	}
}