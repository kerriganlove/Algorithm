import java.io.*;
import java.util.*;

public class Main
{
    static HashMap<Integer,String> hm = new HashMap<>();
    static int [] list;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        list = new int[n];
        for  ( int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String nick = st.nextToken();
            int val = Integer.parseInt(st.nextToken());
            hm.put(i,nick);
            list[i] = val;
        }
        StringBuilder sb = new StringBuilder();
        for ( int i = 0; i < m; i++)
        {
            int value = Integer.parseInt(br.readLine());
            sb.append(showRank(value)+"\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
    static String showRank(int value)
    {
        int start = 0;
        int end = list.length-1;
        while(start <= end)
        {
            int mid = (start+end)/2;
            if ( list[mid] >= value)
            {
                end = mid-1;
            }
            else
            {
                start = mid+1;
            }
        }
        String answer = hm.get(start);
        return answer;
    }
}

