import java.io.*;
import java.util.*;

public class Main
{
    static int n,m;
    static class Info implements Comparable<Info>
    {
        String str;
        int val;
        public Info(String str, int val)
        {
            this.str = str;
            this.val = val;
        }
        @Override
        public int compareTo(Info i)
        {
            if ( this.val == i.val)
            {
                if ( this.str.length() == i.str.length())
                {
                    return this.str.compareTo(i.str);
                }
                else
                {
                    return i.str.length()-this.str.length();
                }
            }
            return i.val-this.val;
        }
    }
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        ArrayList<Info> list = new ArrayList<>();
        HashMap<String, Integer> hm = new HashMap<>();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for ( int i = 0; i < n; i++)
        {
            String s = br.readLine();
            if ( s.length() < m)
            {
                continue;
            }
            if ( hm.containsKey(s) )
            {
                int val = hm.get(s);
                hm.put(s,val+1);
            }
            else
            {
                hm.put(s,1);
            }
        }
        for ( Map.Entry<String, Integer> e : hm.entrySet())
        {
            list.add(new Info(e.getKey(), e.getValue()));
        }
        StringBuilder sb = new StringBuilder();
        Collections.sort(list);
        for ( Info i : list)
        {
            sb.append(i.str+"\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
