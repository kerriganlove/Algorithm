import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        long s = Long.parseLong(st.nextToken());
        long e = Long.parseLong(st.nextToken());
        if ( s > e) { long temp = s; s = e; e = temp; }
        long ans = 0;
        ans = ((e-s+1)*((s+e)))/2;
        System.out.println(ans);
    }
}
