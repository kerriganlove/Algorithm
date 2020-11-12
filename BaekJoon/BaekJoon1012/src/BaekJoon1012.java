import java.util.Scanner;

public class BaekJoon1012
{
    static int M,N,K;
    static int[][]map;
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int T;
        int x,y;
        T = sc.nextInt();
        int[] answer = new int[T];
        for ( int i = 0; i < T; i++)
        {
            M = sc.nextInt();
            N = sc.nextInt();
            K = sc.nextInt();
            map = new int[N][M];
            for ( int j = 0; j < K; j++)
            {
                y = sc.nextInt();
                x = sc.nextInt();
                map[x][y] = 1;
            }
            for ( int k = 0; k < N*M; k++)
            {
                answer[i] += dfs(k/M,k%M);
            }
        }
        for ( int i = 0; i < T; i++)
        {
            System.out.println(answer[i]);
        }
    }
    public static int dfs(int x, int y)
    {
        int num = 0;
        if ( x < 0 || x >= N || y < 0 || y >= M)
        {
            return -1;
        }
        if (map[x][y] == 1)
        {
            map[x][y] = 0;
            dfs(x-1,y);
            dfs(x,y-1);
            dfs(x+1,y);
            dfs(x,y+1);
            return 1;
        }
        else { return 0; }
    }
}
