import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

import javax.jws.soap.SOAPBinding.Use;

public class Main_1938 {
	public static BufferedReader br;
	public static BufferedWriter bw;
	public static class User{
		int[] dx={1,1,1,0,0,-1,-1,-1};
		int[] dy={-1,0,1,-1,1,-1,0,1};
		Position head;
		Position mid;
		Position tail;
		static char[][] board;
		public User(Position[] p) {
			head = p[0];
			mid = p[1];
			tail = p[2];
		}
		public static class Position{
			int x;
			int y;
			public Position(int x, int y) {
				this.x = x;
				this.y = y;
			}
			public boolean eq(Position o) {
				return this.x==o.x&&this.y==o.y;
			}
			public String toString() {
				return x+" "+y;
			}
		}
		public boolean up() {
			if(head.x-1<0) return false;
			if(board[head.x-1][head.y]=='1'||
				board[mid.x-1][mid.y]=='1'||
				board[tail.x-1][tail.y]=='1') return false;
			head.x-=1;
			mid.x-=1;
			tail.x-=1;
			return true;
		}
		public boolean down () {
			if(tail.x+1>board.length) return false;
			if(board[head.x+1][head.y]=='1'||
				board[mid.x+1][mid.y]=='1'||
				board[tail.x+1][tail.y]=='1') return false;
			head.x+=1;
			mid.x+=1;
			tail.x+=1;
			return true;
		}
		public boolean left () {
			if(head.y-1<0) return false;
			if(board[head.x][head.y-1]=='1'||
				board[mid.x][mid.y-1]=='1'||
				board[tail.x][tail.y-1]=='1') return false;
			head.y-=1;
			mid.y-=1;
			tail.y-=1;
			return true;
		}
		public boolean right () {
			if(head.y+1>board.length) return false;
			if(board[head.x][head.y+1]=='1'||
				board[mid.x][mid.y+1]=='1'||
				board[tail.x][tail.y+1]=='1') return false;
			head.y+=1;
			mid.y+=1;
			tail.y+=1;
			return true;
		}
		public boolean turn () {
			boolean check= surrounding();
			if(!check) return check;
			if(head.x==mid.x) {
				head.x-=1;
				head.y+=1;
				
				tail.x+=1;
				tail.y-=1;
			}else {
				head.x+=1;
				head.y-=1;
				
				tail.x-=1;
				tail.y+=1;
			}
			return check;
		}
		
		public boolean surrounding() {
			if(mid.x==0||mid.y==0||mid.y==board.length-1||mid.x==board.length-1) return false;
			for (int i = 0; i <dx.length ; i++) {
				if(board[mid.x+dx[i]][mid.y+dy[i]]=='1') return false;
			}
			return true;
		}
		public String toString() {
			return "head : "+head.toString()+"\n"+
					"mid : "+mid.toString()+"\n" +
					"tail : "+tail.toString();
		}
	}
	public static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		char[][] board = new char[N][N];
		for (int i = 0; i < N; i++) {
			board[i]=br.readLine().toCharArray();
		}
		
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				System.out.print(board[i][j]+" ");
//			}
//			System.out.println();
//		}
		User.board=board;
		User.Position[] first = new User.Position[3];
		User.Position[] end = new User.Position[3];
		int idx = 0;
		int eidx = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(board[i][j]=='B') {
					first[idx]= new User.Position(i,j);
					idx++;
				}else if(board[i][j]=='E') {
					end[eidx]= new User.Position(i,j);
					eidx++;
				}
			}
		}
		User user = new User(first);
		boolean[][] check = new boolean[N][N];
		System.out.println(user.turn());
		DFS(false, 0, check, user, end);
		//못하면 false 되면 true 리턴...
		System.out.println(min);
	}
	public static void DFS(boolean turning, int count,boolean[][] check,User user, User.Position[] end) {
		if(user.head.eq(end[0])&&user.mid.eq(end[1])&&user.tail.eq(end[2])) {
			if(min>count) min=count;
			return;
		}
		check[user.mid.x][user.mid.y] = true;
		if(user.up()&&upCheck(check, user)) {
			DFS(false, count+1, check, user, end);
			user.down();
		}else if(downCheck(check, user)&&user.down()) {
			DFS(false, count+1, check, user, end);
			user.up();
		}else if(leftCheck(check, user)&&user.left()) {
			DFS(false, count+1, check, user, end);
			user.right();
		}else if(rightCheck(check, user)&&user.right()) {
			DFS(false, count+1, check, user, end);
			user.left();
		}else if(turning&&user.turn()) {
			DFS(true, count+1, check, user, end);
			user.turn();
		}
	}
	
	
	public static boolean upCheck(boolean[][] check,User user) {
		if(user.mid.x-1<0) return false;
		return check[user.mid.x-1][user.mid.y];
	}
	public static boolean downCheck(boolean[][] check,User user) {
		if(user.mid.x+1>=user.board.length) return false;
		return check[user.mid.x+1][user.mid.y];
	}
	public static boolean leftCheck(boolean[][] check,User user) {
		if(user.mid.y-1<0) return false;
		return check[user.mid.x][user.mid.y-1];
	}
	public static boolean rightCheck(boolean[][] check,User user) {
		if(user.mid.y+1>=user.board.length) return false;
		return check[user.mid.x][user.mid.y+1];
	}
}
