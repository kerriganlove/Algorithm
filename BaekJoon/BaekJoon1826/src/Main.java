import java.io.*;
import java.util.*;

public class Main
{
    static class Point implements Comparable<Point>
    {
        int x;
        int len;
        public Point(int x, int len)
        {
            this.x = x;
            this.len = len;
        }
        @Override
        public int compareTo(Point p)
        {
            return this.x-p.x;
        }
    }
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Point> p = new PriorityQueue<>();
        StringTokenizer st;
        int sum = 0;
        for ( int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int x = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());
            p.add(new Point(x,len));
        }
        st = new StringTokenizer(br.readLine()," ");
        int L = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int len = P;
        int answer = 0;
        PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());
        while(len < L)
        {
            while(!p.isEmpty() && len>=p.peek().x)
            {
                que.add(p.poll().len);
            }
            if(que.isEmpty())
            {
                answer = -1;
                break;
            }
            len += que.poll();
            answer++;
        }
        bw.write(answer+"\n");
        bw.flush();
        bw.close();
    }
}
