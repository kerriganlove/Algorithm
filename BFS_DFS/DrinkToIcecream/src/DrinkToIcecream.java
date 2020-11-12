import java.util.Scanner;
import java.util.Stack;

public class DrinkToIcecream
{
    static int[][] map;
    static int N,M;
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];
        for ( int i = 0; i < N*M; i++)
        {
            map[i/M][i%M] = sc.nextInt();
        }
        int result = 0;
        for ( int j = 0; j < N; j++)
        {
            for ( int k = 0; k < M; k++)
            {
                if ( dfs(j,k) ) { result++; }
            }
        }
        System.out.println(result);

    }
    public static boolean dfs(int x, int y)
    {
        if ( x < 0 || x >= N || y < 0 || y >= M)
        {
            return false;
        }
        else {
            if (map[x][y] == 0) {
                map[x][y] = 1;
                dfs(x - 1, y);
                dfs(x + 1, y);
                dfs(x, y - 1);
                dfs(x, y + 1);
                return true;
            }
        }
        return false;
    }
}
