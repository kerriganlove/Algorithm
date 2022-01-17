import java.io.*;

public class Main
{
    static StringBuilder sb;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        int answer = (int)Math.pow(2,n) - 1;
        sb.append(answer+"\n");
        hanoi(n,1,2,3);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
    static void hanoi(int n, int start, int mid, int end)
    {
        if ( n == 1)
        {
            sb.append(start+" "+end+"\n");
            return ;
        }
        hanoi(n-1,start,end,mid);
        sb.append(start+" "+end+"\n");
        hanoi(n-1,mid,start,end);
    }
}
