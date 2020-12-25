import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for ( int i = 0; i < N; i++)
        {
            sb.append(1);
        }
        for ( int i = 0; i < N-1; i++)
        {
            sb.append(0);
        }
        System.out.println(sb.toString());
    }
}
