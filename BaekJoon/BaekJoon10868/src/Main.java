import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main
{
    static int [] segTree;
    static int init (int [] arr, int left, int right,int node)
    {
        if ( left == right) { segTree[node] = arr[left]; return segTree[node]; }
        int mid = (left+right) / 2;
        segTree[node] = Math.min(init(arr,left,mid,node*2), init(arr,mid+1,right,node*2+1));
        return segTree[node];
    }
    static int query(int start, int end, int node, int nodeLeft, int nodeRight)
    {
        if ( start > nodeRight || end < nodeLeft)
        {
            return Integer.MAX_VALUE;
        }
        if ( start <= nodeLeft && end >= nodeRight)
        {
            return segTree[node];
        }
        int mid = (nodeLeft+nodeRight)/2;
        return Math.min(query(start,end,node*2,nodeLeft,mid),query(start,end,node*2+1,mid+1,nodeRight));
    }
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        segTree = new int[N*4];
        int [] list = new int[N];
        for ( int i = 0; i < N; i++)
        {
            list[i] = Integer.parseInt(br.readLine());
        }
        Arrays.fill(segTree,Integer.MAX_VALUE);
        init(list,0,list.length-1,1);
        for ( int i = 0; i < M; i++)
        {
            st = new StringTokenizer(br.readLine()," ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            sb.append(query(s-1,e-1,1,0,N-1)+"\n");
        }
        System.out.print(sb.toString());
    }
}
