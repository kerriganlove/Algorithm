import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(T > 0)
        {
            BigInteger i = new BigInteger(br.readLine());
            sb.append((i.isProbablePrime(10)? i : i.nextProbablePrime())+"\n");
            T--;
        }
        System.out.print(sb.toString());
    }
}
