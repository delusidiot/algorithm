import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main_BOJ_2630 {
	static int map[][];
	static int N;
	static int w,b; //0,1

	static boolean isPossible(int sr,int sc,int er,int ec) {
		int color = map[sr][sc];
		for(int i = sr ; i <= er ; i++) {
			for(int j = sc ; j <= ec ; j++) {
				if(map[i][j] != color) return false;
			}
		}
		return true;
	}


	static void solve(int sr,int sc,int er,int ec) {
		if(isPossible(sr,sc,er,ec)) {
			if(map[sr][sc] == 0) {
				w++;
				return;
			}else {
				b++;
				return;
			}
		}
		int nr = (sr+er) / 2;
		int nc = (sc+ec) / 2;
		
		solve(sr,sc,nr,nc);		// 11시
		solve(sr,nc+1,nr,ec); 		// 1시
		solve(nr+1,sc,er,nc); 		// 7시
		solve(nr+1,nc+1,er,ec); 	// 5시

	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		solve(0,0,N-1,N-1);
		System.out.println(w + "\n" + b);

	}
}