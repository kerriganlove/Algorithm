import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main
{
    static long i = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int part = N-M;
        int fiveCount = five(N)-(five(M)+five(part));
        int twoCount = two(N)-(two(M)+two(part));
        int answer = (fiveCount > twoCount) ? twoCount : fiveCount;
        System.out.println(answer);
    }
    public static int five(int value)
    {
        int count = 0;
        for ( i = 5; value/i >= 1; i*=5)
        {
            count += value/i;
        }
        return count;
    }
    public static int two(int value)
    {
        int count = 0;
        for ( i = 2; value/i >= 1; i*=2)
        {
            count += value/i;
        }
        return count;
    }
}
