import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        StringBuilder sb = new StringBuilder();
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long answer = gcd(A,B);
        for (long i = 0; i < answer; i++)
        {
            sb.append("1");
        }
        System.out.println(sb.toString());
    }
    public static long gcd(long a, long b)
    {
        long temp = 0;
        while( b > 0 )
        {
            temp = a;
            a = b;
            b = temp%b;
        }
        return a;
    }
}
