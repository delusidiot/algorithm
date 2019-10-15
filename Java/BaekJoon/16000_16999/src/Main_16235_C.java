import java.util.ArrayList;
import java.util.Scanner;

public class Main_16235_C {
	public static int[] dx = {1,1,1,0,0,-1,-1,-1};
	public static int[] dy = {1,0,-1,1,-1,1,0,-1};
	public static class Soil{
		class Tree{
			int z;
			public Tree(int z) {
				super();
				this.z = z;//나이
			}
			@Override
			public String toString() {
				return "[" + z + "]";
			}
		}
		ArrayList<Tree> trees = null;
		int nutriment = 0;
		public Soil(int nutriment) {
			super();
			this.nutriment = nutriment;
			this.trees = new ArrayList<>();
		}
		public void add(int z) {
			int idx = 0;
			if(trees.size()==0) {
				trees.add(new Tree(z));
				return;
			}
			while(trees.size()>idx&&trees.get(idx).z<z) {
				idx ++;
			}
			trees.add(idx,new Tree(z));
		}
		public void remove(int idx) {
			trees.remove(idx);
		}
		public int get(int idx) {
			return trees.get(idx).z;
		}
		public void setOld(int idx) {
			trees.get(idx).z++;
		}
		@Override
		public String toString() {
			return "Soil [t=" + trees + ", n=" + nutriment + "]";
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();//땅 크기
		int M = sc.nextInt();//심어진 나무 갯수
		int K = sc.nextInt();// K년후
		Soil[][] soil= new Soil[N+1][N+1];
		int[][] A = new int[N+1][N+1];//겨울 양분  
		for (int i = 1; i < N+1; i++) {//양분 넣기
			for (int j = 1; j < N+1; j++) {
				A[i][j] = sc.nextInt();
				soil[i][j]=new Soil(5);
			}
		}
		for (int i = 0; i < M; i++) {
			int x = sc.nextInt();//나무의 위치 x//M개의 줄로...
			int y = sc.nextInt();//나무의 위치 y
			int z = sc.nextInt();//나무의 나이
			soil[x][y].add(z);
		}
//		System.out.println("처음 입력");
//		for (int i = 1; i < soil.length; i++) {
//			System.out.println(Arrays.toString(soil[i]));	
//		}
//		System.out.println();
		for (int k = 0; k < K; k++) {//K년 동안...
			
			for (int i = 1; i < N+1; i++) {
				for (int j = 1; j < N+1; j++) {
					int t = 0;
					int nut = 0;
					while(t < soil[i][j].trees.size()) {
						if(soil[i][j].trees.get(t).z <= soil[i][j].nutriment) {//봄
							soil[i][j].nutriment -= soil[i][j].get(t);
							soil[i][j].setOld(t);
							t++;
						}else {
							int old = soil[i][j].get(t);
							soil[i][j].remove(t);
							nut+=old/2;
						}//여름
					}
					soil[i][j].nutriment+=nut;//여름
				}
			}
//			System.out.println("봄/여름 : "+(k+1));
//			for (int i = 1; i < soil.length; i++) {
//				System.out.println(Arrays.toString(soil[i]));	
//			}
//			System.out.println();
			//가을
			//겨울
			for (int i = 1; i < N+1; i++) {
				for (int j = 1; j < N+1; j++) {
					int size = soil[i][j].trees.size();
					for (int t = 0; t < size; t++) {
						if(soil[i][j].get(t)%5==0) {//5의 배수//가을
							for (int l = 0; l < dx.length; l++) {
								int x = i+dx[l];
								int y = j+dy[l];
								if(x<=0||x>N||y<=0||y>N) continue;
								soil[x][y].add(1);
							}
						}
					}
					soil[i][j].nutriment+=A[i][j];
				}
			}
//			System.out.println("가을/겨울 : " + (k+1));
//			int test = 0;
//			for (int i = 1; i < soil.length; i++) {
//				System.out.println(Arrays.toString(soil[i]));
//				for (int j = 1; j < N+1; j++) {
//					test+=soil[i][j].trees.size();
//				}
//			}
//			System.out.println(test+"개");
//			System.out.println();
		}
//		System.out.println("마지막 결과");
//		for (int i = 1; i < soil.length; i++) {
//			System.out.println(Arrays.toString(soil[i]));	
//		}
//		System.out.println();
		int result = 0;
		
		for (int i = 1; i < N+1; i++) {
			for (int j = 1; j < N+1; j++) {
				result+=soil[i][j].trees.size();
//				System.out.print(A[i][j]+" ");
			}
//			System.out.println();
		}
		System.out.println(result);
	}
	
}
