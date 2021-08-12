import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        while ( T > 0)
        {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            long sum = a+b;
            boolean isYes = false;
            if ( sum % 2 == 0 && sum > 2)
            {
                bw.write("YES\n");
                isYes = true;
            }
            else {
                long nb = sum-2;
                BigInteger bi = BigInteger.valueOf(nb);
                if ( bi.isProbablePrime(10))
                {
                    bw.write("YES\n");
                    isYes = true;
                }
            }
            if (!isYes) { bw.write("NO\n"); }
            T--;
        }
        bw.flush();
        bw.close();
    }
}
