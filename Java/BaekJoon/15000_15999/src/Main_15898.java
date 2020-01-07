import java.util.Scanner;
import java.util.StringTokenizer;

//피아의 아틀리에 ~신비한 대회의 연금술사~
public class Main_15898 {
	static class Material {
		public int effect;
		public char element;

		public Material(int effect, char element) {
			this.effect = effect;
			this.element = element;
		}
		@Override
		public String toString() {
			return "[" + effect + "/" + element + "]";
		}
	}
	static int MAXQUALITY = 0;
	static Material[][][] materials;
	static int n;
	static Scanner sc;
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		n = sc.nextInt();//재료의 개수
		materials = new Material[n][4][4];
		sc.nextLine();
		StringTokenizer str = null;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 4; j++) {
				for (int k = 0 ;k < 4; k++) {
					materials[i][j][k] = new Material(0, 'W');
				}
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 4; j++) {
				str = new StringTokenizer(sc.nextLine());
				for (int k = 0 ;k < 4; k++) {
					materials[i][j][k].effect = Integer.parseInt(str.nextToken());
				}
			}
			for (int j = 0; j < 4; j++) {
				str = new StringTokenizer(sc.nextLine());
				for (int k = 0 ;k < 4; k++) {
					materials[i][j][k].element = str.nextToken().charAt(0);
				}
			}
		}
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i]=i;
		}
		permutation(arr, 3);
		System.out.println(MAXQUALITY);
	}
	
	public static void permutation(int[] arr, int destNum) {
		permutation(arr, 0, destNum);
	}
	public static void permutation(int[] arr, int curNum, int destNum) {
		if(curNum==destNum) {
			run(arr[0],arr[1],arr[2]);
			return;
		}
		for(int i = 0; i+curNum < arr.length; i++) {
			swap(arr, curNum, curNum+i);
			permutation(arr,curNum+1,destNum);
			swap(arr, curNum, curNum+i);			
		}
	}
	public static void swap(int[] arr, int origin, int changer) {
		int temp = arr[origin];
		arr[origin] = arr[changer];
		arr[changer] = temp;
	}
	
	public static void run(int a, int b ,int c) {
		for (int i = 0; i < 4; i++) {
			rotate(materials[a], 4);
			for (int j = 0; j < 4; j++) {
				rotate(materials[b], 4);
				for (int k = 0; k < 4; k++) {
					rotate(materials[c], 4);
					alchemy(materials[a],materials[b],materials[c]);
				}
			}
		}
	}
	public static void alchemy(Material[][] A, Material[][] B, Material[][] C) {
		for (int i = 0; i < 4; i++) {
			Material[][] potA = new Material[5][5];
			for (int j = 0; j < 5; j++) {
				for (int k = 0; k < 5; k++) {
					potA[j][k] = new Material(0, 'W');
				}
			}
			put(i, potA, A);
			for (int j = 0; j < 4; j++) {
				Material[][] potB = arraycopy(potA, 5);
				put(j, potB, B);
				for (int k = 0; k < 4; k++) {
					Material[][] potC = arraycopy(potB, 5);
					put(k, potC, C);
					MAXQUALITY = Math.max(MAXQUALITY, bombQuality(potC));
					
				}
			}
		}
	}
	public static void put(int i, Material[][] pot, Material[][] material) {
		if (i == 0)
			boil(0, 0, pot, material);
		else if (i == 1)
			boil(0, 1, pot, material);
		else if (i == 2)
			boil(1, 0, pot, material);
		else
			boil(1, 1, pot, material);
	}
	public static void boil(int x, int y, Material[][] pot, Material[][] material) {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				int effect = pot[i + y][j + x].effect + material[i][j].effect;
				char element = material[i][j].element;
				pot[i + y][j + x].effect = (effect < 0) ? 0 : (effect > 9) ? 9 : effect;
				pot[i + y][j + x].element = (element == 'W') ? pot[i + y][j + x].element : element;
			}
		}
	}
	
	public static void rotate(Material[][] material,int size) {
		Material[][] temp = new Material[size][size];
		for (int i = 0; i < size; i++) {
			System.arraycopy(material[i], 0, temp[i], 0, size);
		}
		int ni = 0;
		int nj = 0;
		for (int i = 0; i < size; i++) {
			for (int j = size-1; j >= 0; j--) {
				material[i][j] = temp[ni++][nj];
			}
			ni=0;
			nj++;
		}
	}
	private static Material[][] arraycopy(Material[][] array, int size) {
		Material[][] temp = new Material[size][size];
		for (int i = 0; i < size; i++)
			for (int j = 0; j < size; j++)
				temp[i][j] = new Material(array[i][j].effect, array[i][j].element);
		return temp;
	}
	public static int bombQuality(Material[][] meterial) {
		int R = 0;
		int B = 0;
		int G = 0;
		int Y = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				switch(meterial[i][j].element) {
				case 'R':
					R += meterial[i][j].effect;
					break;
				case 'B':
					B += meterial[i][j].effect;
					break;
				case 'G':
					G += meterial[i][j].effect;
					break;
				case 'Y':
					Y += meterial[i][j].effect;
					break;
				}
			}
		}
		return (7*R)+(5*B)+(3*G)+(2*Y);
	}
}
