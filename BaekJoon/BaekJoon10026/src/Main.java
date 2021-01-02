import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main
{
    static int N;
    static char [][] empty;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        char [][] list = new char[N][N];
        char [][] list2 = new char[N][N];
        int ans1 = 0;
        int ans2 = 0;
        for ( int i = 0; i < N; i++)
        {
            String s = br.readLine();
            for ( int j = 0; j < N; j++)
            {
                char c = s.charAt(j);
                list[i][j] = c;
                if ( c == 'G') { list2[i][j] = 'R'; }
                else { list2[i][j] = c; }
            }
        }
        for ( int i = 0; i < N; i++)
        {
            for ( int j = 0; j < N; j++)
            {
                if (DFS(i,j,list,'R')) ans1++;
                if (DFS(i,j,list,'B')) ans1++;
                if (DFS(i,j,list,'G')) ans1++;
                if (DFS(i,j,list2,'R')) ans2++;
                if (DFS(i,j,list2,'B')) ans2++;
            }
        }
        System.out.println(ans1+" "+ans2);
    }
    static boolean DFS(int x, int y, char [][] map, char match)
    {
        if ( x < 0 || x >= N || y < 0 || y >= N) { return false; }
        else {
            if ( map[x][y] == match)
            {
                map[x][y] = '0';
                DFS(x - 1, y, map,match);
                DFS(x + 1, y, map,match);
                DFS(x,y-1,map,match);
                DFS(x,y+1,map,match);
                return true;
            }
        }
        return false;
    }
}
