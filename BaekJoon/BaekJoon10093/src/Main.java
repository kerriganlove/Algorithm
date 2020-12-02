import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long num;
        if ( a >= b ) { long temp = a; a = b; b = temp; }
        if ( a == b) { num = 0; } else { num = b-a-1; }
        System.out.println(num);
        for ( long i = a+1; i < b; i++)
        {
            System.out.print(i);
            if ( i != b-1) { System.out.print(" "); }
        }
    }
}
