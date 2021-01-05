import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int ans1, ans2, ans3;
        StringBuilder sb = new StringBuilder();
        ans1 = ans2 = ans3 = 0;
        boolean check = true;
        while(check)
        {
            while(T/300 != 0) { ans1++; T = T-300;}
            while(T/60 != 0) { ans2++; T = T-60; }
            while(T/10 != 0) { ans3++; T = T-10; }
            if (T != 0 ) { check = false; }
            else { break; }
        }
        sb.append(ans1+" "+ans2+" "+ans3);
        System.out.println(check ? sb.toString() : -1 );
    }
}
