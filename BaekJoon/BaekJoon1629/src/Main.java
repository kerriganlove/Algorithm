import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main
{
    public static long DnQ(int a, int b, int c)
    {
        if ( b == 1) { return a; }

        else
        {
            long temp = DnQ(a,b/2,c);
            if ( b % 2 == 1)
            {
                return (temp*temp%c * a) % c;
            }
            else return (temp*temp) %c;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        System.out.println(DnQ(A%C,B,C));
    }
}
