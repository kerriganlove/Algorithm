import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int div = n/3;
        int mod = n%3;
        int answer = (div+mod)%2;
        bw.write((answer == 1) ? "SK\n" : "CY\n");
        bw.flush();
        bw.close();
    }
}
