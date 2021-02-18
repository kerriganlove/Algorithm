import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main
{
    static int [] list = new int[1000005];
    static int [] empty = new int[1000005];
    static long ans = 0;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for ( int i = 0; i < N; i++)
        {
            list[i] = Integer.parseInt(st.nextToken());
        }
        merge_sort(0,N-1);
        System.out.println(ans);
    }
    static void merge_sort(int start, int end)
    {
        int mid = 0;
        if ( start < end)
        {
            mid = (start+end)/2;
            merge_sort(start,mid);
            merge_sort(mid+1,end);
            merge(start,mid,end);
        }
    }
    static void merge(int s, int m, int e)
    {
        int start = s;
        int end = m+1;
        int k = s;

        while(start<=m && end<=e)
        {
            if( list[start] <= list[end])
            {
                empty[k++] = list[start++];
            }
            else { ans+= (m-start)+1; empty[k++] = list[end++]; }
        }
        if (start > m ) {
            for (int i = end; i <= e; i++) {
                empty[k++] = list[i];
            }
        }
        else {
            for (int i = start; i <= m; i++) {
                empty[k++] = list[i];
            }
        }
        for ( int i = s; i <= e; i++)
        {
            list[i] = empty[i];
        }
    }
}

// Counting Inversion과 문제가 동일하다고 봄. 답도 똑같음...
