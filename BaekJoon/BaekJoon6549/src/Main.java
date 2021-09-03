import java.util.*;
import java.io.*;

public class Main
{
    static int [] histo;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true)
        {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int N = Integer.parseInt(st.nextToken());
            if ( N == 0) { break; }
            histo = new int[N];
            for ( int i = 0; i < N; i++) {
                histo[i] = Integer.parseInt(st.nextToken());
            }
            long answer = maxArea(0,N-1);
            bw.write(answer+"\n");
        }
        bw.flush();
        bw.close();
    }
    static long maxArea(int low, int high)
    {
        if ( low == high)
        {
            return histo[low];
        }
        int mid = (low+high)/2;
        long lArea = maxArea(low,mid);
        long hArea = maxArea(mid+1,high);

        long max = maxMidArea(low,high,mid);

        max = Math.max(lArea,max);
        max = Math.max(max,hArea);

        return max;
    }
    static long maxMidArea(int low, int high, int mid)
    {
        int left = mid;
        int right = mid;

        long height = histo[mid];
        long area = height;

        while ( low < left && right < high)
        {
            if ( histo[left-1] < histo[right+1])
            {
                right++;
                height = Math.min(height,histo[right]);
            }
            else
            {
                left--;
                height = Math.min(height, histo[left]);
            }
            area = Math.max(area, (height * (right - left+1)));
        }

        while ( low < left)
        {
            left--;
            height = Math.min(height,histo[left]);
            area = Math.max(area,(height*(right-left+1)));
        }
        while ( right < high )
        {
            right++;
            height = Math.min(height,histo[right]);
            area = Math.max(area,(height*(right-left+1)));
        }
        return area;
    }
}
