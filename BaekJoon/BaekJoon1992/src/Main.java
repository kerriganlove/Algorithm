import java.io.*;

public class Main
{
    static char [][] quad;
    static int n;
    static StringBuilder sb;
    public static void main(String [] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        quad = new char[n][n];
        for ( int i = 0; i < n; i++)
        {
            String str = br.readLine();
            for ( int j = 0; j < n; j++)
            {
                quad[i][j] = str.charAt(j);
            }
        }
        sb = new StringBuilder();
        solution(0,0,n);
        bw.write(sb.toString()+"\n");
        bw.flush();
        bw.close();
    }
    static void solution(int x, int y, int size)
    {
        if ( isPossible(x,y,size) )
        {
            sb.append(quad[x][y]);
            return ;
        }
        sb.append("(");

        int half = size/2;
        solution(x, y, half);
        solution(x, y+half, half);
        solution(x+half,y,half);
        solution(x+half,y+half,half);

        sb.append(")");
    }
    static boolean isPossible(int x, int y, int size)
    {
        char value = quad[x][y];
        for ( int i = x; i < x+size; i++)
        {
            for ( int j = y; j < y+size; j++)
            {
                if ( value != quad[i][j])
                {
                    return false;
                }
            }
        }
        return true;
    }
}
