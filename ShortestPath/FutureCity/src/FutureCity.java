import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

public class FutureCity
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int INF = 1000000000;
        int [][]graph = new int[N+1][N+1];
        for ( int i = 1; i < N+1; i++)
        {
            Arrays.fill(graph[i],INF);
            graph[i][i] = 0;
        }
        for ( int i = 0; i < M; i++)
        {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = 1;
            graph[b][a] = 1;
        }
        int X = sc.nextInt();
        int K = sc.nextInt();

        for ( int j = 1; j < N+1; j++)
        {
            for ( int k = 1; k < N+1; k++)
            {
                for ( int l = 1; l < N+1; l++)
                {
                    graph[k][l] = Math.min(graph[k][l], graph[k][j] + graph[j][l]);
                }
            }
        } // 플루이드 워셜 알고리즘 ( 모든 정점에서 다른 모든 정점으로 가는 최단 거리를 알고 싶을 때 )

        int dist = graph[1][K] + graph[K][X];
        if ( dist >= INF) { System.out.print(-1); }
        else { System.out.print(dist); }
    }
}
