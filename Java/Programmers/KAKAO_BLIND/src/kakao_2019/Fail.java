package kakao_2019;

import java.util.Arrays;

public class Fail {

	public static void main(String[] args) {
		Fail f = new Fail();
		int N = 5;
		int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
		System.out.println(Arrays.toString(f.solution(N, stages)));
	}
	public int[] solution(int N, int[] stages) {
		FailInfo[] fails = new FailInfo[N];
		int[] counter = new int[500];
		for (int i = 0; i < stages.length; i++) {
			counter[stages[i]-1]++;
		}
		int denominator = stages.length;
		for (int i = 0; i < fails.length; i++) {
			fails[i] = new FailInfo(i+1, denominator != 0 ? ((double)counter[i] / (double)denominator) : 0);
			denominator-=counter[i];
		}
		System.out.println(Arrays.toString(fails));
		Arrays.sort(fails);
		System.out.println(Arrays.toString(fails));
        int[] answer = new int[N];
        for (int i = 0; i < answer.length; i++) {
			answer[i] = fails[i].index;
		}
        return answer;
    }
}
class FailInfo implements Comparable<FailInfo>{
	int index;
	double percentage;
	
	public FailInfo(int index, double percentage) {
		super();
		this.index = index;
		this.percentage = percentage;
	}

	@Override
	public int compareTo(FailInfo o) {
		if(o.percentage>= this.percentage) return 1;
		else return -1;
	}

	@Override
	public String toString() {
		return "FailInfo [index=" + index + ", percentage=" + percentage + "]";
	}
}
