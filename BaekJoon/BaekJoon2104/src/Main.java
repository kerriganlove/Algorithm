import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main
{
    static long [] list = new long[100000];
    public static long solve(int a, int b) {
        if (a == b) {
            return list[a] * list[a];
        }
        int mid = (a + b) / 2;
        long max = Math.max(solve(a, mid), solve(mid + 1, b));
        long sum = list[mid] + list[mid + 1];
        long min = Math.min(list[mid], list[mid + 1]);
        max = Math.max(max, sum * min);
        int low = mid;
        int high = mid + 1;

        while (a < low || high < b)
        {
            if ( a < low && (b == high || list[low-1] > list[high+1]))
            {
                --low;
                sum += list[low];
                min = Math.min(min, list[low]);
            }
            else
            {
                ++high;
                sum += list[high];
                min = Math.min(min,list[high]);
            }
            max = Math.max(max, sum * min);
        }
        return max;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++)
        {
            list[i] = Long.parseLong(st.nextToken());
        }
        System.out.println(solve(0,N-1));
    }
}
