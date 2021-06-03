import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main
{
    static int[][] list;
    static int[] backpack;
    public static void main(String []args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        list = new int[N][2];
        backpack = new int[K];
        long ans = 0;
        for ( int i = 0; i < N; i++)
        {
            st = new StringTokenizer(br.readLine()," ");
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list[i][0] = m;
            list[i][1] = v;
        }
        Arrays.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        for (int i = 0; i < K; i++)
        {
            int c = Integer.parseInt(br.readLine());
            backpack[i] = c;
        }
        Arrays.sort(backpack);
        PriorityQueue<Integer> que = new PriorityQueue<>(Comparator.reverseOrder());
        int num = 0;
        for ( int i = 0; i < K; i++)
        {
            while (num < N && list[num][0] <= backpack[i] )
            {
                que.add(list[num][1]);
                num++;
            }
            if ( !que.isEmpty()) { ans+= que.poll(); }
        }
        System.out.println(ans);
    }
}
