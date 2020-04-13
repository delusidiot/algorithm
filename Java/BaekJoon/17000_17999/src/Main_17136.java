import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
 
public class Main_17136 {
    static int MIN;
    static int[][] map;
    static int[] paper = { 0, 5, 5, 5, 5, 5 };
    static class Node {
        int x;
        int y;
        public Node(int x, int y) {
            super();
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        map = new int[10][10];
        List<Node> list = new ArrayList<Node>();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                int number = sc.nextInt();
                map[i][j] = number;
                if (number == 1) {
                    list.add(new Node(i, j));
                }
            }
        }
        MIN = Integer.MAX_VALUE;
        dfs(list, 0, 0);
        System.out.println(MIN == Integer.MAX_VALUE ? -1 : MIN);
    }

 
    private static void dfs(List<Node> list, int idx, int count) {
        if(MIN < count)
            return;
        if (idx == list.size()) {
            if (MIN > count)
                MIN = count;
            return;
        }
        Node p = list.get(idx);
        if (map[p.x][p.y] == 0) {
            dfs(list, idx + 1, count);
        }
        for (int i = 5; i >= 1; i--) {
            if (check(p, i)) {
                paper[i]--;
                for (int j = p.x; j < p.x + i; j++) {
                    for (int k = p.y; k < p.y + i; k++) {
                        map[j][k] = 0;
                    }
                }
                dfs(list, idx + 1, count + 1);
                paper[i]++;
                for (int j = p.x; j < p.x + i; j++) {
                    for (int k = p.y; k < p.y + i; k++) {
                        map[j][k] = 1;
                    }
                }
            }
        }
    }
 
    private static boolean check(Node p, int p_number) {
        if(paper[p_number] <= 0) {
            return false;
        }
        int x = p.x;
        int y = p.y;
        boolean flag = false;
        out: for (int i = x; i < x + p_number; i++) {
            for (int j = y; j < y + p_number; j++) {
                if (i >= 0 && i < 10 && j >= 0 && j < 10) {
                    if (i == x + p_number - 1 && j == y + p_number - 1 && map[i][j] == 1) {
                        flag = true;
                        break out;
                    } else if (map[i][j] != 1) {
                        flag = false;
                        break out;
                    }
                }
            }
        }
        return flag;
    }
}