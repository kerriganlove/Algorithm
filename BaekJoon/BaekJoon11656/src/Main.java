import java.io.*;
import java.util.Arrays;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        String [] answer = new String[s.length()];
        for ( int i = 0; i < s.length(); i++)
        {
            answer[i] = s.substring(i,s.length());
        }
        Arrays.sort(answer);
        for ( String str : answer)
        {
            bw.write(str+"\n");
        }
        bw.flush();
        bw.close();
    }
}
