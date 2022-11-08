

public class ListOperations
{
	//this method will print the entire list on the screen
   public static void print(ListNode list)
   {
       ListNode currentNode = list;
       while(currentNode != null)
       {
           System.out.print(currentNode.getValue() + "  ");
           currentNode = currentNode.getNext();
       }
       System.out.println();
   }		
	
	//this method will return the number of nodes present in list
	public static int nodeCount(ListNode list)
	{
   	    int count=0;
   	    ListNode currentNode = list;
   	    while(currentNode != null)
        {
           count++;
           currentNode = currentNode.getNext();
        }
		return count;
	}
		
	//this method will create a new node with the same value as the first node and add this
	//new node to the list.  Once finished, the first node will occur twice.
	public static void doubleFirst(ListNode list)
	{
	    int firstVal = (int) list.getValue();
	    ListNode firstDouble = new ListNode(firstVal, list.getNext());
	    list.setNext(firstDouble);
	}

	//this method will create a new node with the same value as the last node and add this
	//new node at the end.
	public static void doubleLast(ListNode list)
	{
   	    ListNode currentNode = list;
   	    ListNode last = null;
   	    while(currentNode != null)
        {
            if(currentNode.getNext() == null)
            {
                last = currentNode;
            }
           currentNode = currentNode.getNext();
        }
   	    int lastVal = (int) last.getValue();
	    ListNode lastDouble = new ListNode(lastVal, last.getNext());
	    last.setNext(lastDouble);
	}
		
	//method skipEveryOther will remove every other node
	public static void skipEveryOther(ListNode list)
	{
	    ListNode currentNode = list;
	    ListNode nodeReplace = null;
	    ListNode newNode = null;
	    while(currentNode != null)
	    {
	        nodeReplace = currentNode.getNext();
	        currentNode.setNext(nodeReplace.getNext());
	        newNode = currentNode.getNext();
	        currentNode = newNode;
	    }
	}

	//this method will set the value of every xth node in the list
	public static void setEveryXthNode(ListNode list, int x, Comparable value)
	{
	    ListNode currentNode = list;
		int count=1;
		while(currentNode != null)
	    {
	        if(count % x == 0)
	        {
	            currentNode.setValue(value);
	            currentNode = currentNode.getNext();
	            count++;
	        }
	        else
	        {
	        currentNode = currentNode.getNext();
	        count++;
	        }
	    }
	}	

	//this method will remove every xth node in the list
	public static void removeEveryXthNode(ListNode list, int x)
	{
		ListNode currentNode = list;
	    ListNode prevNode = null;
	    ListNode newNode = null;
		int count=1;
		while(currentNode != null)
	    {
	        if(count % x == 0)
	        {
	            newNode = currentNode.getNext();
	            prevNode.setNext(newNode);
	            currentNode = newNode;
	            count++;
	        }
	        else
	        {
	            prevNode = currentNode;
	            currentNode = currentNode.getNext();
	            count++;
	        }
	    }
	}
}		
