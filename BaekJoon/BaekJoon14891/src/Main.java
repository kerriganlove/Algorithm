import java.io.*;
import java.util.*;

public class Main {
    static int [][] list = new int[4][8];
    static boolean [] visited;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < 4; i++)
        {
            for ( int j = 0; j < 8; j++)
            {
                list[i][j] = br.read() - '0';
            }
            br.read();
        }
        int T = Integer.parseInt(br.readLine());
        for ( int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            visited = new boolean[4];
            makeGear(n-1,dir);
        }
        int answer = 0;
        for ( int i = 0; i < 4; i++)
        {
            if (list[i][0] == 1)
            {
                answer+= Math.pow(2,i);
            }
        }
        bw.write(answer+"\n");
        bw.flush();
        bw.close();
    }
    static void makeGear(int n, int dir)
    {
        visited[n] = true;
        if ( n-1 >= 0)
        {
            if (list[n][6] != list[n-1][2] && !visited[n-1])
            {
                makeGear(n-1,-dir);
            }
        }
        if (n+1 < 4)
        {
            if ( list[n][2] != list[n+1][6] && !visited[n+1])
            {
                makeGear(n+1,-dir);
            }
        }
        turnDir(n, dir);
    }
    static void turnDir(int n, int dir)
    {
        int [] save = new int[8];
        switch(dir)
        {
            case 1 :
                for ( int i = 0; i < 8; i++)
                {
                    save[(i+1)%8] = list[n][i];
                }
                System.arraycopy(save,0,list[n],0,save.length);
                break;
            case -1 :
                for ( int i = 0; i < 8; i++)
                {
                    save[(i+7)%8] = list[n][i];
                }
                System.arraycopy(save,0,list[n],0,save.length);
                break;
        }
    }
}
