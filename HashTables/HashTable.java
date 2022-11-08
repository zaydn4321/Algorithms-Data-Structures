import java.util.*;
public class HashTable
{
    private LinkedList <hashWord> [] list = new LinkedList[10];
    
    public HashTable()
    {
        for(int i = 0; i < 10; i++)
        {
            list[i] = new LinkedList();
        }
    }
    public void add(hashWord h)
    {
        
        for(int i = 0; i < list[h.hashCode()].size(); i++)
        {
            LinkedList x = list[h.hashCode()];

            hashWord w = (hashWord) x.get(i);
            if(w.equals(h))
            {
                return;
            }
        }
        list[h.hashCode()].add(h);
    }
    public String toString()
    {
        String str = "";
        for(int i = 0; i < 10; i++)
        {
            str += i;
            str +=(String)(list[i] + "\n");
        }
        return str;
    }
}