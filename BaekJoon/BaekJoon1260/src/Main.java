import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main
{
    static int N,M,V;
    static int[][] line;
    static int[][] map;
    static boolean []visited;
    static int count = 1;
    static Queue<Integer> que = new LinkedList<>();
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        V = sc.nextInt();
        line = new int[M][2];
        map = new int[N][N];
        visited = new boolean[N];
        for ( int i = 0; i < M; i++)
        {
            line[i][0] = sc.nextInt();
            line[i][1] = sc.nextInt();
        }
        for ( int i = 0; i < M; i++)

        {
            map[(line[i][0])-1][(line[i][1])-1] = line[i][1];
            map[line[i][1]-1][line[i][0]-1] = line[i][0];
        }
        dfs(V);
        System.out.println();
        Arrays.fill(visited,false);
        count = 1;
        bfs(V);
    }

    public static void dfs(int start) {
        if ( visited[start-1] == false) {
            if ( count <= N && count > 1 ) { System.out.print(" "); }
            visited[start-1] = true;
            System.out.print(start);
            count++;
            for (int i = 0; i < N; i++) {
                if ( map[start-1][i] != 0 && visited[map[start-1][i]-1] == false) {dfs(map[start - 1][i]);}
                }
        }
    }

    public static void bfs(int start) {
        que.add(start);
        visited[start-1] = true;
        while(!que.isEmpty())
        {
            if ( count <= N && count > 1 ) {System.out.print(" ");}
            count++;
            start = que.poll();
            System.out.print(start);
            for (int i = 0; i<N; i++)
            {
                if (map[start-1][i] > 0 && visited[i] == false)
                {
                    que.add(map[start-1][i]);
                    visited[i] = true;
                }
            }
        }
    }
}
