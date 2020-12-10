import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main
{
    static int[] list;
    static int total;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        list = new int[N];
        int sum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for ( int i = 0; i < N; i++)
        {
            list[i] = Integer.parseInt(st.nextToken());
            sum += list[i];
        }
        Arrays.sort(list);
        total = Integer.parseInt(br.readLine());
        if ( sum <= total) { System.out.println(list[N-1]); }
        else { System.out.println(BinarySearch(0, list[N-1])); }
    }
    public static int BinarySearch(int start, int end)
    {
        int mid = 0;
        int sum;
        while(start <= end) {
            mid = (start+end)/2;
            sum = 0;
            for (int i = 0; i < list.length; i++) {
                if (list[i] > mid) {
                    sum += mid;
                } else {
                    sum += list[i];
                }
            }
            if (sum <= total) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return end;
    }
}
