import java.io.*;
import java.util.*;

public class Main
{
    static int n;
    static boolean [] visited;
    static ArrayList<Integer> answers;
    static int [] list;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        list = new int[n+1];
        visited = new boolean[n+1];
        answers = new ArrayList<>();
        for ( int i = 1; i <= n; i++)
        {
            list[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 1; i <= n; i++)
        {
            visited[i] = true;
            DFS(i,i);
            visited[i] = false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(answers.size()+"\n");
        Collections.sort(answers);
        for ( int i : answers)
        {
            sb.append(i+"\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
    static void DFS(int start, int num)
    {
        if ( !visited[list[start]] )
        {
            visited[list[start]] = true;
            DFS(list[start],num);
            visited[list[start]] = false;
        }
        if ( list[start] == num) { answers.add(num); }
    }
}
