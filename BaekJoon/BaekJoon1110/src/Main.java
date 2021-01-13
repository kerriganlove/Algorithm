import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int first = Integer.parseInt(br.readLine());
        int N = first;
        int f = (0<=N && N<=9) ? N : N%10;
        int sum = 0;
        for ( char c : Integer.toString(N).toCharArray())
        {
            sum += c-'0';
        }
        int e = (0<=sum && sum<=9) ? sum : sum%10;
        String s = f+""+e;
        N = Integer.parseInt(s);
        int count = 1;
        while(first != N)
        {
            sum = 0;
            f = (0<=N && N<=9) ? N : N%10;
            for ( char c : Integer.toString(N).toCharArray())
            {
                sum += c-'0';
            }
            e = (0<=sum && sum<=9) ? sum : sum%10;
            s = f+""+e;
            N = Integer.parseInt(s);
            count++;
        }
        System.out.println(count);
    }
}
