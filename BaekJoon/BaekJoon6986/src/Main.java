import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        BigDecimal[] list = new BigDecimal[N];
        BigDecimal[] answer = new BigDecimal[2];
        DecimalFormat df = new DecimalFormat("#.00");
        Arrays.fill(answer,new BigDecimal("0.0"));
        for ( int i = 0; i < N; i++)
        {
            list[i] = new BigDecimal(br.readLine());
        }
        Arrays.sort(list);
        for ( int j = K; j < N-K; j++)
        {
            answer[0] = answer[0].add(list[j]);
            answer[1] = answer[1].add(list[j]);
        }
        for ( int i = 0; i < K; i++)
        {
            answer[1] = answer[1].add(list[K]).add(list[N-K-1]);
        }
        answer[0] = answer[0].divide(new BigDecimal(Integer.toString(N-(2*K))),2,RoundingMode.HALF_UP);
        answer[1] = answer[1].divide(new BigDecimal(Integer.toString(N)),2,RoundingMode.HALF_UP);
        for ( BigDecimal d : answer)
        {
            System.out.println(df.format(d));
        }
    }
}
