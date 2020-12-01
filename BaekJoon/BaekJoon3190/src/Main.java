import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main
{
    static Queue<int[]> delete = new LinkedList<>();
    static Queue<int[]> q = new LinkedList<>();
    static int[][] map;
    static int N;
    static HashMap<Integer, String> dir;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        int a = Integer.parseInt(br.readLine());
        for ( int i = 0; i < a; i++)
        {
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s, " ");
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            map[x][y] = 1;
        }
        int b = Integer.parseInt(br.readLine());
        dir = new HashMap<Integer, String>();
        for ( int j = 0; j < b; j++) {
            String s2 = br.readLine();
            StringTokenizer st2 = new StringTokenizer(s2, " ");
            int second = Integer.parseInt(st2.nextToken());
            dir.put(second, st2.nextToken());
        }
        int answer = BFS(0,0);
        System.out.println(answer);
    }
    public static int BFS(int x, int y)
    {
        int sec = 0;
        map[0][0] = 2;
        int []xy = new int[2];
        int []del = new int[2];
        int direction = 1;
        delete.add(new int[]{x,y});
        q.add(new int[]{x,y});
        while(!q.isEmpty())
        {
            sec++;
            xy = q.poll();
            int dx = xy[0]; int dy = xy[1];
            switch(direction)
            {
                case 0 : if ( dx-1 >= 0 ) {
                    if ( map[dx-1][dy] == 0)
                    {
                        map[dx-1][dy] = 2;
                        del = delete.poll();
                        map[del[0]][del[1]] = 0;
                        delete.add(new int[]{dx-1,dy});
                        q.add(new int[]{dx-1,dy});
                    }
                    else if (map[dx-1][dy] == 1)
                    {
                        map[dx-1][dy] = 2;
                        delete.add(new int[]{dx-1,dy});
                        q.add(new int[]{dx-1,dy});
                    }
                    else if (map[dx-1][dy] == 2)
                    {
                        break;
                    }
                }
                    else { break; }
                    break;
                case 1 : if ( dy+1 < N ) {
                    if ( map[dx][dy+1] == 0)
                    {
                        map[dx][dy+1] = 2;
                        del = delete.poll();
                        map[del[0]][del[1]] = 0;
                        delete.add(new int[]{dx,dy+1});
                        q.add(new int[]{dx,dy+1});
                    }
                    else if (map[dx][dy+1] == 1)
                    {
                        map[dx][dy+1] = 2;
                        delete.add(new int[]{dx,dy+1});
                        q.add(new int[]{dx,dy+1});
                    }
                    else if (map[dx][dy+1] == 2)
                    {
                        break;
                    }
                }
                else { break; }
                break;
                case 2 : if ( dx+1 < N ) {
                    if ( map[dx+1][dy] == 0)
                    {
                        map[dx+1][dy] = 2;
                        del = delete.poll();
                        map[del[0]][del[1]] = 0;
                        q.add(new int[]{dx+1,dy});
                        delete.add(new int[]{dx+1,dy});
                    }
                    else if (map[dx+1][dy] == 1)
                    {
                        map[dx+1][dy] = 2;
                        delete.add(new int[]{dx+1,dy});
                        q.add(new int[]{dx+1,dy});
                    }
                    else if (map[dx+1][dy] == 2)
                    {
                        break;
                    }
                }
                else { break; }
                break;
                case 3 : if ( dy-1 >= 0 ) {
                    if ( map[dx][dy-1] == 0)
                    {
                        map[dx][dy-1] = 2;
                        del = delete.poll();
                        map[del[0]][del[1]] = 0;
                        delete.add(new int[]{dx,dy-1});
                        q.add(new int[]{dx,dy-1});
                    }
                    else if (map[dx][dy-1] == 1)
                    {
                        map[dx][dy-1] = 2;
                        delete.add(new int[]{dx, dy-1});
                        q.add(new int[]{dx,dy-1});
                    }
                    else if (map[dx][dy-1] == 2)
                    {
                        break;
                    }
                }
                else { break; }
                break;
            }
            if ( dir.get(sec) != null ) {
                if (dir.get(sec).equals("L")) {
                    if ( direction == 0 ) { direction = 3; } else { direction--; } }
                else if ( dir.get(sec).equals("D")) {
                    if (direction == 3) { direction = 0; } else { direction++; } }
            }
        }
        return sec;
    }
}
