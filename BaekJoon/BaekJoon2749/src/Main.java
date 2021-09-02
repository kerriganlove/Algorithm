import java.util.*;
import java.io.*;

public class Main
{
    static int mod = 1000000;
    static long [][] matrix = {{1,1},{1,0}};
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long N = Long.parseLong(br.readLine());
        long [][] arr;
        long answer;
        if ( N > 2)
        {
            arr = DnQ(N - 2);
            answer = (arr[0][0] + arr[1][0])%mod;
        }
        else
        {
            answer = 1;
        }
        bw.write(answer+"\n");
        bw.flush();
        bw.close();
    }
    static long[][] DnQ(long l)
    {
        if (l == 1)
        {
            return matrix;
        }
        long [][] result = new long[2][2];
        long [][] temp = DnQ(l/2);
        for ( int i = 0; i < 2; i++)
        {
            for ( int j = 0; j < 2; j++)
            {
                for ( int k = 0; k < 2; k++)
                {
                    result[i][j] += (temp[i][k] * temp[k][j]) % mod;
                }
                result[i][j] %= mod;
            }
        }
        if ( l % 2 == 1)
        {
            long [][] ans2 = new long[2][2];
            for ( int i = 0; i < 2; i++)
            {
                for ( int j = 0; j < 2; j++)
                {
                    for ( int k = 0; k < 2; k++)
                    {
                        ans2[i][j] += (result[i][k] * matrix[k][j]) % mod;
                    }
                    ans2[i][j] %= mod;
                }
            }
            result = ans2;
        }
        return result;
    }
}
