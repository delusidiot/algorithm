package userProblem;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Solution_7206 {
	public static int max = 0;
	public static long[] POW = {0,10,100,1000,10000,100000,1000000,10000000,100000000,
			1000000000,
			10000000000L,
			100000000000L,
			1000000000000L,
			10000000000000L,
			100000000000000L,
			1000000000000000L,
			10000000000000000L,
			100000000000000000L,
			1000000000000000000L};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			max =0;
			long number = sc.nextInt();// 3개 이상으로 나누는 경우를 실행`
//			DFS(number, 0);
			System.out.println("#"+testCase+" "+BFS(number));
		}
	}
	public static int BFS(long number) {
		Queue<Long> q = new LinkedList<>();
		Set<Long> set = new HashSet<>();
		q.add(number);
		int level = 0;
		while(!q.isEmpty()) {
			level++;
			int size = q.size();
//			System.out.println(q);
			for (int i = 0; i < size; i++) {
				number = q.poll();
				int length = (int)(Math.log10(number)+1);
				for (int j = 1; j < length; j++) {
					long a = number / POW[j];
					long b = number % POW[j];
					long length2 = (long)(Math.log10(b)+1);
//					System.out.print(level+", "+number+" : ");
					DFS2(set,a,b,length2);
//					System.out.println();
				}
				Iterator<Long> it = set.iterator();
				while(it.hasNext()) {
					q.add(it.next());
				}
				set.clear();
			}
		}
		return level-1;
	}
	public static void DFS2(Set<Long> set,long a,long b,long length) {
		set.add(a*b);
//		System.out.print(a+" ");
		if(length<=1) {
//			System.out.print(b+" ");
			return;
		}
		for (int i = 1; i < length ; i++) {
			long na = b/ POW[i];
			long nb = b% POW[i];
			DFS2(set,a*na,nb,(long)(Math.log10(nb)+1));
		}
	}
	public static void DFS(int number,int count) {
		if(number<10) {
			if(max<count)
				max=count;
		}
		int length = measure(number);
		for (int i = 1; i < length; i++) {
			int a = number / pow(i);
			int b = number % pow(i);
			
			int mul = a*b;
//			System.out.println(pow(i)+" "+i);
			System.out.println(count+" : "+a+" "+b+" = " +(a*b));
			DFS(a*b, count+1);
		}
		
	}
	
	public static int pow(int i) {
		int n=10;
		for (int j = 1; j < i; j++) {
			n*=10;
		}
		return n;
	}
	public static int measure(int number) {
		int length = 1;
		while(number/10!=0) {
			length ++;
			number/=10;
		}
		return length;
	}
}
