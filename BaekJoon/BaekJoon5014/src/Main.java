import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main
{
    static int f,s,g,u,d;
    static int[] cache;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        f = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        cache = new int[f+1];
        boolean answer = BFS();
        System.out.println(answer? cache[g]-1 : "use the stairs");
    }
    public static boolean BFS()
    {
        Queue<Integer> que = new LinkedList<>();
        que.add(s);
        cache[s] = 1;
        while(!que.isEmpty())
        {
            int floor = que.poll();
            if ( floor == g) { return true; }
            int [] two = {floor+u, floor-d};
            for ( int i : two)
            {
                if (1 <= i && i <= f && cache[i] == 0)
                {
                    cache[i] = cache[floor] + 1;
                    que.add(i);
                }
            }
        }
        return false;
    }
}
