import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main
{
    static int target = 123456789;
    static int [] dx = { -1,1,0,0};
    static int [] dy = { 0,0,-1,1};
    static HashMap<Integer, Integer> hm = new HashMap<>();
    static void BFS(int s)
    {
        Queue<Integer> que = new LinkedList<>();
        que.add(s);
        hm.put(s,0);
        while(!que.isEmpty())
        {
            int num = que.poll();
            int count = hm.get(num);
            String str = Integer.toString(num);
            int cur = str.indexOf("9");
            int nx = cur % 3;
            int ny = cur / 3;
            for ( int i = 0; i < 4; i++)
            {
                int x = nx + dx[i];
                int y = ny + dy[i];
                if ((0<=x && x < 3) && (0 <= y && y < 3))
                {
                    int swap = (y * 3)+x;
                    StringBuilder sb = new StringBuilder(str);
                    sb.setCharAt(swap, str.charAt(cur));
                    sb.setCharAt(cur, str.charAt(swap));
                    int save = Integer.parseInt(sb.toString());
                    if ( !hm.containsKey(save)){
                        que.add(save);
                        hm.put(save, count+1);
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for ( int i = 0; i < 3; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            sb.append(st.nextToken());
            sb.append(st.nextToken());
            sb.append(st.nextToken());
        }
        sb.setCharAt(sb.indexOf("0"),'9');
        String s = sb.toString();
        BFS(Integer.parseInt(s));
        System.out.println(hm.containsKey(target) ? hm.get(target) : -1);
    }
}