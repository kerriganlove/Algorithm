import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main
{
    static int gcd(int a, int b)
    {
        if ( a % b == 0) { return b; }
        return gcd(b, a%b);
    }
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T > 0)
        {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int answer = 0;
            while ( a != 1)
            {
                if (b%a == 0) { answer = b/a; } else { answer = b/a+1; }
                a = a*answer -b;
                b *= answer;
                int div = gcd(a,b);
                a /= div;
                b /= div;
            }
            sb.append(b+"\n");
            T--;
        }
        System.out.print(sb.toString());
    }
}
