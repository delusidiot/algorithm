import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_3425_2 {
	static BufferedReader br;
	static final long MAX = 1000000000;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		LinkedList<String> commands= new LinkedList<>();
		Stack<Long> stack = new Stack<>();
		StringTokenizer st =null;
		String command = null;
		while(true) {
			st = null;
			command = null;
			commands.clear();
			while(!(command = br.readLine()).equals("END")) {
				if(command.equals("QUIT")) {
					System.out.print(sb.toString());
					return;
				}else {
					commands.add(command);
				}
			}
			commands.add("END");
			int num = Integer.parseInt(br.readLine());
			for (int i = 0; i < num; i++) {
				stack.clear();
				stack.push(Long.parseLong(br.readLine()));
				int size = commands.size();
				boolean flag = true;
				for (int c = 0; c < size; c++) {
					st = new StringTokenizer(commands.get(c)," ");
					long first = 0;
					long second = 0;
					long result = 0;
					switch(st.nextToken().trim()) {
					case "NUM"://X를 스택의 가장 위에 저장한다. (0 ≤ X ≤ 10^9)
						stack.push(Long.parseLong(st.nextToken()));						
						break;
					case "POP"://스택 가장 위의 숫자를 제거한다.
						if(stack.isEmpty()) {
							flag=false;
							break;
						}
						stack.pop();
						break;
					case "INV"://첫 번째 수의 부호를 바꾼다. (42 -> -42)
						if(stack.isEmpty()) {
							flag=false;
							break;
						}
						stack.push(-1*stack.pop());
						break;
					case "DUP"://첫 번째 숫자를 하나 더 스택의 가장 위에 저장한다.
						if(stack.isEmpty()) {
							flag=false;
							break;
						}
						stack.push(stack.peek());
						break;
					case "SWP"://첫 번째 숫자와 두 번째 숫자의 위치를 서로 바꾼다.
						if(stack.size() < 2) {
							flag=false;
							break;
						}
						first = stack.pop();
						second = stack.pop();
						stack.push(first);
						stack.push(second);
						break;
					case "ADD"://첫 번째 숫자와 두 번째 숫자를 더한다.
						if(stack.size() < 2) {
							flag=false;
							break;
						}
						first = stack.pop();
						second = stack.pop();
						result = first+second;
						if(Math.abs(result) > MAX) {
							flag=false;
							break;
						}
						stack.push(result);
						break;
					case "SUB"://첫 번째 숫자와 두 번째 숫자를 뺀다. (두 번째 - 첫 번째)
						if(stack.size() < 2) {
							flag=false;
							break;
						}
						first = stack.pop();
						second = stack.pop();
						result = second - first;
						if(Math.abs(result) > MAX) {
							flag=false;
							break;
						}
						stack.push(result);
						break;
					case "MUL"://첫 번째 숫자와 두 번째 숫자를 곱한다.
						if(stack.size() < 2) {
							flag=false;
							break;
						}
						first = stack.pop();
						second = stack.pop();
						result = second * first;
						if(Math.abs(result) >MAX) {
							flag=false;
							break;
						}
						stack.push(result);
						break;
					case "DIV"://첫 번째 숫자로 두 번째 숫자를 나눈 몫을 저장한다. 두 번째 숫자가 피제수, 첫 번째 숫자가 제수이다.
						if(stack.size() < 2) {
							flag=false;
							break;
						}
						first = stack.pop();
						second = stack.pop();
						if(first == 0) {
							flag=false;
							break;
						}
						result = second/first;
						if(Math.abs(result) >MAX) {
							flag=false;
							break;
						}
						stack.push(result);
						break;
					case "MOD"://첫 번째 숫자로 두 번째 숫자를 나눈 나머지를 저장한다. 두 번째 숫자가 피제수, 첫 번째 숫자가 제수이다.
						if(stack.size() <2) {
							flag=false;
							break;
						}
						first = stack.pop();
						second = stack.pop();
						if(first==0) {
							flag=false;
							break;
						}
						result = second%first;
						if(Math.abs(result) >MAX) {
							flag=false;
							break;
						}
						stack.push(result);
						break;
					case "END":
						if(stack.size()!=1) {
							flag=false;
						}else {
							result = stack.pop();
							if(Math.abs(result) > MAX) flag=false;
							else sb.append(String.valueOf(result)+'\n');
						}
						break;
					default:
						break;
					}
					if(!flag) {
						sb.append("ERROR\n");
						break;
					}
				}
			}
			sb.append("\n");
			br.readLine();// 공백 제거
		}
	}
}
