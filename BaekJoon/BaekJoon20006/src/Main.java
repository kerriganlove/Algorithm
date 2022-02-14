import java.io.*;
import java.util.*;
public class Main
{
    static ArrayList<Queue<Info>> list;
    static class Info implements Comparable<Info>
    {
        int lv;
        String nick;
        public Info(int lv, String nick)
        {
            this.lv = lv;
            this.nick = nick;
        }
        @Override
        public int compareTo(Info in)
        {
            return this.nick.compareTo(in.nick);
        }
    }
    static int p,m;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        p = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        for ( int i = 0; i < p; i++)
        {
            st = new StringTokenizer(br.readLine()," ");
            int level = Integer.parseInt(st.nextToken());
            String nickname = st.nextToken();
            solution(new Info(level,nickname));
        }
        for ( Queue<Info> que : list)
        {
            if ( que.size() == m)
            {
                bw.write("Started!\n");
            }
            else
            {
                bw.write("Waiting!\n");
            }
            TreeSet<Info> ts = new TreeSet<>();
            while(!que.isEmpty())
            {
                ts.add(que.poll());
            }
            for ( Info in : ts)
            {
                bw.write(in.lv+" "+in.nick+"\n");
            }
        }
        bw.flush();
        bw.close();
    }
    static void solution(Info in)
    {
        if ( list.size() == 0)
        {
            Queue<Info> que = new LinkedList<>();
            list.add(que);
        }
        int lv = in.lv;
        String nick = in.nick;
        boolean isNot = false;
        for ( int i = 0; i < list.size(); i++)
        {
            if (0 < list.get(i).size() && list.get(i).size() < m)
            {
                int val = list.get(i).peek().lv;
                if ( val-10 <= lv && lv <= val+10)
                {
                    list.get(i).add(new Info(lv,nick));
                    isNot = true;
                    break;
                }
            }
            else if ( list.get(i).size() == 0)
            {
                list.get(i).add(in);
                isNot = true;
            }
        }
        if (!isNot)
        {
            Queue<Info> que = new LinkedList<>();
            list.add(que);
            list.get(list.size()-1).add(in);
        }
    }
}
