import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

//Brainf**k 인터프리터
public class Main_3954 {
	static final int MAXLOOP = 50_000_000;
	static int[] loopRecord,arr;
	static Stack<Integer> stack;
	static int sm;
	static int sc;
	static int si;
	static String commands;
	static String input;
	
	public static void loopIdxRecorder() {
		for (int i = 0; i < sc; i++) {
			switch(commands.charAt(i)) {
			case '[':
				stack.add(i);
				break;
			case ']':
				int n = stack.pop();
				loopRecord[i] = n;
				loopRecord[n] = i;
				break;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		
		for (int T = 1; T <= testCase; T++) {
			stack = new Stack<>();
			
			st = new StringTokenizer(br.readLine());
			sm = Integer.parseInt(st.nextToken()); //배열의크기 최대 100_000
			sc = Integer.parseInt(st.nextToken()); //프로그램 코드의 크기 최대 4096
			si = Integer.parseInt(st.nextToken()); //입력의 크기  4096
			loopRecord = new int[sc];
			arr = new int[sm];
			
			commands = br.readLine();
			input = br.readLine();
			
			loopIdxRecorder();
			boolean flag = false;
			
			int idx = 0; //배열의 포인터
			int commandIdx = 0; // 명령어의 포인터
			int inputIdx = 0; // 입력값의 포인터
			int maxCommandIdx = 0; // 마지막으로 만난 ']'의 포인터
			for (int i = 0; i < MAXLOOP; i++) { // 최대까지 걍 돌려 봅시다.
				if(commandIdx >= sc) {
					System.out.println("Terminates");
					flag = true;
					break;
				}
				switch(commands.charAt(commandIdx)) {
				case '-':
					arr[idx] = (arr[idx] - 1) < 0 ? 255 : arr[idx] - 1;
					break;
				case '+':
					arr[idx] = (arr[idx] + 1) % 256;
					break;
				case '<':
					idx = idx - 1 < 0 ? sm - 1 : idx - 1;
					break;
				case '>':
					idx = (idx + 1) % sm;
					break;
				case '[':
					if (arr[idx] == 0) {
						commandIdx = loopRecord[commandIdx];
	                }
					break;
				case ']':
					if (arr[idx] != 0) {
						commandIdx = loopRecord[commandIdx];
	                }
					break;
				case '.':
					//출력은 무시 함.
					break;
				case ',':
	                arr[idx] = inputIdx >= si ? 255 : (int)input.charAt(inputIdx);
	                inputIdx = inputIdx >= si ? inputIdx : inputIdx + 1;
					break;
				default:
					break;
				}
				commandIdx++;
				maxCommandIdx = commandIdx > maxCommandIdx ? commandIdx : maxCommandIdx;
			}
			
			if (!flag) {
	        	System.out.println("Loops "+loopRecord[maxCommandIdx]+" "+maxCommandIdx);
	        }
		}
	}
	
}
