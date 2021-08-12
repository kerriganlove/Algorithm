import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main
{
    static int count = 0;
    static int num = 0;
    static ArrayList<Integer> numList = new ArrayList<>();
    static int[][] map;
    static boolean[][] visited;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = br.read()-48;
            }
            br.read();
        }
        for ( int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
            {
                if (DFS(i,j))
                {
                    numList.add(num);
                    num = 0;
                    count++;
                }
            }
        }
        int [] list = new int[count];
        for (int i = 0; i < count; i++)
        {
            list[i] = numList.get(i);
        }
        Arrays.sort(list);
        bw.write(count+"\n");
        for ( int i : list)
        {
            bw.write(i+"\n");
        }
        bw.flush();
        bw.close();
    }
    static boolean DFS(int x, int y)
    {
        if ( 0 <= x && x < N && 0 <= y && y < N) {
            if (map[x][y] == 1 && !visited[x][y]) {
                num++;
                visited[x][y] = true;
                DFS(x - 1, y);
                DFS(x + 1, y);
                DFS(x, y + 1);
                DFS(x, y - 1);
                return true;
            }
        }
        return false;
    }

}
