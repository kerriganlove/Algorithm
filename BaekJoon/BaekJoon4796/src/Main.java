import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        ArrayList<String> answerList = new ArrayList<>();
        int count = 1;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            int answer = 0;
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int L = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            if ( L == 0 && P == 0 && V == 0) { break; }
            else {
                for ( int i = 0; i < V/P; i++)
                {
                    answer+= L;
                }
                answer += (V%P > L) ? L : V%P;
                answerList.add("Case "+count+": "+answer);
            }
            count++;
        }
        for (String i : answerList)
        {
            System.out.println(i);
        }
    }
}
