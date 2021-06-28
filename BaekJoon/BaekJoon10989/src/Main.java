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
        int [] counting = new int[10001];
        int [] countingSum = new int[10001];
        int [] ans = new int[N+1];
        int [] list = new int[N+1];
        for ( int i = 1; i <= N; i++)
        {
            list[i] = Integer.parseInt(br.readLine());
            counting[list[i]]++;
        }
        for ( int i = 1; i <= counting.length-1; i++ )
        {
            countingSum[i] = countingSum[i-1]+counting[i];
        }
        for ( int i = N; i>= 1; i--)
        {
            ans[countingSum[list[i]]] = list[i];
            countingSum[list[i]]--;
        }
        for ( int i = 1; i <= N; i++)
        {
            sb.append(ans[i]+"\n");
        }
        System.out.print(sb.toString());
    }
}
