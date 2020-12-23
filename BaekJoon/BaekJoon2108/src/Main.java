import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] list = new int[N];
        int [] cnt = new int[8001];
        int sum = 0;
        int count = 0;
        int second = 0;
        boolean flag = false;
        for ( int i = 0; i < N; i++)
        {
            list[i] = Integer.parseInt(br.readLine());
            sum+= list[i];
            cnt[list[i]+4000]++;
        }
        Arrays.sort(list);
        for ( int i = list[0]+4000; i <= list[N-1]+4000; i++)
        {
            if ( count < cnt[i]) { count = cnt[i]; second = i - 4000; flag = true;}
            else if (count == cnt[i] && flag == true) { second = i - 4000; flag = false; }
        }
        System.out.println((int)Math.round((double)sum/N));
        System.out.println(list[N/2]);
        System.out.println(second);
        System.out.println(list[N-1]-list[0]);
    }
}
