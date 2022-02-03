import java.io.*;
import java.util.*;

public class Main
{
    static class Info implements Comparator<Info>
    {
        int x;
        int y;
        public Info(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
        @Override
        public int compare(Info i1, Info i2)
        {
            if ( i1.x > i2.x) {
                if (i1.y > i2.y) {
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
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Info [] info = new Info[n];
        for ( int i = 0; i < n; i++)
        {
            st = new StringTokenizer(br.readLine()," ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            info[i] = new Info(x,y);
        }
        int [] answer = new int[n];
        Info comp = new Info(0,0);
        for ( int i = 0; i < n; i++)
        {
            for ( int j = 0; j < n; j++)
            {
                if (comp.compare(info[i],info[j]) > 0)
                {
                    answer[j]++;
                }
            }
        }
        for ( int ans : answer)
        {
            bw.write(ans+1+" ");
        }
        bw.write("\n");
        bw.flush();
        bw.close();
    }
}
