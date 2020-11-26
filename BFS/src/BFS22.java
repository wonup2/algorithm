import java.util.*;

public class BFS22{
	
	static Scanner in;
	static int N, Answer;
	static int MAP[][];
	static boolean Visit[][];
	static int dx[] = { 0, 0, 1, -1 };
	static int dy[] = { 1, -1, 0, 0 };
 
	static Queue<pair> V;
 
 
	public static void main(String[] args){
		in = new Scanner(System.in);
		init();
		solve();
		in.close();
	}

	static void init()
	{
	    Answer = 987654321;
	    N = in.nextInt();
	    for (int i = 0; i < N; i++)
	    {
	        for (int j = 0; j < N; j++)
	        {
	            MAP[i][j]=in.nextInt();
	            if (MAP[i][j] == 1)
	            {
	                MAP[i][j] = -1;
	                V.add(new pair(i, j));
	            }
	        }
	    }
	}
	 
	
	static void solve()
	{
	    int Land_Label = 1;
	    for (int i = 0; i < V.size(); i++)
	    {
	        int x = V[i].first;
	        int y = V[i].second;
	 
	        if (Visit[x][y] == false)
	        {
	            Make_LandLabel(x, y, Land_Label);
	            Land_Label++;
	        }
	    }
	 
	    for (int i = 1; i < Land_Label; i++)
	    {
	        Answer = Math.min(Answer, BFS(i));
	    }
	    
	    System.out.println(Answer);
	}
	
	
	void Make_LandLabel(int a, int b, int L)
	{
	    queue<pair<int, int>> Q;
	    Q.push(make_pair(a, b));
	    Visit[a][b] = true;
	    MAP[a][b] = L;
	 
	    while (Q.empty() == 0)
	    {
	        int x = Q.front().first;
	        int y = Q.front().second;
	        Q.pop();
	 
	        for (int i = 0; i < 4; i++)
	        {
	            int nx = x + dx[i];
	            int ny = y + dy[i];
	 
	            if (nx >= 0 && ny >= 0 && nx < N && ny < N)
	            {
	                if (Visit[nx][ny] == false && MAP[nx][ny] == -1)
	                {
	                    Visit[nx][ny] = true;
	                    MAP[nx][ny] = L;
	                    Q.push(make_pair(nx, ny));
	                }
	            }
	        }
	    }
	}
 
	static int BFS(int Num)
	{
	    int Result = 0;
	    queue<pair<int, int>> Q;
	    for (int i = 0; i < N; i++)
	    {
	        for (int j = 0; j < N; j++)
	        {
	            if (MAP[i][j] == Num)
	            {
	                Visit[i][j] = true;
	                Q.push(make_pair(i, j));
	            }
	        }
	    }
	 
	    while (Q.empty() == 0)
	    {
	        int S = Q.size();
	        for (int i = 0; i < S; i++)
	        {
	            int x = Q.front().first;
	            int y = Q.front().second;
	            Q.pop();
	 
	            for (int j = 0; j < 4; j++)
	            {
	                int nx = x + dx[j];
	                int ny = y + dy[j];
	 
	                if (nx >= 0 && ny >= 0 && nx < N && ny < N)
	                {
	                    if (MAP[nx][ny] != 0 && MAP[nx][ny] != Num) return Result;
	                    else if (MAP[nx][ny] == 0 && Visit[nx][ny] == false)
	                    {
	                        Visit[nx][ny] = true;
	                        Q.push(make_pair(nx, ny));
	                    }
	                }
	            }
	        }
	        Result++;
	    }
	}
 

 
	static class pair{
		int x, y;
		pair(int a, int b){
			x=a; y=b;
		}
	}

}

