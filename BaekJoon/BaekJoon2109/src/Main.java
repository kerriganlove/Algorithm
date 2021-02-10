import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main
{
    static class PD implements Comparable<PD>
    {
        int pay;
        int day;
        public PD(int pay, int day) {
            this.pay = pay;
            this.day = day;
        }

        @Override
        public int compareTo(PD o) {
            if (pay == o.pay) { return Integer.compare(day,o.day); }
            else return Integer.compare(pay,o.pay);
        }
    }
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] list = new int[10001];
        PD [] list2 = new PD[N];
        StringTokenizer st;
        for ( int i = 0; i < N; i++)
        {
            st = new StringTokenizer(br.readLine()," ");
            int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            list2[i] = new PD(p,d);
        }
        Arrays.sort(list2,Collections.reverseOrder());
        for ( PD p : list2)
        {
            if (list[p.day] < p.pay) { list[p.day] = p.pay; }
            else {
                for (int i = p.day; i>= 1; i--)
                {
                    if (list[i] < p.pay) { list[i] = p.pay; break; }
                }
            }
        }
        int sum = 0;
        for ( int i : list)
        {
            sum += i;
        }
        System.out.println(sum);
    }
}
