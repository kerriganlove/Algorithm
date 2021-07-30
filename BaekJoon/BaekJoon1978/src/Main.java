import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for ( int i = 0; i < N; i++)
        {
            int num = Integer.parseInt(st.nextToken());
            BigInteger bi = BigInteger.valueOf(num);
            if (bi.isProbablePrime(10))
            {
                count++;
            }
        }
        bw.write(count+"\n");
        bw.flush();
        bw.close();
    }
}
