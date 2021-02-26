import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for ( int i = 0; i < T; i++)
        {
            int N = Integer.parseInt(br.readLine());
            int [] list = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for ( int j = 0; j < N; j++)
            {
                list[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(list);
            int answer = (list[N-1]-list[0])*2;
            sb.append(answer+"\n");
        }
        System.out.print(sb.toString());
    }
}
