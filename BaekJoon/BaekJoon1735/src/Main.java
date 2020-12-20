import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main
{
    static int a;
    static int b;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int a1 = Integer.parseInt(st.nextToken());
        int b1 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine()," ");
        int a2 = Integer.parseInt(st.nextToken());
        int b2 = Integer.parseInt(st.nextToken());

        a = a1*b2 + a2*b1;
        b = b1*b2;
        int div = gcd(a,b);
        System.out.println(a/div+" "+b/div);
    }
    public static int gcd(int a, int b)
    {
        int temp = 0;
        while (b > 0)
        {
            temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
