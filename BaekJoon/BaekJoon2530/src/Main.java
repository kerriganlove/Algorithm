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
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int sum = A*3600+B*60+C;
        int D  = Integer.parseInt(br.readLine());
        sum += D;
        A = (sum/3600)%24;
        B = ((sum%3600)/60)%60;
        C = ((sum%3600)%60)%60;
        System.out.println(A+" "+B+" "+C);
    }
}
