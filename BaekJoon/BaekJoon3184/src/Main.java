import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main 
{
	static int N;
	static int M;
	static char[][] graph;
	static int[] counting = new int[2];
	static int[] answer = new int[2];
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s," ");
		String save;
		N = Integer.parseInt(st.nextToken().toString());
		M = Integer.parseInt(st.nextToken().toString());
		
		graph = new char[N][M];
		for ( int i = 0; i < N; i++)
		{
			save = br.readLine();
			for ( int j = 0; j < M; j++)
			{
				graph[i][j] = save.charAt(j);
			}
		}
		for ( int i = 0; i < N; i++)
		{
			for ( int j = 0; j < M; j++)
			{
				if (DFS(i,j)) {
					if (counting[0] > counting[1]) { answer[0] += counting[0]; counting[0] = 0; counting[1] = 0;}
					else {  answer[1] += counting[1]; counting[0] = 0; counting[1] = 0; }
				}
			}
		}
		System.out.println(answer[0]+" "+answer[1]);
	}
	public static boolean DFS(int x, int y)
	{
		if ( x < 0 || x >= N || y < 0 || y >= M)
		{
			return false;
		}
		else {
			if ( graph[x][y] == '.')
			{
				graph[x][y] = '#';
				DFS(x-1,y);
				DFS(x,y-1);
				DFS(x+1,y);
				DFS(x,y+1);
				return true;
			}
			else if (graph[x][y] == 'o')
			{
				graph[x][y] = '#';
				counting[0]++;
				DFS(x-1,y);
				DFS(x,y-1);
				DFS(x+1,y);
				DFS(x,y+1);
				return true;
			}
			else if (graph[x][y] == 'v')
			{
				graph[x][y] = '#';
				counting[1]++;
				DFS(x-1,y);
				DFS(x,y-1);
				DFS(x+1,y);
				DFS(x,y+1);
				return true;
			}
		}
		return false;
	}
}
