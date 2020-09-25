import java.awt.Checkbox;
import java.util.*;


public class Kakao4 {
	public static void main(String[] args) {
		Kakao4 k = new Kakao4();
		int[][] fares = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};
		int n = 6;
		int s = 4;
		int a = 6;
		int b = 2;
		System.out.println(k.solution(n, s, a, b, fares));
		int[][] fares2 = {{5, 7, 9}, {4, 6, 4}, {3, 6, 1}, {3, 2, 3}, {2, 1, 6}};
		n = 7;
		s = 3;
		a = 4;
		b = 1;
		System.out.println(k.solution(n, s, a, b, fares2));
		
	}
	public int solution(int n, int s, int a, int b, int[][] fares) {
		Graph g = new Graph(n);
		for (int i = 0; i < fares.length; i++) {
			g.input(fares[i][0], fares[i][1], fares[i][2]);
		}

        int answer = g.dijkstra(s, a);
        g = new Graph(n);
        for (int i = 0; i < fares.length; i++) {
			g.input(fares[i][0], fares[i][1], fares[i][2]);
		}
        answer += g.dijkstra(a, b);
        g = new Graph(n);
        for (int i = 0; i < fares.length; i++) {
			g.input(fares[i][0], fares[i][1], fares[i][2]);
		}
        int answer2 = g.dijkstra(s, a);
        g = new Graph(n);
        for (int i = 0; i < fares.length; i++) {
			g.input(fares[i][0], fares[i][1], fares[i][2]);
		}
        answer += g.dijkstra(s, b);
        System.out.println(answer + " " + answer2);
        return answer;
    }
}
class Graph{
    private int n;           //노드들의 수
    private int maps[][];    //노드들간의 가중치 저장할 변수
 
    public Graph(int n){
        this.n = n;
        maps = new int[n+1][n+1];
    }
    public void input(int i,int j,int w){
        maps[i][j] = w;
        maps[j][i] = w;
    }
 
    public int dijkstra(int v, int end){
        int distance[] = new int[n+1];
        boolean[] check = new boolean[n+1];
        for(int i=1;i<n+1;i++){
            distance[i] = Integer.MAX_VALUE;
        }
        distance[v] =0;
        check[v] =true;
         
        for(int i=1;i<n+1;i++){
            if(!check[i] && maps[v][i] !=0){
                distance[i] = maps[v][i];
            }
        }
         
         
        for(int a=0;a<n-1;a++){
            //원래는 모든 노드가 true될때까지 인데
            //노드가 n개 있을 때 다익스트라를 위해서 반복수는 n-1번이면 된다.
            //원하지 않으면 각각의 노드가 모두 true인지 확인하는 식으로 구현해도 된다.
            int min=Integer.MAX_VALUE;
            int min_index=-1;
             
            //최소값 찾기
            for(int i=1;i<n+1;i++){
                if(!check[i] && distance[i]!=Integer.MAX_VALUE){
                    if(distance[i]<min ){
                        min=distance[i];
                        min_index = i;
                    }
                }
            }
            if(min_index == -1) continue;
            check[min_index] = true;
            for(int i=1;i<n+1;i++){
                if(!check[i] && maps[min_index][i]!=0){
                    if(distance[i]>distance[min_index]+maps[min_index][i]){
                        distance[i] = distance[min_index]+maps[min_index][i];
                    }
                }
            }
 
        }
         
        //결과값 출력
        for(int i=1;i<n+1;i++){
            System.out.print(distance[i]+" ");
        }
        System.out.println();
        return distance[end];
    }
}
