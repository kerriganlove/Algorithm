import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int [] height = new int[H+1];
        int [] seok = new int[H+1];
        int [] jong = new int[H+1];
        for ( int i = 1; i <= N; i++)
        {
            int a = Integer.parseInt(br.readLine());
            if ( i % 2 == 1)
            {
                seok[a]++;
            }
            else
            {
                jong[a]++;
            }
        }
        for ( int i = H; i > 1; i--) { seok[i-1]+= seok[i]; }
        for ( int i = H; i > 1; i--) { jong[i-1]+= jong[i]; }
        for ( int i = 1; i <= H; i++) { height[i] = seok[i]+jong[H-i+1]; }
        Arrays.sort(height);
        height[0] = -1;
        int min = height[1];
        int count = 0;
        for ( int i : height)
        {
            if ( i == min) { count++; }
        }
        System.out.println(min+" "+count);
    }
}
