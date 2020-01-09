import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_3425 {
	static BufferedReader br;
	static BufferedWriter bw;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		while(true) {
			LinkedList<String> commands= new LinkedList<>();
			LinkedList<Stack<Long>> input = new LinkedList<>();
			StringTokenizer st =null;
			String command = null;
			while(!(command = br.readLine()).equals("END")) {
				if(command.equals("QUIT")) {
					bw.flush();
					bw.close();
					return;
				}else {
					commands.add(command);
				}
			}
			commands.add("END");
			
			long num = Long.parseLong(br.readLine());
			for (int i = 0; i < num; i++) {
				input.add(new Stack<>());
				input.get(i).add(Long.parseLong(br.readLine()));
				out:for (int c = 0; c < commands.size(); c++) {
					st = new StringTokenizer(commands.get(c)," ");
					long first = 0;
					long second = 0;
					
					switch(st.nextToken()) {
					case "NUM"://X를 스택의 가장 위에 저장한다. (0 ≤ X ≤ 109)
						String numstr=st.nextToken();
						input.get(i).add(Long.parseLong(numstr));						
						break;
					case "POP"://스택 가장 위의 숫자를 제거한다.
						if(input.get(i).isEmpty()) {
							bw.append("ERROR\n");
							break out;
						}
						input.get(i).pop();
						break;
					case "INV"://첫 번째 수의 부호를 바꾼다. (42 -> -42)
						if(input.get(i).isEmpty()) {
							bw.append("ERROR\n");
							break out;
						}
						first = input.get(i).pop();
						input.get(i).add(-first);
						break;
					case "DUP"://첫 번째 숫자를 하나 더 스택의 가장 위에 저장한다.
						if(input.get(i).isEmpty()) {
							bw.append("ERROR\n");
							break out;
						}
						first = input.get(i).peek();
						input.get(i).add(first);
						break;
					case "SWP"://첫 번째 숫자와 두 번째 숫자의 위치를 서로 바꾼다.
						if(input.get(i).size()<=1) {
							bw.append("ERROR\n");
							break out;
						}
						first = input.get(i).pop();
						second = input.get(i).pop();
						input.get(i).add(second);
						input.get(i).add(first);
						break;
					case "ADD"://첫 번째 숫자와 두 번째 숫자를 더한다.
						if(input.get(i).size()<=1) {
							bw.append("ERROR\n");
							break out;
						}
						first = input.get(i).pop();
						second = input.get(i).pop();
						input.get(i).add(first+second);
						break;
					case "SUB"://첫 번째 숫자와 두 번째 숫자를 뺀다. (두 번째 - 첫 번째)
						if(input.get(i).size()<=1) {
							bw.append("ERROR\n");
							break out;
						}
						first = input.get(i).pop();
						second = input.get(i).pop();
						input.get(i).add(second-first);
						break;
					case "MUL"://첫 번째 숫자와 두 번째 숫자를 곱한다.
						if(input.get(i).size()<=1) {
							bw.append("ERROR\n");
							break out;
						}
						first = input.get(i).pop();
						second = input.get(i).pop();
						input.get(i).add(second*first);
						break;
					case "DIV"://첫 번째 숫자로 두 번째 숫자를 나눈 몫을 저장한다. 두 번째 숫자가 피제수, 첫 번째 숫자가 제수이다.
						if(input.get(i).size()<=1) {
							bw.append("ERROR\n");
							break out;
						}
						first = input.get(i).pop();
						second = input.get(i).pop();
						if(first==0||second==0) {
							bw.append("ERROR\n");
							break out;
						}
						if(first<0||second<0) {
							input.get(i).add(Math.abs(second)/Math.abs(first));
						}
						else {
							input.get(i).add(second/first);
						}
						break;
					case "MOD"://첫 번째 숫자로 두 번째 숫자를 나눈 나머지를 저장한다. 두 번째 숫자가 피제수, 첫 번째 숫자가 제수이다.
						if(input.get(i).size()<=1) {
							bw.append("ERROR\n");
							break out;
						}
						first = input.get(i).pop();
						second = input.get(i).pop();
						if(first==0||second==0) {
							bw.append("ERROR\n");
							break out;
						}
						if(first<0||second<0) {
							input.get(i).add(Math.abs(second)%Math.abs(first));
						}
						else {
							input.get(i).add(second%first);
						}
						break;
					case "END":
						long result = input.get(i).pop();
						if(input.get(i).size()>0 || result >1000000000) {
							bw.append("ERROR\n");
						}else {
							bw.append(String.valueOf(result)+'\n');
						}
						break;
					case "QUIT":
						return;
					default:
						break;
					}
				}
			}
			bw.append("\n");
			br.readLine();// 공백 제거
		}
	}
}
