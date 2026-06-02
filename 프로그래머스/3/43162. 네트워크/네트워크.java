import java.util.*;
class Solution {
    static int n;
    static int[] parent;
    public int solution(int n, int[][] computers) {
        this.n = n;
        parent = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
        int answer = n;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(computers[i][j] == 1){
                    if(find(i) != find(j)){
                        union(i, j);
                        answer--;
                    }
                }
            }
        }
        return answer;
    }
    public static void union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);
        if(rootA != rootB){
            parent[rootB] = rootA;
        }
    }
    public static int find(int x){
        if(parent[x] == x){
            return x;
        }
        return parent[x] = find(parent[x]);
    }
}