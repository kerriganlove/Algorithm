import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main
{
    static boolean ok = false;
    static int [] team1 = { 0,0,0,0,0,1,1,1,1,2,2,2,3,3,4};
    static int [] team2 = { 1,2,3,4,5,2,3,4,5,3,4,5,4,5,5};
    static int [][]list;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        list = new int[6][3];
        int [] answer = new int[4];
        int sum = 0;
        for ( int j = 0; j < 4; j++) {
            ok = false;
            sum = 0;
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < 6; i++) {
                sum+= list[i][0] = Integer.parseInt(st.nextToken());
                sum+= list[i][1] = Integer.parseInt(st.nextToken());
                sum+= list[i][2] = Integer.parseInt(st.nextToken());
            }
            if (sum!= 30) { ok = false; }
            else { DFS(0); }
            answer[j] = ok ? 1:0;
        }
        for (int i : answer)
        {
            System.out.print(i+" ");
        }
    }
    public static void DFS(int num)
    {
        if ( ok ) { return ; }
        if (num == 15) { ok = true; return ;}

        int one = team1[num];
        int sec = team2[num];

        if ( list[one][0] > 0 && list[sec][2] > 0 && list[one][0] < 6 && list[sec][2] < 6)
        {
            list[one][0]--;
            list[sec][2]--;
            DFS(num+1);
            list[one][0]++;
            list[sec][2]++;
        }
        if ( list[one][2] > 0 && list[sec][0] > 0 && list[one][2] < 6 && list[sec][0] < 6)
        {
            list[one][2]--;
            list[sec][0]--;
            DFS(num+1);
            list[one][2]++;
            list[sec][0]++;
        }
        if ( list[one][1] > 0 && list[sec][1] > 0 && list[one][1] < 6 && list[sec][1] < 6)
        {
            list[one][1]--;
            list[sec][1]--;
            DFS(num+1);
            list[one][1]++;
            list[sec][1]++;
        }
    }
}
