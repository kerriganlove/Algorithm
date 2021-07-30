import java.io.*;

public class Main
{
    public static int count;
    public static int [] arr;
    public static int N;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        nQueens(0);
        bw.write(count+"\n");
        bw.flush();
        bw.close();
    }
    public static void nQueens(int depth)
    {
        if ( depth == N)
        {
            count++;
            return ;
        }
        for (int i = 0; i < N; i++)
        {
            arr[depth] = i;
            if (possibility(depth))
            {
                nQueens(depth+1);
            }
        }
    }
    public static boolean possibility(int depth)
    {
        for ( int i = 0; i < depth; i++)
        {
            if ( arr[i] == arr[depth])
            {
                return false;
            }
            if ( Math.abs(depth-i) == Math.abs(arr[depth]-arr[i]))
            {
                return false;
            }
        }
        return true;
    }
}

