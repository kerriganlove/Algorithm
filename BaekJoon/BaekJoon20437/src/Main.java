import java.util.*;
import java.io.*;
public class Main
{
    static int [] alpha;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        while( T-- > 0)
        {
            String org = br.readLine();
            int K = Integer.parseInt(br.readLine());
            alpha = new int[26];
            for ( char c : org.toCharArray())
            {
                alpha[c-97]++;
            }
            int min = 987654321;
            int max = -1;
            for ( int i = 0; i < org.length(); i++)
            {
                char ch = org.charAt(i);
                if ( alpha[ch-97] < K)
                {
                    continue;
                }
                int count = 0;
                int save = i;
                while(count != K)
                {
                    if ( save == org.length())
                    {
                        break;
                    }
                    if ( org.charAt(save++) == ch )
                    {
                        count++;
                    }
                }
                if ( count != K ) { continue; }
                min = Math.min(min,save-i);
                max = Math.max(max,save-i);
            }
            if ( min == 987654321 || max == -1) { bw.write("-1\n"); }
            else { bw.write(min+" "+max+"\n"); }
        }
        bw.flush();
        bw.close();
    }
}
