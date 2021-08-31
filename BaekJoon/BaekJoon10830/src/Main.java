import java.io.*;
import java.util.StringTokenizer;

public class Main
{
    static int N;
    static long B;
    static int mod = 1000;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());
        int [][] matrix = new int[N][N];
        for ( int i = 0; i < N; i++)
        {
            st = new StringTokenizer(br.readLine()," ");
            for (int j = 0; j < N; j++)
            {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int [][] answer;
        answer = DnQ(matrix, B);
        for ( int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
            {
                bw.write(answer[i][j]%1000+" ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
    static int[][] DnQ(int [][] matrix, long expo)
    {
        if ( expo == 1)
        {
            return matrix;
        }
        int [][] temp = DnQ(matrix,expo/2);
        int [][] ans = new int[N][N];
        for ( int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    ans[i][j] += (temp[i][k] * temp[k][j])%mod;
                }
                ans[i][j] %= mod;
            }
        }
        if ( expo%2 == 1) {
            int [][] ans2 = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < N; k++) {
                        ans2[i][j] += (ans[i][k] * matrix[k][j])%mod;
                    }
                        ans2[i][j] %= mod;
                }
            }
            return ans2;
        }
        return ans;
    }
}
