public class hashWord
{
    private String word;
    
    public hashWord(String str)
    {
        word = str;
    }
    public int hashCode()
    {
        int x = 0; 
        for(int i = 0; i < word.length(); i++)
        {
            String c = word.substring(i, i+1);
            if(c.equals("a") || c.equals("e") || c.equals("i") || c.equals("o") || c.equals("u"))
            {
                x++;
            }
        }
        return ((word.length() * x) % 10);
    }
    public boolean equals(hashWord s)
    {
        return s.word.equals(this.word);
    }
    public String toString()
    {
        return word;
    }
}