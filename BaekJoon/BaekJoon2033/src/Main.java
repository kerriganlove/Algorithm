import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int a = 10;
        int s = 1;
        while ( N > a)
        {
            String st = Integer.toString(N);
            char c = st.charAt(st.length()-s);
            if ( '0' <= c && c < '5') {
                N = (N/a)*a;
            }
            else { N = (N/a)*a + a; }
            a *= 10;
            s++;
        }
        System.out.println(N);
    }
}
