import java.io.*;
import java.util.*;
public class Main
{
    static int answer;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        int point = 0;
        answer = 1;
        while(point < s.length())
        {
            String str = String.valueOf(answer);
            for ( int i = 0; i < str.length(); i++)
            {
                if (str.charAt(i) == s.charAt(point))
                {
                    point++;
                }
                if (point == s.length())
                {
                    break;
                }
            }
            answer++;
        }
        bw.write(answer-1+"\n");
        bw.flush();
        bw.close();
    }
}
