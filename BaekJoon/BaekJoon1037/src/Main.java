import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int min = 1000001;
        int max = 1;
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for ( int i = 0; i < N; i++)
        {
            int num = Integer.parseInt(st.nextToken());
            min = Math.min(min,num);
            max = Math.max(max,num);
        }
        int answer = min*max;
        System.out.println(answer);
    }
}
