import java.io.*;
import java.util.*;

public class Main
{
    static int [] num;
    static class Info
    {
        boolean isGood;
        int idx;
        public Info(boolean isGood, int idx)
        {
            this.isGood = isGood;
            this.idx = idx;
        }
    }
    static HashMap<Integer,Info> hs;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        num = new int[n];
        hs = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for ( int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        for ( int i = 0; i < n; i++)
        {
            hs.put(num[i],new Info(false,i));
        }
        for ( int i = 0; i < n; i++)
        {
            for ( int j = i+1; j < n; j++)
            {
                int sum = num[i]+num[j];
                if ( hs.containsKey(sum))
                {
                    if ( hs.get(sum).idx == i || hs.get(sum).idx == j)
                    {
                        continue;
                    }
                    hs.get(sum).isGood = true;
                }
            }
        }
        int answer = 0;
        for ( int i = 0; i < n; i++)
        {
            if (hs.get(num[i]).isGood)
            {
                answer++;
            }
        }
        bw.write(answer+"\n");
        bw.flush();
        bw.close();
    }
}
