import java.util.*;
import java.io.*;
public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        boolean bnw = false;
        int answer = 0;
        for ( int i = 0; i < 8; i++)
        {
            String str = br.readLine();
            if ( i % 2 == 0) { bnw = false; }
            else { bnw = true; }
            for ( int j = 0; j < 8; j++)
            {
                char c = str.charAt(j);
                if ( c == 'F' && !bnw)
                {
                    answer++;
                }
                bnw = !bnw;
            }
        }
        bw.write(answer+"\n");
        bw.flush();
        bw.close();
    }
}
