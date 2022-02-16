import java.io.*;
import java.util.*;

public class Main
{
    static int [] alpha = new int[26];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        for (int i = 0; i < s.length(); i++) {
            char c = Character.toUpperCase(s.charAt(i));
            int idx = c - 65;
            alpha[idx]++;
        }
        int max = -1;
        for (int i : alpha) {
            max = Math.max(max, i);
        }
        boolean count = false;
        int answer = 0;
        for (int i = 0; i < alpha.length; i++)
        {
            if ( max == alpha[i])
            {
                if ( !count ) {
                    count = true;
                    answer = i;
                }
                else
                {
                    count = false;
                    bw.write("?\n");
                    break;
                }
            }
        }
        char ans = (char)(answer+65);
        if (count) { bw.write(ans+"\n"); };
        bw.flush();
        bw.close();
    }
}
