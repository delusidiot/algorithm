package line;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution2 {
	static int[] arr;
	static ArrayList<Integer> permutation;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		int k = sc.nextInt();
		String[] numbers = line.split(" ");
		permutation = new ArrayList<Integer>();
		arr = new int[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			arr[i]=Integer.parseInt(numbers[i]);
			
		}
		permutation(arr, 0, numbers.length, numbers.length);
		Collections.sort(permutation);
        System.out.println(permutation.get(k-1));
	}
    static void permutation(int[] arr, int depth, int n, int r) {
        if(depth == r) {
            print(arr, r);
            return;
        }
        for(int i=depth; i<n; i++) {
            swap(arr, depth, i);
            permutation(arr, depth + 1, n, r);
            swap(arr, depth, i);
        }
    }
 
    static void swap(int[] arr, int depth, int i) {
        int temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }
    static void print(int[] arr, int r) {
    	StringBuilder sb = new StringBuilder();
    	for (int j = 0; j < arr.length; j++) {
    		sb.append(arr[j]);
    	}
    	permutation.add(Integer.parseInt(sb.toString()));
    }
}
