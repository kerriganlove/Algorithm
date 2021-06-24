import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int [] list = new int[N];
        for ( int i = 0; i < N; i++)
        {
            list[i] = Integer.parseInt(br.readLine());
        }
        mergeSort(0,N,list);
        for ( int i : list)
        {
            sb.append(i+"\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
    static void mergeSort(int start, int end, int []arr)
    {
        if ( end - start >= 2) {
            int mid = (end + start) / 2;
            mergeSort(start, mid, arr);
            mergeSort(mid, end, arr);
            merge(start, mid, end, arr);
        }
    }
    static void merge(int start, int mid, int end, int [] arr)
    {
        int [] temp = new int[end-start];
        int t = 0;
        int s = start;
        int m = mid;
        while ( s < mid && m < end)
        {
            if ( arr[s] < arr[m])
            {
                temp[t++] = arr[s++];
            }
            else { temp[t++] = arr[m++]; }
        }
        while ( s < mid )
        {
            temp[t++] = arr[s++];
        }
        while ( m < end)
        {
            temp[t++] = arr[m++];
        }
        for ( int i = start; i < end; i++)
        {
            arr[i] = temp[i-start];
        }
    }
}


