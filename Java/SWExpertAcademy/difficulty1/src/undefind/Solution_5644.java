package undefind;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution_5644 {
	static int[] dx= {0,-1,0,1,0};// 0   1 2 3 4
	static int[] dy= {0,0,1,0,-1};//이동x 상 우 하 좌
	public static class User{
		int x;
		int y;
		int battery;
		ArrayList<Integer> BC;
		public User(int x, int y) {
			super();
			this.x = x;
			this.y = y;
			this.battery=0;
		}
		@Override
		public String toString() {
			return "User [x=" + x + ", y=" + y + ", battery=" + battery + ", BC=" + BC + "]";
		}
	}
	public static class BC{
		int number;
		int x;
		int y;
		int C;
		int P;
		public BC(int number, int x, int y, int c, int p) {
			super();
			this.number = number;
			this.x = x;
			this.y = y;
			C = c;
			P = p;
		}
		@Override
		public String toString() {
			return "BC [number=" + number + ", x=" + x + ", y=" + y + ", C=" + C + ", P=" + P + "]";
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList <Integer>[][] map = null;
		int T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			map = new ArrayList[11][11];
			int M = sc.nextInt(); //총이동 시간
			int A = sc.nextInt(); //BC의 갯수
			int[] userAmove = new int[M];
			int[] userBmove = new int[M];
			
			for (int i = 1; i < 11; i++) {
				for (int j = 1; j < 11; j++) {
					map[i][j]=new ArrayList<>();
				}
			}
			for (int i = 0; i < M; i++) {
				userAmove[i]=sc.nextInt();
			}
			for (int i = 0; i < M; i++) {
				userBmove[i]=sc.nextInt();
			}
			BC[] bc = new BC[A+1];
			for (int i = 1; i < A+1; i++) {
				bc[i]=new BC(i, sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
				DFS(map,bc[i].y,bc[i].x,bc[i],0);
			}
			for (int i = 1; i < 11; i++) {
				for (int j = 1; j < 11; j++) {
					System.out.print(map[i][j]+"\t");
				}
				System.out.println();
			}
//			for (int i = 1; i < bc.length; i++) {
//				System.out.println(bc[i]);
//			}
			
			
			User Aman = new User(1, 1);
			int max = 0;
			if(map[1][1].size()>0) {
				for (int i = 0; i < map[1][1].size(); i++) {
					if(max<bc[map[1][1].get(i)].P)
						max=bc[map[1][1].get(i)].P;
				}
				Aman.battery+=max;
			}
			max = 0;
			User Bman = new User(10,10);
			if(map[10][10].size()>0) {
				for (int i = 0; i < map[10][10].size(); i++) {
					if(max<bc[map[10][10].get(i)].P)
						max=bc[map[10][10].get(i)].P;
				}
				Bman.battery+=max;
			}
			//이동 시작!!!
			for (int i = 0; i < M; i++) {
				/////이동 
				Aman.x+=dx[userAmove[i]];
				Aman.y+=dy[userAmove[i]];
				Bman.x+=dx[userBmove[i]];
				Bman.y+=dy[userBmove[i]];
				
				
				//배터리 채우기
				Aman.BC = map[Aman.x][Aman.y];
				Bman.BC = map[Bman.x][Bman.y];
				int Amax = 0;
				int Anumber = 0;
				for (int j = 0; j < map[Aman.x][Aman.y].size(); j++) {
					int p = bc[map[Aman.x][Aman.y].get(j)].P;
					if(Amax<p) {
						Amax=p;
						Anumber=bc[map[Aman.x][Aman.y].get(j)].number;
					}
				}
				int Bmax = 0;
				int Bnumber = 0;
				for (int j = 0; j < map[Bman.x][Bman.y].size(); j++) {
					int p = bc[map[Bman.x][Bman.y].get(j)].P;
					if(Bmax<p) {
						Bmax=p;
						Bnumber=bc[map[Bman.x][Bman.y].get(j)].number;
					}
				}
				if(Bnumber==Anumber&&Anumber!=0) {
					if(Aman.BC.size()==1&&Bman.BC.size()==1) {
						Aman.battery+=(bc[Anumber].P/2);
						Bman.battery+=(bc[Anumber].P/2);
					}
					else if(Aman.BC.size()==1){
						Aman.battery+=bc[Anumber].P;
						Bmax=0;
						for (int j = 0; j < map[Bman.x][Bman.y].size(); j++) {
							int p = bc[map[Bman.x][Bman.y].get(j)].P;
							if(bc[map[Bman.x][Bman.y].get(j)].number==Anumber)continue;
							if(Bmax<p) {
								Bmax=p;
								Bnumber=bc[map[Bman.x][Bman.y].get(j)].number;
							}
						}
						if(Bmax!=0) {
							Bman.battery+=bc[Bnumber].P;
						}
					}
					else if(Bman.BC.size()==1){
						Bman.battery+=bc[Bnumber].P;
						Amax=0;
						for (int j = 0; j < map[Aman.x][Aman.y].size(); j++) {
							int p = bc[map[Aman.x][Aman.y].get(j)].P;
							if(bc[map[Aman.x][Aman.y].get(j)].number==Bnumber)continue;
							if(Amax<p) {
								Amax=p;
								Anumber=bc[map[Aman.x][Aman.y].get(j)].number;
							}
						}
						if(Amax!=0) {
							Aman.battery+=bc[Anumber].P;
						}
					}
					else {
						int save = Anumber;
						Bmax=0;
						for (int j = 0; j < map[Bman.x][Bman.y].size(); j++) {
							int p = bc[map[Bman.x][Bman.y].get(j)].P;
							if(bc[map[Bman.x][Bman.y].get(j)].number==save)continue;
							if(Bmax<p) {
								Bmax=p;
								Bnumber=bc[map[Bman.x][Bman.y].get(j)].number;
							}
						}
						Amax=0;
						for (int j = 0; j < map[Aman.x][Aman.y].size(); j++) {
							int p = bc[map[Aman.x][Aman.y].get(j)].P;
							if(bc[map[Aman.x][Aman.y].get(j)].number==save)continue;
							if(Amax<p) {
								Amax=p;
								Anumber=bc[map[Aman.x][Aman.y].get(j)].number;
							}
						}
						if(Amax>Bmax) {
							Bman.battery+=bc[save].P;
							Aman.battery+=bc[Anumber].P;
						}else {
							Bman.battery+=bc[Bnumber].P;
							Aman.battery+=bc[save].P;
						}
					}
				}else {
					if(bc[Anumber]!=null)
						Aman.battery+=bc[Anumber].P;
					if(bc[Bnumber]!=null)
						Bman.battery+=bc[Bnumber].P;
				}
				
				
				
			}
			
//			System.out.println(Aman);
//			System.out.println(Bman);
			System.out.println("#"+testCase+" "+(Aman.battery+Bman.battery));
		}
	}
	public static void DFS(ArrayList<Integer>[][] map,int x, int y,BC bc,int count) {
		if(count>bc.C) {
			return;
		}
		boolean check=true;
		for (int i = 0; i < map[x][y].size(); i++) {
			if(map[x][y].get(i)==bc.number)check=false;
		}
		if(check)map[x][y].add(bc.number);
		for (int i = 1; i < 5; i++) {
			int nx= x+dx[i];
			int ny= y+dy[i];
			if(nx>=11||nx<1||ny>=11||ny<1)continue;
			DFS(map,nx,ny,bc,count+1);
		}
	}
}
