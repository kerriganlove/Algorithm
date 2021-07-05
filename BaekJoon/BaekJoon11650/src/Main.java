import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main
{
    static class Point implements Comparable<Point>
    {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public int compareTo(Point o) {
            if ( x > o.x) { return 1; }
            else if ( x == o.x ) {
                if ( y > o.y) {
                    return 1;
                }
            }
            return -1;
        }
    }
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Point [] list = new Point[N];
        for ( int i = 0; i < N; i++)
        {
            st = new StringTokenizer(br.readLine()," ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list[i] = new Point(x,y);
        }
        Arrays.sort(list);
        for ( Point p : list)
        {
            bw.write(p.x+" "+p.y+"\n");
        }
        bw.flush();
        bw.close();
    }
}
