import java.io.*;

public class Main
{
    static int [] list;
    static int max = -1;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        list = new int[N];
        int answer = 0;
        for ( int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            list[i] = num;
        }
        int gcd = list[1]-list[0];
        for ( int i = 1; i < N-1; i++)
        {
            gcd = gcd(gcd, list[i+1] - list[i]);
        }
        for ( int i = 0; i < N-1; i++)
        {
            answer+= ((list[i+1]-list[i])/gcd) - 1;
        }
        bw.write(answer+"\n");
        bw.flush();
        bw.close();
    }
    static int gcd(int x, int y)
    {
        if ( y == 0) { return x; }
        else return gcd(y, x%y);
    }
}
