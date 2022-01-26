import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main
{
    static String first, second, ans;
    static boolean [][] visited;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        StringBuilder answers = new StringBuilder();
        for ( int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            first = st.nextToken();
            second = st.nextToken();
            ans = st.nextToken();
            boolean notOK = check();
            visited = new boolean[first.length()][second.length()];
            if ( !notOK )
            {
                answers.append("Data set "+(i+1)+": no\n");
                continue;
            }
            boolean isOK = DFS(0,0,0);
            if ( isOK )
            {
                answers.append("Data set "+(i+1)+": yes\n");
            }
            else
            {
                answers.append("Data set "+(i+1)+": no\n");
            }
        }
        bw.write(answers.toString());
        bw.flush();
        bw.close();
    }
    static boolean check()
    {
        HashSet<Character> hs = new HashSet<>();
        for ( int i = 0; i < first.length(); i++)
        {
            hs.add(first.charAt(i));
        }
        for ( int i = 0; i < second.length(); i++)
        {
            hs.add(second.charAt(i));
        }
        for ( int i = 0; i < ans.length(); i++)
        {
            if ( !hs.contains(ans.charAt(i)))
            {
                return false;
            }
        }
        return true;
    }
    static boolean DFS(int s_now, int e_now, int ans_now)
    {
        boolean a_check = false;
        boolean b_check = false;
        if ( ans_now == ans.length() )
        {
            return true;
        }
        if ( s_now < first.length() && e_now < second.length()) {
            if (visited[s_now][e_now]) {
                return false;
            }
            visited[s_now][e_now] = true;
        }
        if ( s_now < first.length()) {
            char s = first.charAt(s_now);
            if ( s == ans.charAt(ans_now))
            {
                a_check = DFS(s_now+1, e_now, ans_now+1);
            }
            else
            {
                a_check = false;
            }
        }
        if ( e_now < second.length()) {
            char e = second.charAt(e_now);
            if ( e == ans.charAt(ans_now))
            {
                b_check = DFS(s_now, e_now+1, ans_now+1);
            }
            else
            {
                b_check = false;
            }
        }
        return (a_check || b_check) ? true : false ;
    }
}
