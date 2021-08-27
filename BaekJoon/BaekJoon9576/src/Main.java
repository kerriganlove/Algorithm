import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        while(T > 0)
        {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int N = Integer.parseInt(st.nextToken());
            boolean [] visited = new boolean[N+1];
            int M = Integer.parseInt(st.nextToken());
            int [][] list = new int[M][2];
            int answer = 0;
            for ( int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                list[i][0] = Integer.parseInt(st.nextToken());
                list[i][1] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(list, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                        return o2[1] - o1[1];
                }
            });
            Arrays.sort(list, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o2[0]-o1[0];
                }
            });
            for ( int i = 0; i < M; i++)
            {
                int start = list[i][0];
                int end = list[i][1];
                for ( int j = end; j >= start; j--)
                {
                    if (!visited[j])
                    {
                        visited[j] = true;
                        answer++;
                        break;
                    }
                    else if (visited[j])
                    {
                        continue;
                    }
                }
            }
            bw.write(answer+"\n");
            T--;
        }
        bw.flush();
        bw.close();
    }
}
