import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main
{
    static class Info
    {
        int num;
        int weight;
        public Info(int num, int weight) {
            this.num = num;
            this.weight = weight;
        }
    }
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for ( int i = 0; i < T; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int N = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());
            Queue<Info> que = new LinkedList<>();
            int [] list = new int[10];
            st = new StringTokenizer(br.readLine()," ");
            for ( int j = 0; j < N; j++)
            {
                int num = Integer.parseInt(st.nextToken());
                que.add(new Info(j,num));
                list[num]++;
            }
            int answer = 1;
            while(!que.isEmpty())
            {
                Info in = que.poll();
                boolean bool = false;
                for ( int k = in.weight+1; k < 10; k++)
                {
                    if ( list[k] != 0) {
                        que.add(in);
                        bool = true;
                        break;
                    }
                }
                if ( !bool ) {
                    if (in.num == target) {
                        bw.write(answer+"\n");
                        que.clear();
                        break;
                    }
                    answer++;
                    list[in.weight]--;
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
