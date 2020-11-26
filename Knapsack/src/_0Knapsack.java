
import java.util.Scanner;

public class _0Knapsack {
    static int N; // 보석의 수
    static int W; // 배낭무게
    static int [] Wi; // 보석무게
    static int [] Pi; // 보석가치
    static int [][] D; // 다이나믹 배열
     
    static int max(int a,int b) {
        return (a>b) ? a : b;
    }
     
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
        N = sc.nextInt();
        W = sc.nextInt();
         
        Wi = new int[N+1];
        Pi = new int[N+1];
        D = new int[N+1][W+1];
         
        for(int i=1; i<=N; i++) {
            Wi[i] = sc.nextInt();
            Pi[i] = sc.nextInt();
        }
        //print(D);
         
        // i는 보석종류
        for(int i=1; i<=N; i++) {
            System.out.println(i);
            print(D);

            // j는 보석무게
            // 내 무게보다 작은 배낭은 이전에 구한값을 참고한다.
            for(int j=1; j<=W; j++) {
                if(j-Wi[i]<0) {
                    D[i][j] = D[i-1][j];
                } else {
                    // 현재 넣으려고 하고 배낭에서 나의 무게를 빼면
                    // 이전에 넣은 보석의 가치를 가지고 올 수 있다.
                    // 여기다가 내 가치를 더한값과 이전 배낭에서 구한값과
                    // 비교하여 더 좋은 값을 취한다.
                	
                   //System.out.println("D["+i+"]["+j+"] = max(D["+(i-1)+"]["+j+"-"+Wi[i]+"]+ Pi["+i+"],D["+(i-1)+"]["+j+"]);");

                    D[i][j] = max(D[i-1][j-Wi[i]] + Pi[i],D[i-1][j]);
                }
  
            }
        }
        System.out.println(D[N][W]);
        sc.close();
        
        print(D);
    }
    static void print(int[][]a) {
    	for(int i=1; i<=N; i++) {
            for(int j=1; j<=W; j++) {
            	System.out.print(D[i][j]+" ");
            }
            System.out.println();
    	}
    	System.out.println();
    }
}

/*
4 7
6 13
4 8
3 6
5 12

*/