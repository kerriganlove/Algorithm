import java.io.*;
import java.util.*;

public class Main
{
    static int [][] map;
    static int n,l;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        for ( int i = 0; i < n; i++)
        {
            st = new StringTokenizer(br.readLine()," ");
            for ( int j = 0; j < n; j++)
            {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = 0;
        for ( int i = 0; i < 2*n; i++) {
            answer+= search(i%n, i/n);
        }
        bw.write(answer+"\n");
        bw.flush();
        bw.close();
    }
    static int search(int idx, int dir)
    {
        int answer = 0;
        boolean [] visited = new boolean[n];
        boolean flag = false;
        if ( dir == 0)
        {
            for ( int i = 0; i < n-1; i++)
            {
                if (map[idx][i] == map[idx][i+1])
                {
                    continue;
                }
                if (Math.abs(map[idx][i+1]-map[idx][i]) == 1)
                {
                    if (map[idx][i+1]-map[idx][i] == 1)
                    {
                        for ( int j = i; j > i-l; j--)
                        {
                            if ( j < 0 || visited[j] || map[idx][j] != map[idx][i])
                            {
                                flag = true;
                                break;
                            }
                            visited[j] = true;
                        }
                    }
                    else
                    {
                        for ( int j = i+1; j <= i+l; j++)
                        {
                            if ( j >= n || visited[j] || map[idx][j] != map[idx][i+1])
                            {
                                flag = true;
                                break;
                            }
                            visited[j] = true;
                        }
                    }
                }
                else
                {
                    flag = true;
                    break;
                }
            }
        }
        else if ( dir == 1)
        {
            for ( int i = 0; i < n-1; i++)
            {
                if (map[i][idx] == map[i+1][idx])
                {
                    continue;
                }
                if (Math.abs(map[i+1][idx]-map[i][idx]) == 1)
                {
                    if (map[i+1][idx]-map[i][idx] == 1)
                    {
                        for ( int j = i; j > i-l; j--)
                        {
                            if ( j < 0 || visited[j] || map[j][idx] != map[i][idx])
                            {
                                flag = true;
                                break;
                            }
                            visited[j] = true;
                        }
                    }
                    else
                    {
                        for ( int j = i+1; j <= i+l; j++)
                        {
                            if ( j >= n || visited[j] || map[j][idx] != map[i+1][idx])
                            {
                                flag = true;
                                break;
                            }
                            visited[j] = true;
                        }
                    }
                }
                else
                {
                    flag = true;
                    break;
                }
            }
        }
        answer = (flag) ? 0 : 1;
        return answer;
    }
}
