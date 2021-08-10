import java.io.*;

public class Main
{
    static int [] list;
    static class Nums
    {
        int start;
        int end;
        public Nums(int start, int end)
        {
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        makePrimeNumber(1000000);
        while (num != 0)
        {
            Nums n = goldBach(num);
            if ( n.start != 0 && n.end != 0)
            {
                bw.write(num+" = " +n.start+" + "+n.end+"\n");
            }
            else
            {
                bw.write("Goldbach's conjecture is wrong.\n");
            }
            num = Integer.parseInt(br.readLine());
        }
        bw.flush();
        bw.close();
    }
    static Nums goldBach(int num)
    {
        Nums n = new Nums(0,0);
        for ( int i = num; i >= num / 2; i--)
        {
            if ( list[i] != 0)
            {
                if ( list[num - i] != 0 )
                {
                    n = new Nums(num-i, i);
                    break;
                }
            }
        }
        return n;
    }
    static void makePrimeNumber(int num)
    {
        list = new int[num+1];
        for ( int i = 2; i <= num; i++)
        {
            list[i] = i;
        }
        for ( int i = 2; i <= num; i++)
        {
            if ( list[i] == 0) { continue; }
            for ( int j = i + i; j <= num; j+=i)
            {
                list[j] = 0;
            }
        }
    }
}
