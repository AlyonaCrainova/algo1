package task_11;

public class BloomFilter
{
    public int filter_len;
    private int biteArray;
    private static final int random1 = 17;
    private static final int random2 = 223;

    public BloomFilter(int f_len)
    {
        filter_len = f_len;
    }

    public int hash1(String str1)
    {
        int hash = 0;
        for(int i = 0; i < str1.length(); i++)
        {
            int code = str1.charAt(i);
            hash = (hash * random1 + code) % filter_len;
        }
        return hash;
    }
    public int hash2(String str1)
    {
        int hash = 0;
        for(int i = 0; i < str1.length(); i++)
        {
            int code = str1.charAt(i);
            hash = (hash * random2 + code) % filter_len;
        }
        return hash;
    }

    public void add(String str1)
    {
        int mask = 1 << hash1(str1) | 1 << hash2(str1);
        biteArray = biteArray | mask;
    }

    public boolean isValue(String str1)
    {
        int mask = 1 << hash1(str1) | 1 << hash2(str1);
        return (mask & biteArray) == mask;
    }
}