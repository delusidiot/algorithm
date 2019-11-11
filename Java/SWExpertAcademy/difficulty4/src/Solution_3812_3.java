import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Solution_3812_3 {
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb;
        int T = Integer.parseInt(br.readLine()); 
        for(int tc=1;tc<=T;tc++) {
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken()); 
            int Y = Integer.parseInt(st.nextToken()); 
            int Z = Integer.parseInt(st.nextToken()); 
            int A = Integer.parseInt(st.nextToken()); 
            int B = Integer.parseInt(st.nextToken()); 
            int C = Integer.parseInt(st.nextToken()); 
            int N = Integer.parseInt(st.nextToken()); 
             
             
            long[] count = new long[N];
            long[] result = new long[N];
            long[] rowA = new long[N];
            long[] rowB = new long[N];
            long[] rowC = new long[N];
             
            for(int i=0;i<Y;i++) {
                rowA[(Math.abs(i-B))%N]++;
            }//A,Y,C층
            System.out.println(Arrays.toString(rowA));
            for(int i=0;i<X;i++) {
                rowB[(Math.abs(i-A))%N]++;
            }
            System.out.println(Arrays.toString(rowB));
            for(int i=0;i<Z;i++) {
                rowC[(Math.abs(i-C))%N]++;
            }
            System.out.println(Arrays.toString(rowC));
             
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    count[(i+j)%N] += rowA[i]* rowB[j];
                }
            }
            System.out.println(Arrays.toString(count));
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    result[(i+j)%N] += rowC[i] * count[j];
                }
            }
             
            sb= new StringBuilder("#");
            sb.append(tc);
            for(long i:result) {
                sb.append(" ");
                sb.append(i);
            }
            System.out.println(sb.toString());
        }
    }
}