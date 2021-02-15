import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int [] list = new int[N+1];
        StringBuilder sb = new StringBuilder();
        for ( int i = 1; i <= N; i++)
        {
            list[i] = Integer.parseInt(br.readLine());
        }
        int [] max = new int[100000*4];
        int [] min = new int[100000*4];
        init(0,list,max,1,1,N);
        init(1,list,min,1,1,N);
        for ( int i = 0; i < M; i++)
        {
            st = new StringTokenizer(br.readLine()," ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int maxV = search(0,list,max,1,1,N,s,e);
            int minV = search(1,list,min,1,1,N,s,e);
            sb.append(minV+" "+maxV+"\n");
        }
        System.out.print(sb.toString());
    }
    static int init(int check, int []arr,int [] tree, int node, int start, int end)
    {
        if ( start==end )
        {
            tree[node] = arr[start];
            return tree[node];
        }
        else {
            int mid = (start+end)/2;
            if ( check == 0)
            {
                tree[node] = Math.max(init(check,arr,tree,node*2,start,mid),init(check,arr,tree,node*2+1,mid+1,end));
                return tree[node];
            }
            else
            {
                tree[node] = Math.min(init(check,arr,tree,node*2,start,mid),init(check,arr,tree,node*2+1,mid+1,end));
                return tree[node];
            }
        }
    }
    static int search(int check, int[] arr, int[] tree, int node, int start, int end,int left, int right)
    {
        int res;
        if ( left > end || right < start)
        {
            if ( check == 0) { res = Integer.MIN_VALUE; }
            else { res = Integer.MAX_VALUE; }
            return res;
        }
        else
        {
            if ( left <= start && right >= end)
            {
                return tree[node];
            }
            else
            {
                int mid = (start+end)/2;
                if ( check == 0)
                {
                    res = Math.max(search(check,arr,tree,node*2,start,mid,left,right),
                            search(check,arr,tree,node*2+1,mid+1,end,left,right));
                }
                else
                {
                    res = Math.min(search(check,arr,tree,node*2,start,mid,left,right),
                            search(check,arr,tree,node*2+1,mid+1,end,left,right));
                }
                return res;
            }
        }
    }
}
